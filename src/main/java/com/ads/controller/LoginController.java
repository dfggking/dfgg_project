package com.ads.controller;

import com.ads.common.base.BaseController;
import com.ads.service.LoginService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录 Controller
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017-06-28
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {
    private final static Logger LOGGER = LogManager.getLogger(LoginController.class);
    /**
     * 登录页跳转
     */
    private final static String LOGIN = "/";

    private final static String SING_IN = "/signin";
    private final static String REGISTER = "/register";

    @Autowired
    private LoginService loginService;

    @RequestMapping(value=REGISTER)
    @ResponseBody
    public Map<String, Object> register(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> resultMap = new HashMap<String, Object>(16);




        return null;
    }

}
