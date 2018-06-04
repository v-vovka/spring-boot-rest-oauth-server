package com.tas.app.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vladimir Vashchuk on 05.06.2018
 */
@RestController
public class OauthLogoutController {

    @Resource(name="tokenServices")
    private ConsumerTokenServices tokenServices;

    @RequestMapping(value = "/oauth/tokens/revoke", method = RequestMethod.DELETE)
    @ResponseBody
    public void revokeToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && StringUtils.containsIgnoreCase(authorization,"Bearer")){
            String tokenId = authorization.substring("Bearer".length()+1);
            tokenServices.revokeToken(tokenId);
        }
    }
}
