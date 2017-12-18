package com.ads.controller;

import com.ads.common.base.BaseController;
import com.ads.common.token.TokenMgr;
import com.ads.service.LoginService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.tools.jstat.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 登录 Controller
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017-06-28
 */
@Controller
@RequestMapping(value = "/")
public class LoginController extends BaseController {
    private final static Logger LOGGER = LogManager.getLogger(LoginController.class);
    /**
     * 网站访问跳转
     */
    private final static String INDEX = "/";

    private final static String LOGIN = "/login";

    @Autowired
    private LoginService loginService;
    
    /**
     * 是否登录 如果没有登录跳转登录页 否则跳转到主页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = INDEX)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
    
    
        Enumeration<String> e = session.getAttributeNames();
        
        
        while (e.hasMoreElements()) {
            String s = e.nextElement();
            System.out.println(session.getAttribute(s));
        }
        
        ModelAndView mv = new ModelAndView("/pc");
        return mv;
    }
    
    
    @RequestMapping(value=LOGIN)
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        
        String mobile = request.getParameter("mobile");
        String pwd = request.getParameter("pwd");
        if (Objects.nonNull(mobile) && Objects.nonNull(pwd)) {
            
            
            TokenMgr.createJWT("123456");
        }

        return null;
    }

}
