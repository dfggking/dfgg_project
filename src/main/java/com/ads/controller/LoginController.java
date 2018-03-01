package com.ads.controller;

import com.ads.common.base.BaseController;
import com.ads.common.token.TokenMgr;
import com.ads.common.util.Md5Encoder;
import com.ads.entity.LoginInfo;
import com.ads.service.LoginInfoService;
import com.ads.service.LoginService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 登录 Controller
 *
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
    /**
     * 登录请求
     */
    private final static String LOGIN = "/login";
    /**
     * 重置密码
     */
    private final static String RESET_PWD = "/resetPwd";
    /**
     * 重置密码 发送验证码
     */
    private final static String SEND_CAPTCHA_FOR_RESET_PWD = "/resetPwd/sendCaptcha";
    
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private CaptchaController captchaController;
    @Autowired
    private LoginInfoService loginInfoService;
    @Autowired
    private LoginService loginService;
    
    /**
     * 是否登录 如果没有登录跳转登录页 否则跳转到主页
     *
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
    
    @RequestMapping(value = LOGIN)
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        String mobile = request.getParameter("mobile");
        String pwd = request.getParameter("pwd");
        
        // 首先 参数非空验证
        if (Objects.nonNull(mobile) && Objects.nonNull(pwd)) {
            
            // 手机号是否已存在
            LoginInfo loginInfo = loginService.existMobile(mobile);
            if (Objects.nonNull(loginInfo.getMobile())) {
                try {
                    Boolean pwdFlag = Md5Encoder.validPassword(pwd, loginInfo.getPassword());
                    if (pwdFlag) {
                        String token = TokenMgr.createJWT(loginInfo.getUserId());
                        resultMap.put(MSG, "登录成功");
                        resultMap.put("token", token);
                        resultMap.put(STATUS, 1);
                    } else { // 密码错误
                        resultMap.put(MSG, "密码错误");
                        resultMap.put(STATUS, 0);
                    }
                } catch (NoSuchAlgorithmException e) {
                    resultMap.put(MSG, "密码异常，请重置密码");
                    resultMap.put(STATUS, 0);
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    resultMap.put(MSG, "密码异常，请重置密码");
                    resultMap.put(STATUS, 0);
                    e.printStackTrace();
                }
            } else {
                resultMap.put(MSG, "手机号不存在");
                resultMap.put(STATUS, 0);
            }
        } else {
            resultMap.put(MSG, "手机号和密码不能为空");
            resultMap.put(STATUS, 0);
        }
        return resultMap;
    }
    
    
    @RequestMapping(value = RESET_PWD)
    @ResponseBody
    public Map resetPwd(String mobile, String pwd) {
        Map resultMap = new HashMap(16);
        if (Objects.nonNull(mobile) && Objects.nonNull(pwd)) {
            try {
                String md5Pwd = Md5Encoder.getEncryptedPwd(pwd);
                Boolean b = loginInfoService.resetPwd(mobile, md5Pwd);
                if(b){
                    resultMap.put(MSG, "密码已重置");
                    resultMap.put(STATUS, 1);
                    return resultMap;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            resultMap.put(MSG, "密码重置失败");
            resultMap.put(STATUS, 0);
        }else{
            resultMap.put(MSG, "手机号和密码不能为空");
            resultMap.put(STATUS, 0);
        }
        return resultMap;
    }
    
    
    @RequestMapping(value = SEND_CAPTCHA_FOR_RESET_PWD)
    @ResponseBody
    public Map<String, Object> sendCaptchaForResetPwd(String mobile){
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        if(Objects.nonNull(mobile)){
            // 如果手机号不存在 提示去注册
            Boolean existMobile = loginInfoService.existMobile(mobile);
            if(existMobile){
                Map sendResult = captchaController.sendCaptcha(mobile);
                int statusCode = 200;
                int sendStatusCode = (int) sendResult.get("status");
                if (Objects.equals(statusCode, sendStatusCode)) {
                    resultMap.put(MSG, "验证码已发送");
                    resultMap.put(STATUS, 1);
                }else{
                    resultMap.put(MSG, "验证码发送失败");
                    resultMap.put(INFO, sendResult);
                    resultMap.put(STATUS, 0);
                }
            }else{
                resultMap.put(MSG, "手机号不存在，请前去注册");
                resultMap.put(STATUS, 0);
            }
        }else{
            resultMap.put(MSG, "手机号为空");
            resultMap.put(STATUS, 0);
        }
        return resultMap;
    }
}
