package com.ads.service.impl;

import com.ads.common.base.BaseService;
import com.ads.entity.LoginInfo;
import com.ads.service.LoginInfoService;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/19
 */
public class LoginInfoServiceImpl extends BaseService implements LoginInfoService {
    
    /**
     * 手机号是否存在
     *
     * @param mobile
     * @return
     */
    @Override
    public LoginInfo existMobile(String mobile) {
        return null;
    }
}
