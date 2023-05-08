package com.shopkeeperbilling.security.config;

import com.shopkeeperbilling.dto.ResponseEntityDTO;
import com.shopkeeperbilling.structure.HttpResponseCode;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ShopkeeperAppUtil {
    public ResponseEntityDTO createResponseEntityDTO(HttpResponseCode httpResponseCode, String message, Object body){
        return new ResponseEntityDTO(httpResponseCode.getValue(),message,body);
    }
}
