package org.max.demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

/**
 * Демо для демонстрации взаимодействия с БД через hibernate
 */
public class HibernateTest {

    //Фабрика для создания подключений
    private static SessionFactory ourSessionFactory;

    //Инициализация фабрики
    @BeforeAll
    static void init() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    //Получение экземпляра сессии
    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    /**
     * Hibernate может использовать свой мощный язык запросов Hibernate Query Language, который очень похож на родной SQL.
     * В сравнении с SQL, HQL полностью объектно-ориентирован и использует понятия наследования, полиформизма и связывания.
     */
    @Test
    void testHQL() {
        final Query query = getSession().createQuery("from " + "EmployeeEntity");
        System.out.println("executing: " + query.getQueryString());

        List<EmployeeEntity> employeeEntities = query.list();
        for (EmployeeEntity entity : employeeEntities) {
            System.out.println("  " + entity);
            System.out.println("  " + entity.getName());
        }
        Assertions.assertEquals(3, employeeEntities.size());

        final Query queryWhere = getSession().createQuery("from " + "EmployeeEntity" + " where id=" + 2);
        System.out.println("executing: " + queryWhere.getQueryString());
        Optional<EmployeeEntity> employeeEntity = queryWhere.uniqueResultOptional();
        Assertions.assertTrue(employeeEntity.isPresent());
        Assertions.assertEquals(200, employeeEntity.get().getCapacity());
    }

    /**
     * Демонстрация поддержки нативных SQL запросов
     */
    @Test
    void testSQL() {
        final Query query = getSession().createSQLQuery("select * from employee").addEntity(EmployeeEntity.class);
        System.out.println("executing: " + query.getQueryString());
        List<EmployeeEntity> employeeEntities = query.list();
        for (EmployeeEntity entity : employeeEntities) {
            System.out.println("  " + entity);
            System.out.println("  " + entity.getName());
        }
        Assertions.assertEquals(3, employeeEntities.size());

        String sql = "select name, capacity from employee";
        Query queryNameAndCapacity = getSession().createSQLQuery(sql);

        List<Object[]> rows = queryNameAndCapacity.list();

        for(Object[] row : rows) {
            System.out.println(row[0].toString());
            System.out.println(row[1].toString());
        }
    }

    //Демонстрация добавления и удаление записи
    @Test
    void testAddAndDelete() {
        Integer id = 16;

        //Создаем объект через паттерн Строитель

        EmployeeEntity employeeEntity = new EmployeeEntityBuilder()
                .setId(id.shortValue())
                .setCapacity(1000d)
                .setName("Kail")
                .build();

        //В отличии от select любые изменения происходят в рамках транзакции одной сесии
        Session session = getSession();
        //Точка открытия транзакции
        session.beginTransaction();
        //Любые запросы
        session.persist(employeeEntity);
        //Закрытие транзакции
        session.getTransaction().commit();


        final Query queryWhere = session.createQuery("from " + "EmployeeEntity" + " where id=" + id);
        System.out.println("executing: " + queryWhere.getQueryString());
        Optional<EmployeeEntity> entity = queryWhere.uniqueResultOptional();
        Assertions.assertTrue(entity.isPresent());
        Assertions.assertEquals(1000, entity.get().getCapacity());

        EmployeeEntity employeeEntityFromBD = entity.get();

        //Точка открытия транзакции
        session.beginTransaction();
        //Любые запросы
        employeeEntityFromBD.setCapacity(2000d);
        session.merge(employeeEntityFromBD);
        //Закрытие транзакции
        session.getTransaction().commit();

        final Query queryWhereAfterUpdate = session.createQuery("from " + "EmployeeEntity" + " where id=" + id);
        System.out.println("executing: " + queryWhere.getQueryString());
        Optional<EmployeeEntity> entityAfterUpdate = queryWhereAfterUpdate.uniqueResultOptional();
        Assertions.assertTrue(entityAfterUpdate.isPresent());
        Assertions.assertEquals(2000, entityAfterUpdate.get().getCapacity());

        session.beginTransaction();
        session.createQuery("delete from EmployeeEntity where id = :id")
                .setParameter("id", id.shortValue())
                .executeUpdate();
        session.getTransaction().commit();

        final Query query = session.createQuery("from " + "EmployeeEntity");
        System.out.println("executing: " + query.getQueryString());

        List<EmployeeEntity> employeeEntities = query.list();
        Assertions.assertEquals(3, employeeEntities.size());

    }

    //Всегда закрываем подключение
    @AfterAll
    static void close() {
        getSession().close();
    }



}
