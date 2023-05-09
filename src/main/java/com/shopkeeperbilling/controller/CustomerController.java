package com.shopkeeperbilling.controller;

import com.shopkeeperbilling.dto.CustomerRequestDTO;
import com.shopkeeperbilling.dto.CustomerResponseDTO;
import com.shopkeeperbilling.service.CustomerService;
import com.shopkeeperbilling.structure.HttpResponseCode;
import com.shopkeeperbilling.structure.HttpResponseStatus;
import com.shopkeeperbilling.structure.ResponseMessage;
import com.shopkeeperbilling.utils.ApplicationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ApplicationUtils applicationUtils;

    @RequestMapping(method = RequestMethod.POST, path = "/addnewcustomer")
    public HttpResponseStatus addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        CustomerResponseDTO customerResponseDTO = customerService.addNewCustomer(customerRequestDTO);
        HttpResponseStatus httpResponseStatus = new HttpResponseStatus(HttpResponseCode.OK.getValue(),new ResponseMessage(applicationUtils.getMessage("customer.saved"),customerResponseDTO));
        return httpResponseStatus;
    }
}
