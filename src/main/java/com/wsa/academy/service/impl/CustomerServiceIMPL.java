package com.wsa.academy.service.impl;

import com.wsa.academy.dto.CustomerDTO;
import com.wsa.academy.dto.request.CustomerUpdateDTO;
import com.wsa.academy.entity.Customer;
import com.wsa.academy.repo.CustomerRepo;
import com.wsa.academy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }


    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());
            System.out.println("cc " + customer);
            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + " Updated Successful";
        } else {
            throw new RuntimeException("no ID");
        }
    }


    @Override
    public CustomerDTO getcustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            /* if there's Id, we can get the data as follow, data comes as
               an entity so we need to convert it to DTO as shown*/
            CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            //return the DTO to controller
            return customerDTO;
        } else {
            throw new RuntimeException("No custoer");
        }
    }


    @Override
    public List<CustomerDTO> getAllcustomerById() {
        List<Customer> getAllcustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : getAllcustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }


    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
        }
        return customerId + " is Deleted";
    }


    @Override
    public List<CustomerDTO> getCustomerByActiveState(boolean activeState) {
        List<Customer> getAllcustomers = customerRepo.findAllByActiveEquals(activeState);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : getAllcustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }


}
