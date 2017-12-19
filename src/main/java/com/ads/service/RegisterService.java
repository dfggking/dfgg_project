package com.ads.service;


import com.ads.entity.LoginInfo;
import org.springframework.stereotype.Service;

/**
 * 注册 Service
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017-06-28
 */
public interface RegisterService {

    /**
     * 手机是否已经注册
     * @param mobile
     * @return
     */
    Boolean registeredMobile(String mobile);
    
    /**
     * 添加新用户
     * @param loginInfo
     * @return
     */
    Boolean addUser(LoginInfo loginInfo);
}
