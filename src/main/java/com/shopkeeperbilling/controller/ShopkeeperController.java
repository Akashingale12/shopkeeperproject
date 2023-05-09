package com.shopkeeperbilling.controller;

import com.shopkeeperbilling.dto.ShopkeeperRequestDto;
import com.shopkeeperbilling.dto.ShopkeeperResponseDto;
import com.shopkeeperbilling.service.ShopkeeperService;
import com.shopkeeperbilling.structure.HttpResponseCode;
import com.shopkeeperbilling.structure.HttpResponseStatus;
import com.shopkeeperbilling.structure.ResponseMessage;
import com.shopkeeperbilling.utils.ApplicationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class ShopkeeperController {

    @Autowired
    private ShopkeeperService shopkeeperService;

    @Autowired(required = false)
    private ApplicationUtils applicationUtils;
    @RequestMapping(method = RequestMethod.POST,path = "/shopkeeper/addnewshopkeeper")
    public HttpResponseStatus addNewShopkeeper(@RequestBody ShopkeeperRequestDto shopkeeperRequestDto){
        HttpResponseStatus httpResponseStatus = null;
        ShopkeeperResponseDto shopkeeperResponseDto = new ShopkeeperResponseDto();
        shopkeeperResponseDto = shopkeeperService.addNewShopkeeper(shopkeeperRequestDto);
        httpResponseStatus = new HttpResponseStatus(HttpResponseCode.OK.getValue(),new ResponseMessage(applicationUtils.getMessage("shopkeeper.saved"),shopkeeperResponseDto));
        return httpResponseStatus;
    }
}
