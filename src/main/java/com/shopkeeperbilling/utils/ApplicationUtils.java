package com.shopkeeperbilling.utils;

import com.shopkeeperbilling.dto.ShopkeeperResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ApplicationUtils {

    @Autowired
    private MessageSource messageSource;

    private String msg;

    private Object object;

    private ShopkeeperResponseDto shopkeeperResponseDto;
    public String getMessage(String key){
        try {
            return messageSource.getMessage(key,null, Locale.US);
        }catch (Exception e){
            return null;
        }
    }

    public String getMessage(String key, String... value){
        try {
            return messageSource.getMessage(key,value,Locale.US);
        }catch (Exception e){
            return null;
        }
    }

    public ApplicationUtils(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
