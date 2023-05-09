package com.shopkeeperbilling.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopkeeperbilling.dto.ResponseEntityDTO;
import com.shopkeeperbilling.security.config.ShopkeeperAppUtil;
import com.shopkeeperbilling.structure.HttpResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    @Autowired
    private ShopkeeperAppUtil shopkeeperAppUtil;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_OK);

        ResponseEntityDTO responseEntityDTO = shopkeeperAppUtil.createResponseEntityDTO(HttpResponseCode.UNAUTHORIZED,"Unable to fetch API",null);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(new ObjectMapper().writeValueAsString(response).getBytes());
        outputStream.flush();
    }
}
