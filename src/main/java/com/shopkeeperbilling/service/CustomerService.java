package com.shopkeeperbilling.service;

import com.shopkeeperbilling.dto.CustomerRequestDTO;
import com.shopkeeperbilling.dto.CustomerResponseDTO;
import com.shopkeeperbilling.model.Customer;
import com.shopkeeperbilling.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerResponseDTO addNewCustomer(CustomerRequestDTO customerRequestDTO){
        Customer customer = new Customer();
        customer.setCustomerName(customerRequestDTO.getCustomerName());
        customer.setCustomerMobileNumber(customerRequestDTO.getCustomerMobileNumber());
        customer.setCustomerAddress(customerRequestDTO.getCustomerAddress());
        customer = customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setCustomerId(customer.getId());
        customerResponseDTO.setCustomerName(customer.getCustomerName());
        customerResponseDTO.setCustomerAddress(customer.getCustomerMobileNumber());
        customerResponseDTO.setCustomerMobileNumber(customer.getCustomerMobileNumber());
        return customerResponseDTO;
    }
}
