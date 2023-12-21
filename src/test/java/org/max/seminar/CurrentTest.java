package org.max.seminar;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.persistence.PersistenceException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CurrentTest extends AbstractTest {

    @Test
    void getCurrents_whenValid_shouldReturn() throws SQLException {
        //given
        String sql = "SELECT * FROM current ";
        Statement stmt  = getConnection().createStatement();
        int countTableSize = 0;
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            countTableSize++;
        }
        final Query query = getSession().createSQLQuery(sql).addEntity(CurrentEntity.class);
        //then
        Assertions.assertEquals(1, countTableSize);
        Assertions.assertEquals(1, query.list().size());
    }

    @Test
    @Order(2)
    void addCurrent_whenNotValid_shouldThrow() {
        //given
        CurrentEntity entity = new CurrentEntity();
        entity.setCurrentId((short) 2);
        entity.setClient((short) 1);
        entity.setEmployee((short) 1);
        //when
        Session session = getSession();
        session.beginTransaction();
        session.persist(entity);
        //then
        Assertions.assertThrows(PersistenceException.class, () -> session.getTransaction().commit());
        ;
    }
}
