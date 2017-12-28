package com.ads.service.impl;

import com.ads.common.base.BaseService;
import com.ads.common.util.Md5Encoder;
import com.ads.common.util.UUIDUtils;
import com.ads.entity.LoginInfo;
import com.ads.entity.UserInfo;
import com.ads.service.LoginService;
import com.ads.service.RegisterService;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
     * 添加新用户
     *
     * @param loginInfo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addUser(LoginInfo loginInfo, String inviteCode) {
    
        UserInfo userInfo = new UserInfo();
        userInfo.setId(loginInfo.getUserId());
        userInfo.setIntroducerId(inviteCode);
        userInfo.setUserCode(100000001);
        userInfo.setUpdatedTime(new Timestamp(System.currentTimeMillis()));
        userInfo.setMoney(new BigDecimal(0));
        hibernateTemplate.save(userInfo);
        
        loginInfo.setType("01");
        loginInfo.setId(UUIDUtils.getUUID());
        loginInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        hibernateTemplate.save(loginInfo);
        return true;
    }
    
    
}
