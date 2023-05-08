package com.shopkeeperbilling.security.jwt;

import com.shopkeeperbilling.model.Shopkeeper;
import com.shopkeeperbilling.model.UserToken;
import com.shopkeeperbilling.repo.ShopkeeperRepository;
import com.shopkeeperbilling.repo.UserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserTokenRepository userTokenRepository;

    @Autowired
    private ShopkeeperRepository shopkeeperRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authToken = request.getHeader(this.tokenHeader);
        String email = null;
        email = jwtTokenUtil.getNameFromToken(authToken);

        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){

            Optional<UserToken> userToken = userTokenRepository.findTokenByUserToken(authToken);
            if(userToken.isEmpty()){
                filterChain.doFilter(request,response);
                return;
            }

            Optional<Shopkeeper> shopkeeper =  shopkeeperRepository.findShopkeeperByEmail(email);
            if(shopkeeper.isPresent()){
                List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

            }
        }
    }
}
