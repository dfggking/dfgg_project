package com.ads.service;

import com.ads.entity.LoginInfo;
import org.springframework.stereotype.Service;

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
    Boolean existMobile(String mobile);
    
    /**
     * 重置密码
     * @param mobile
     * @param md5Pwd
     * @return
     */
    Boolean resetPwd(String mobile, String md5Pwd);
}
