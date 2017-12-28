package com.ads.service.impl;

import com.ads.common.base.BaseService;
import com.ads.entity.LoginInfo;
import com.ads.service.LoginInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/19
 */
@Service
public class LoginInfoServiceImpl extends BaseService implements LoginInfoService {
    
    /**
     * 手机号是否存在
     *
     * @param mobile
     * @return
     */
    @Override
    public Boolean existMobile(String mobile) {
        String hql = "from LoginInfo where mobile=?";
        List list = hibernateTemplate.find(hql, mobile);
        if(Objects.nonNull(list) && list.size()>0){
            return true;
        }
        return false;
    }
    
    /**
     * 重置密码
     *
     * @param mobile
     * @param md5Pwd
     * @return
     */
    @Override
    public Boolean resetPwd(String mobile, String md5Pwd) {
        String sql = "update login_info set password=? where mobile=?";
        int i = jdbcTemplate.update(sql, new Object[]{md5Pwd, mobile});
        if(i>0){
            return true;
        }
        return false;
    }
    
}
