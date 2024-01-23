package com.wsa.academy.controller;

import com.wsa.academy.dto.CustomerDTO;
import com.wsa.academy.dto.request.CustomerUpdateDTO;
import com.wsa.academy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* ResController convert java's to jason & sends to front end */
@RestController
@RequestMapping("api/v1/wsacustomer")
@CrossOrigin
public class CustomerController {
    /*injecting an autowired object in the container to the
      class is called dependency injection (DI)
      **********Type of this DI is property injection*********/
    @Autowired
    private CustomerService customerService;

    /* below is the post mapping
     * Requestbody anotation is used to conver the reciving jason object to java*/
    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    /* Created a seperate DTO for update cus we only need 3 values
       02.38.57*/

    @PutMapping("/update")
    public String updatedCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {

        String message = customerService.updateCustomer(customerUpdateDTO);

        return message;
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId) {
        CustomerDTO customerDTO = customerService.getcustomerById(customerId);
        return customerDTO;
    }

    @GetMapping(
            path = "/get-all-customer"
    )
    public List<CustomerDTO> getAllById() {
        List<CustomerDTO> customerDTO = customerService.getAllcustomerById();
        return customerDTO;
    }

    @DeleteMapping(
            path = "delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {
        String message = customerService.deleteCustomer(customerId);
        return message;
    }

    @GetMapping(
            path = "/get-all-customer-by-active-status/{status}"
    )
    public List<CustomerDTO> getCustomerByActiveState(@PathVariable(value = "status") boolean activeState) {
        List<CustomerDTO> customerDTO = customerService.getCustomerByActiveState(activeState);
        return customerDTO;
    }
}
