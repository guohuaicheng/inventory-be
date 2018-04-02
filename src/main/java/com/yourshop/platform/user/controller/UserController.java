//package com.yourshop.platform.user.controller;
//
//import com.yourshop.common.util.ContextUtil;
//import com.yourshop.platform.user.model.User;
//import com.yourshop.platform.user.service.UserService;
//import com.yourshop.platform.tenant.service.TenantService;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
///**
// * @author G
// */
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private TenantService tenantService;
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public User login(@RequestBody UserAuth userAuth, HttpServletRequest request) {
//        String password = userAuth.getPassword();
//        userAuth = this.userService.findUserAuthByName(userAuth.getUsername());
//        if (userAuth != null && StringUtils.equals(password, userAuth.getPassword())) {
////            user.setPassword(null);
//            HttpSession session = request.getSession();
////            session.setAttribute(IConstants.SESSION_USER, user);
////            if (user.getTenantId() != null) {
////                Tenant tenant = tenantService.findTenantById(user.getTenantId());
////                session.setAttribute(IConstants.SESSION_TENANT, tenant);
////            }
////            return user;
//            return null;
//        } else {
//            return null;
//        }
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public User getUserInfo() {
//        return ContextUtil.getCurrentUser();
//    }
//}
