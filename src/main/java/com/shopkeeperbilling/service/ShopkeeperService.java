package com.shopkeeperbilling.service;

import com.shopkeeperbilling.dto.ShopkeeperRequestDto;
import com.shopkeeperbilling.dto.ShopkeeperResponseDto;
import com.shopkeeperbilling.model.Shopkeeper;
import com.shopkeeperbilling.repo.ShopkeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopkeeperService {

   @Autowired
   private ShopkeeperRepository shopkeeperRepository;

   public ShopkeeperResponseDto addNewShopkeeper(ShopkeeperRequestDto shopkeeperRequestDto){
       ShopkeeperResponseDto shopkeeperResponseDto = new ShopkeeperResponseDto();
       Shopkeeper shopkeeper = new Shopkeeper();
       shopkeeper.setShopkeeperName(shopkeeperRequestDto.getShopkeeperName());
       shopkeeper.setShopkeeperMobileNumber(shopkeeperRequestDto.getShopkeeperMobileNumber());
       shopkeeper.setShopkeeperAddress(shopkeeperRequestDto.getShopkeeperAddress());
       shopkeeperRepository.save(shopkeeper);
       shopkeeperResponseDto.setShopkeeperId(shopkeeper.getShopkeeperId());
       shopkeeperResponseDto.setShopkeeperName(shopkeeper.getShopkeeperName());
       shopkeeperResponseDto.setShopkeeperMobileNumber(shopkeeper.getShopkeeperMobileNumber());
       shopkeeperResponseDto.setShopkeeperAddress(shopkeeper.getShopkeeperAddress());
       return shopkeeperResponseDto;
   }
}
