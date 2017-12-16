package com.ads.controller.admin;

import com.ads.common.base.BaseController;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/15
 */
@Controller
@RequestMapping(value = "admin/login")
public class Admin2Controller extends BaseController {
    private final static Logger LOGGER = LogManager.getLogger(Admin2Controller.class);
    
    private final static String INDEX = "";
    private final static String HTML = "html";
    private final static String LOGIN = "login";
    
    /**
     * 用于首次访问判断是否已经登录
     *
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = INDEX)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        
        
        ModelAndView mv = new ModelAndView("/admin");
        return mv;
    }
    
    
    /**
     * 管理员登录页面
     * @return
     */
    @RequestMapping(value = HTML)
    public ModelAndView html() {
        ModelAndView mv = new ModelAndView("admin/login");
        
        return mv;
    }
    
    /**
     * 登录请求
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = LOGIN)
    public Map<String, Object> login(String tel, String pwd, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> resultMap = new HashMap<>();
        
        
        return resultMap;
    }
    
}
