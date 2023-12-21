package org.max.seminar;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.max.demo.EmployeeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class ClientTest extends AbstractTest {

    @Test
    void getClients_whenValid_shouldReturn() throws SQLException {
        //given
        String sql = "SELECT * FROM client";
        Statement stmt  = getConnection().createStatement();
        int countTableSize = 0;
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            countTableSize++;
        }
        final Query query = getSession().createSQLQuery(sql).addEntity(ClientEntity.class);
        //then
        Assertions.assertEquals(3, countTableSize);
        Assertions.assertEquals(3, query.list().size());
    }

    @ParameterizedTest
    @CsvSource({"1, Иванов", "2, Петров", "3, Сидоров"})
    void getClientById_whenValid_shouldReturn(int id, String lastName) throws SQLException {
        //given
        String sql = "SELECT * FROM client WHERE client_id=" + id;
        Statement stmt  = getConnection().createStatement();
        String name = "";
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            name = rs.getString(3);
        }
        //then
        Assertions.assertEquals(lastName, name);
    }
    @ParameterizedTest
    @CsvSource({"Иванов1", "Петров1", "Сидоров1"})
    void addNewClient (String lastname) throws SQLException {
        String sql = "SELECT MAX(client_id) FROM client";
        Statement stmt  = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        short num = (short) (rs.getShort(1)+1);
        getConnection().close();

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientId(num);
        clientEntity.setLastName(lastname);
        clientEntity.setFirstName("");
        clientEntity.setApartment("");
        clientEntity.setDistrict("");
        clientEntity.setHouse("");
        clientEntity.setStreet("");
        clientEntity.setPhoneNumber("");

        Session session = getSession();
        session.beginTransaction();
        session.persist(clientEntity);
        session.getTransaction().commit();

        final Query queryWhere = session.createQuery("from " + "ClientEntity" + " where client_id=" + num);
        System.out.println("executing: " + queryWhere.getQueryString());
        Optional<ClientEntity> entity = queryWhere.uniqueResultOptional();
        Assertions.assertTrue(entity.isPresent());
        Assertions.assertEquals(lastname, entity.get().getLastName());
    }

    @ParameterizedTest
    @CsvSource({"Иванов1", "Петров1", "Сидоров1"})
    void addNewClient2 (String lastname) throws SQLException {
        Session session = getSession();
        String sql = "SELECT MAX(client_id) FROM client";
        final Query queryWhereid = session.createSQLQuery(sql);
        Integer num = (Integer) queryWhereid.uniqueResult() +1;

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientId(num.shortValue());
        clientEntity.setLastName(lastname);
        clientEntity.setFirstName("");
        clientEntity.setApartment("");
        clientEntity.setDistrict("");
        clientEntity.setHouse("");
        clientEntity.setStreet("");
        clientEntity.setPhoneNumber("");

        session.beginTransaction();
        session.persist(clientEntity);
        session.getTransaction().commit();

        final Query queryWhere = session.createQuery("from " + "ClientEntity" + " where client_id=" + num);
        System.out.println("executing: " + queryWhere.getQueryString());
        Optional<ClientEntity> entity = queryWhere.uniqueResultOptional();
        Assertions.assertTrue(entity.isPresent());
        Assertions.assertEquals(lastname, entity.get().getLastName());
    }
}
