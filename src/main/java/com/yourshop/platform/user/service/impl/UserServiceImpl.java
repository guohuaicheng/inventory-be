//package com.yourshop.platform.user.service.impl;
//
//import com.yourshop.platform.user.model.User;
//import com.yourshop.platform.user.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
///**
// * @author G
// */
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserAuthDao userAuthDao;
//
//    @Override
//    public User findUser(User user) {
////        if (user == null && StringUtils.isEmpty(user.getUsername())) {
//        return null;
////        }
////        return this.userAuthDao.get(user);
//    }
//
//    @Override
//    public UserAuth findUserAuthByName(String username) {
//        if (StringUtils.isEmpty(username)) {
//            return null;
//        }
//        return this.userAuthDao.get(username);
//    }
//}
