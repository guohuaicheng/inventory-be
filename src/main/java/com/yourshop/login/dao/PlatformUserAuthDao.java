package com.yourshop.login.dao;

import com.yourshop.login.model.UserAuth;
import com.yourshop.platform.annotation.MybatisRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author G
 */
@MybatisRepository
@Repository
public interface PlatformUserAuthDao {

    /** 根据用户名获取平台用户信息
     * @param username
     * @return
     */
    UserAuth get(@Param("username") String username);
}
