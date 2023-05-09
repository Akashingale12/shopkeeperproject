package com.shopkeeperbilling.service;

import com.shopkeeperbilling.dto.ProductRequestDTO;
import com.shopkeeperbilling.dto.ProductResponseDTO;
import com.shopkeeperbilling.model.Product;
import com.shopkeeperbilling.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDTO addNewProduct(ProductRequestDTO productRequestDTO){
        Product product = new Product();
        product.setProductName(productRequestDTO.getProductName());
        product.setProductPrice(productRequestDTO.getProductPrice());
        product = productRepository.save(product);
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductId(product.getProductId());
        productResponseDTO.setProductName(product.getProductName());
        productResponseDTO.setProductPrice(product.getProductPrice());
        return productResponseDTO;
    }
}
