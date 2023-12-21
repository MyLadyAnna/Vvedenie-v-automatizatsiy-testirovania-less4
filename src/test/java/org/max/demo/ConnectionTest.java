package org.max.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * Демонстрация взаимодействия с СУБД через механизмы java.sql
 */
public class ConnectionTest {

    //Объект подключения
    private static Connection connection;
    @BeforeAll
    static void init() throws SQLException {
        connect("demo_simple_sql.db");
        createTable("CREATE TABLE IF NOT EXISTS employee_info\n" +
                "(id integer PRIMARY KEY,\n" +
                "first_name text NOT NULL,\n" +
                "last_name text NOT NULL,\n" +
                "phone_number text NOT NULL);");
        createTable("CREATE TABLE IF NOT EXISTS employee (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " capacity real,\n"
                + " info_id integer NOT NULL\n"
                + ");");
        insertEmployeeInfo(1,"Иван", "Иванов", "+7 927 0000001");
        insertEmployeeInfo(2,"Петр", "Петров", "+7 927 0000002");
        insertEmployeeInfo(3,"Сидор", "Сидоров", "+7 927 0000003");
        insertEmployeeValue(1,"MAX",100,1);
        insertEmployeeValue(2,"JAR",110,2);
        insertEmployeeValue(3,"IAN",90,3);
    }

    //Создание подключений к СУБД
    private static void connect(String name) {
        try {
            //Регистрация драйвера
            Class.forName("org.sqlite.JDBC");
            //Создание подключения
            connection = DriverManager.getConnection("jdbc:sqlite:"+name);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    //Создание произвольной таблицы
    private static void createTable(String sql) {
        try{
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Метод добавление записи в таблицу employee_info
    private static void insertEmployeeInfo(Integer id, String firstName, String lastName, String phone) {
        String sql = "INSERT INTO employee_info(id, first_name, last_name, phone_number) VALUES(?,?,?,?)";
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, phone);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Метод добавление записи в таблицу employee
    private static void insertEmployeeValue(Integer id, String name, double capacity, Integer info) {
        String sql = "INSERT INTO employee(id, name, capacity, info_id) VALUES(?,?,?,?)";
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, capacity);
            pstmt.setInt(4, info);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Тест для демонстрации SQL запроса
    @Test
    void select() {
        String sql = "SELECT * FROM employee";

        try {
            Statement stmt  = connection.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            Assertions.assertNotNull(rs);
            int countTableSize = 0;
            // loop through the result set
            while (rs.next()) {
                countTableSize++;
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getDouble("capacity"));
            }
            Assertions.assertEquals(3,countTableSize);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    //Очищаем таблицы после тесового подключения
    @AfterAll
    static void close() throws SQLException {
        String sqlDeleteEmployee = "DELETE FROM employee";
        String sqlDeleteInfo = "DELETE FROM employee_info";

        try {
            Statement stmt  = connection.createStatement();
            stmt.execute(sqlDeleteEmployee);
            stmt.execute(sqlDeleteInfo);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Всегда закрываем ресурсы
        connection.close();
        System.out.println("Closed database successfully");
    }
}
