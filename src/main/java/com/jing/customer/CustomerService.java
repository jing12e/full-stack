package com.jing.customer;

import com.jing.exception.DuplicateResourceException;
import com.jing.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
//business layer

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jdbc") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomers();
    }

    public Customer getCustomerById(Integer id) {
        return customerDao.selectCustomerById(id)
                .orElseThrow(() -> new ResourceNotFound("Customer not found"));
    }

    public void createCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        // check if email exists
        if (customerDao.existsCustomerWithEmail(customerRegistrationRequest.email())) {
            throw new DuplicateResourceException(
                    "Customer with email " + customerRegistrationRequest.email() + " already exists"
            );
        }

        // add
        Customer customer = new Customer(
                customerRegistrationRequest.name(),
                customerRegistrationRequest.email(),
                customerRegistrationRequest.age()
        );
        customerDao.insertCustomer(customer);

    }

    public void deleteCustomer(Integer id) {
        if (customerDao.existsCustomerWithId(id)) {
            customerDao.deleteCustomerById(id);
            System.out.println("Deleted Customer with id " + id);
        } else {
            throw new ResourceNotFound("Customer not found");
        }

    }

    public void updateCustomer(Integer id, CustomerUpdateRequest updateRequest) {

        Customer customer = getCustomerById(id);
        boolean changed = false;
        if (updateRequest.name() != null && !updateRequest.name().equals(customer.getName())) {
            customer.setName(updateRequest.name());
            changed = true;

        }

        if (updateRequest.age() != null && !updateRequest.age().equals(customer.getAge())) {
            customer.setAge(updateRequest.age());
            changed = true;
        }

        if (updateRequest.email() != null && !updateRequest.email().equals(customer.getEmail())) {
            if (customerDao.existsCustomerWithEmail(updateRequest.email())) {
                throw new DuplicateResourceException(
                        "Customer with email " + updateRequest.email() + " already exists"
                );
            }

            customer.setEmail(updateRequest.email());
            changed = true;
        }

        if (!changed) {
            throw new ResourceNotFound("No data changed");
        }
        customerDao.updateCustomer(customer);

    }
}
