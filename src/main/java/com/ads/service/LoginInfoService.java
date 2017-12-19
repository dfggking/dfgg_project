package com.ads.service;

import com.ads.entity.LoginInfo;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/19
 */
public interface LoginInfoService {
    /**
     * 手机号是否存在
     * @param mobile
     * @return
     */
    LoginInfo existMobile(String mobile);
}
