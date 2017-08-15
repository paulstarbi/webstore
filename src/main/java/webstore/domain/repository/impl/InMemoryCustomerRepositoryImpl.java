package webstore.domain.repository.impl;

import org.springframework.stereotype.Repository;
import webstore.domain.Customer;
import webstore.domain.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> customersList;

    public InMemoryCustomerRepositoryImpl() {
        customersList = new ArrayList<>();
        customersList.add(new Customer("C1", "Tomasz Nowakowski", 23));
        customersList.add(new Customer("C11", "Tomasz Nowak", 12));
        customersList.add(new Customer("C22", "Tomasz Wowski", 3));
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customersList;
    }
}
