package com.yourshop.login.controller;

import com.yourshop.common.constants.IConstants;
import com.yourshop.common.exception.ExceptionResult;
import com.yourshop.common.util.JWTHelper;
import com.yourshop.login.model.UserAuth;
import com.yourshop.login.model.UserInfoVO;
import com.yourshop.login.service.UserAuthService;
import com.yourshop.platform.tenant.service.TenantService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author G
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private TenantService tenantService;

    @RequestMapping(method = RequestMethod.POST)
    public UserInfoVO login(@RequestBody UserAuth userAuth, HttpServletResponse response) {
        if (userAuth == null || StringUtils.isEmpty(userAuth.getUsername())) {
            return null;
        }
        String password = userAuth.getPassword();
        String domainUrl = userAuth.getDomainUrl();
        userAuth = this.userAuthService.findUserAuth(userAuth);
        if (userAuth == null || !StringUtils.equals(password, userAuth.getPassword())) {
            return null;
        }

        Map<String, String> info = new HashMap<String, String>();
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setId(userAuth.getId());
        userInfoVO.setName(userAuth.getUsername());
        userInfoVO.setUsername(userAuth.getUsername());
        userInfoVO.setTenantId(userAuth.getTenantId());

        info.put(IConstants.SESSION_USER, userAuth.getId());
        if(!StringUtils.isEmpty(domainUrl)) {
            info.put(IConstants.SESSION_TENANT, String.valueOf(userAuth.getTenantId()));
        }

        try {
            String token = JWTHelper.generateToken(info);
            response.setHeader("token", token);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return userInfoVO;
    }

    @RequestMapping(value = "/not", method = RequestMethod.POST)
    public ExceptionResult notLogin() {
        return new ExceptionResult("aaaa", "未登录");
    }
}
