package com.ads.service.impl;

import com.ads.common.base.BaseService;
import com.ads.entity.LoginInfo;
import com.ads.service.LoginService;
import com.ads.service.RegisterService;
import org.springframework.stereotype.Service;

/**
 * PC端登录Service
 *
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017-06-28
 */
@Service
public class RegisterServiceImpl extends BaseService implements RegisterService {
    /**
     * 手机是否已经注册
     *
     * @param mobile
     * @return
     */
    @Override
    public Boolean registeredMobile(String mobile) {
        return null;
    }
    
    /**
     * 添加新用户
     *
     * @param loginInfo
     * @return
     */
    @Override
    public Boolean addUser(LoginInfo loginInfo) {
        return null;
    }
    
    
}
