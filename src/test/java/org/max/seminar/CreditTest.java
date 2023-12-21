package org.max.seminar;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreditTest extends AbstractTest {

    @Test
    @Order(1)
    void getCredits_whenValid_shouldReturn() throws SQLException {
        //given
        String sql = "SELECT * FROM credit";
        Statement stmt  = getConnection().createStatement();
        int countTableSize = 0;
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            countTableSize++;
        }
        final Query query = getSession().createSQLQuery(sql).addEntity(CreditEntity.class);
        //then
        Assertions.assertEquals(1, countTableSize);
        Assertions.assertEquals(1, query.list().size());
    }

    @Test
    @Order(2)
    void addCredit_whenValid_shouldSave() {
        //given
        CreditEntity entity = new CreditEntity();
        entity.setCreditId((short) 2);
        entity.setBalance("1000");
        entity.setCloseDate("2033-02-01 00:00:00");
        entity.setOpenDate("2033-02-01 00:00:00");
        entity.setNumber("100");
        entity.setSumm("1000000");
        entity.setStatus("Open");
        entity.setClient((short) 1);
        entity.setEmployee((short) 1);
        //when
        Session session = getSession();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();

        final Query query = getSession()
                .createSQLQuery("SELECT * FROM credit WHERE credit_id="+2).addEntity(CreditEntity.class);
        CreditEntity creditEntity = (CreditEntity) query.uniqueResult();
        //then
        Assertions.assertNotNull(creditEntity);
        Assertions.assertEquals("1000", creditEntity.getBalance());
    }

    @Test
    @Order(3)
    void deleteCredit_whenValid_shouldDelete() {
        //given
        final Query query = getSession()
                .createSQLQuery("SELECT * FROM credit WHERE credit_id=" + 2).addEntity(CreditEntity.class);
        Optional<CreditEntity> creditEntity = (Optional<CreditEntity>) query.uniqueResultOptional();
        Assumptions.assumeTrue(creditEntity.isPresent());
        //when
        Session session = getSession();
        session.beginTransaction();
        session.delete(creditEntity.get());
/*        getSession().createQuery("delete from CreditEntity where creditId = :id")
                .setParameter("id", 2)
                .executeUpdate();*/
        session.getTransaction().commit();
        //then
        final Query queryAfterDelete = getSession()
                .createSQLQuery("SELECT * FROM credit WHERE credit_id=" + 2).addEntity(CreditEntity.class);
        Optional<CreditEntity> creditEntityAfterDelete = (Optional<CreditEntity>) queryAfterDelete.uniqueResultOptional();
        Assertions.assertFalse(creditEntityAfterDelete.isPresent());
    }
}
