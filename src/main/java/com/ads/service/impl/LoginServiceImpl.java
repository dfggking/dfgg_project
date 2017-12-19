package com.ads.service.impl;

import com.ads.common.base.BaseService;
import com.ads.common.util.Md5Encoder;
import com.ads.entity.LoginInfo;
import com.ads.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * PC端登录Service
 *
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017-06-28
 */
@Service
public class LoginServiceImpl extends BaseService implements LoginService {
    
    /**
     * 手机号是否存在
     * @param mobile
     * @return
     */
    @Override
    public LoginInfo existMobile(String mobile) {
        String hql = "from LoginInfo where mobile=?";
        List<LoginInfo> loginInfos = (List<LoginInfo>) hibernateTemplate.find(hql, mobile);
        if (loginInfos.isEmpty()) {
            return new LoginInfo();
        } else {
            return loginInfos.get(0);
        }
    }
    
    /**
     * 根据手机号和密码获取登录信息
     * @param mobile
     * @param pwd
     * @return
     */
    @Override
    public Map<String, Object> getLoginInfo(String mobile, String pwd) {
        
        String hql = "from LoginInfo where mobile=? and password=?";
        List<LoginInfo> loginInfos = (List<LoginInfo>) hibernateTemplate.find(hql, mobile, pwd);
        if (loginInfos.size() > 0) {
            LoginInfo loginInfo = loginInfos.get(0);
            
        } else {
        
        }
        
        return null;
    }
}
