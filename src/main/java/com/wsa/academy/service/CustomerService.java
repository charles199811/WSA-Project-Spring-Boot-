package com.wsa.academy.service;

import com.wsa.academy.dto.CustomerDTO;
import com.wsa.academy.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getcustomerById(int customerId);

    List<CustomerDTO> getAllcustomerById();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getCustomerByActiveState(boolean activeState);
}
