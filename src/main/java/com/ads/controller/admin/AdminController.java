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

/**
 *
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/15
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController extends BaseController {
    private final static Logger LOGGER = LogManager.getLogger(AdminController.class);
    
    private final static String INDEX = "";
    
    /**
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
    

}
