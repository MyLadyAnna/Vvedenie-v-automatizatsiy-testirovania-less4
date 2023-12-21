package org.max.seminar;

import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeTest extends AbstractTest {

    @Test
    void getEmployees_whenValid_shouldReturn() throws SQLException {
        //given
        String sql = "SELECT * FROM employee";
        Statement stmt  = getConnection().createStatement();
        int countTableSize = 0;
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            countTableSize++;
        }
        final Query query = getSession().createSQLQuery(sql).addEntity(EmployeeEntity.class);
        //then
        Assertions.assertEquals(2, countTableSize);
        Assertions.assertEquals(2, query.list().size());
    }

    @ParameterizedTest
    @CsvSource({"1, Менеджер", "2, Главный Менеджер"})
    void getEmployeeById_whenValid_shouldReturn(int id, String portion) throws SQLException {
        //given
        //when
        final Query query = getSession().createQuery("from " + "EmployeeEntity" + " where employeeId=" + id);
        EmployeeEntity employeeEntity = (EmployeeEntity) query.uniqueResult();
        //then
        Assertions.assertEquals(portion, employeeEntity.getPortion());
    }
}
