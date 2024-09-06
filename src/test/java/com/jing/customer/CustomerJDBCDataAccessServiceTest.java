package com.jing.customer;

import com.jing.AbstractTestContainersUnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerJDBCDataAccessServiceTest extends AbstractTestContainersUnitTest {
    private CustomerJDBCDataAccessService underTest;
    private final CustomerRowMapper customerRowMapper = new CustomerRowMapper();



    @BeforeEach
    void setUp() {
        underTest = new CustomerJDBCDataAccessService(
                getJdbcTemplate(),
                customerRowMapper
        );

    }

    @Test
    void selectAllCustomers() {
        //given
        Customer customer = new Customer(

        );

        //when

        //then
    }

    @Test
    void selectCustomerById() {
        //given

        //when

        //then
    }

    @Test
    void insertCustomer() {
        //given

        //when

        //then
    }

    @Test
    void existsCustomerWithEmail() {
        //given

        //when

        //then
    }

    @Test
    void deleteCustomerById() {
        //given

        //when

        //then
    }

    @Test
    void existsCustomerWithId() {
        //given

        //when

        //then
    }

    @Test
    void updateCustomer() {
        //given

        //when

        //then
    }
}