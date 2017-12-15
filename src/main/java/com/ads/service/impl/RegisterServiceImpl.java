package com.ads.service.impl;

import com.ads.common.base.BaseService;
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

//    /**
//     * 获取用户信息
//     *
//     * @param idWechat
//     * @return Users
//     */
//    @Override
//    public Users getUser(String idWechat) {
//        String hql = "from Users where idWechat = ?";
//        List<Users> list = (List<Users>) hibernateTemplate.find(hql, new Object[]{idWechat});
//        if(list.size() > 0){
//            return list.get(0);
//        }else{
//            return null;
//        }
//    }
//
//    /**
//     * 注册
//     *
//     * @param user
//     * @return Boolean
//     */
//    @Override
//    public Boolean signIn(Users user) {
//        return null;
//    }
//
//    /**
//     * 登录
//     *
//     * @param users
//     * @return Boolean
//     */
//    @Override
//    public Boolean login(Users users) {
//        return null;
//    }
}
