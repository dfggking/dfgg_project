package com.ads.controller;

import com.ads.common.base.BaseController;
import com.ads.entity.LoginInfo;
import com.ads.service.RegisterService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 注册 Controller
 *
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017-06-28
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController extends BaseController {
    private final static Logger LOGGER = LogManager.getLogger(RegisterController.class);
    /**
     * 注册页面跳转
     */
    private final static String REGISTER = "/";
    /**
     * 注册请求
     */
    private final static String TO = "/to";
    /**
     * 注册发送验证码
     */
    private final static String SEND_CAPTCHA = "/sendCaptcha";
    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = TO)
    public Map<String, Object> toRegister(LoginInfo loginInfo, String captcha,
                                          HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);

        // 验证必要字段非空
        if (Objects.isNull(loginInfo.getMobile()) || Objects.isNull(loginInfo.getPassword()) || Objects.isNull(captcha)) {
            resultMap.put(STATUS, 0);
            resultMap.put(MSG, "请填写必要信息");
            return resultMap;
        }

        // 比较验证码


        // 手机号是否已存在 存在则提示手机号已存在
        Boolean registeredMobile = registerService.registeredMobile(loginInfo.getMobile());
        if (registeredMobile) {
            resultMap.put(STATUS, 0);
            resultMap.put(MSG, "手机号已存在");
            return resultMap;
        }



        loginInfo.getPassword();

        return null;
    }

    /**
     * 注册时 发送验证码
     * @return
     */
    @RequestMapping(value = SEND_CAPTCHA)
    public Map<String, Object> sendCaptcha(){

        return null;
    }

}
