package com.wsa.academy.repo;

import com.wsa.academy.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
//This is a place that we use inheritance.//
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    // we create a query method in here that relates to the business logic
    List<Customer> findAllByActiveEquals(boolean activeState);
}
