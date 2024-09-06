package com.jing.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository("list")
public class CustomerListDataAccessService implements CustomerDao{

    //db
    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer alex = new Customer(
                1,
                "alex",
                "alex@gmail.com",
                21
        );
        customers.add(alex);
        Customer jing = new Customer(
                2,
                "jing",
                "jing@gmail.com",
                21
        );
        customers.add(jing);
    }



    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        Optional customer = customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        return customer;

    }

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);

    }

    @Override
    public boolean existsCustomerWithEmail(String email) {
        return customers.stream()
                .anyMatch(c -> c.getEmail().equals(email));
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customers.removeIf(c -> c.getId().equals(id));

    }

    @Override
    public boolean existsCustomerWithId(Integer id) {
        return customers.stream()
                .anyMatch(c -> c.getId().equals(id));
    }

    @Override
    public void updateCustomer(Customer update) {
        customers.add(update);

    }
}
