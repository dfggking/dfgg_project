package com.ads.service;

import com.ads.entity.LoginInfo;

import java.util.Map;

/**
 * 登录 Service
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017-06-28
 */
public interface LoginService {
    
    /**
     * 手机号是否存在
     * @param mobile
     * @return
     */
    LoginInfo existMobile(String mobile);
    
    /**
     * 根据手机号和密码获取登录信息
     * @param mobile
     * @param pwd
     * @return
     */
    Map<String, Object> getLoginInfo(String mobile, String pwd);

}
