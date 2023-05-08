package com.shopkeeperbilling.controller;

import com.shopkeeperbilling.dto.ProductRequestDTO;
import com.shopkeeperbilling.dto.ProductResponseDTO;
import com.shopkeeperbilling.service.ProductService;
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

public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ApplicationUtils applicationUtils;

    @RequestMapping(method = RequestMethod.POST, path = "/addproduct/")
    public HttpResponseStatus addProduct(@RequestBody ProductRequestDTO productRequestDTO){
        HttpResponseStatus httpResponseStatus;
        ProductResponseDTO productResponseDTO = productService.addNewProduct(productRequestDTO);
        httpResponseStatus = new HttpResponseStatus(HttpResponseCode.OK.getValue(), new ResponseMessage(applicationUtils.getMessage("product.saved"),productResponseDTO));
        return httpResponseStatus;
    }
}
