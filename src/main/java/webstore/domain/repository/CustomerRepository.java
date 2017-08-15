package webstore.domain.repository;

import webstore.domain.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAllCustomer();
}
