package com.ads.controller;

import com.ads.common.base.BaseController;
import com.ads.common.token.TokenMgr;
import com.ads.common.util.UUIDUtils;
import com.ads.entity.LoginInfo;
import com.ads.service.RegisterService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private final static String SUBMIT = "/submit";
    /**
     * 注册发送验证码
     */
    private final static String SEND_CAPTCHA = "/sendCaptcha";
    /**
     * 验证码校验
     */
    private final static String VALIDATE_CAPTCHA = "/validateCaptcha";
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private CaptchaController captchaController;
    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = SUBMIT)
    public Map<String, Object> submit(LoginInfo loginInfo, String captcha,
                                          HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);

        // 验证必要字段非空
        if (Objects.isNull(loginInfo.getMobile()) || Objects.isNull(loginInfo.getPassword()) || Objects.isNull(captcha)) {
            resultMap.put(STATUS, 0);
            resultMap.put(MSG, "请填写必要信息");
            return resultMap;
        }

        // 手机号是否已存在 存在则提示手机号已存在
        Boolean registeredMobile = registerService.registeredMobile(loginInfo.getMobile());
        if (registeredMobile) {
            resultMap.put(STATUS, 0);
            resultMap.put(MSG, "手机号已存在");
            return resultMap;
        }
    
        String userId = UUIDUtils.getUUID();
        String token = TokenMgr.createJWT(userId);
        
        resultMap.put(STATUS, 1);
        resultMap.put(MSG, "注册成功");
        resultMap.put("token", token);
        return resultMap;
    }

    /**
     * 注册时 发送验证码
     * @return
     */
    @RequestMapping(value = SEND_CAPTCHA)
    @ResponseBody
    public Map<String, Object> sendCaptcha(String mobile){
        Map resultMap = new HashMap(16);
        Map sendResult = captchaController.sendCaptcha(mobile);
        int statusCode = 200;
        int sendStatusCode = (int) sendResult.get("status");
        
        if (Objects.equals(statusCode, sendStatusCode)) {
            resultMap.put(MSG, "验证码已发送");
            resultMap.put(STATUS, 1);
            return resultMap;
        }
        resultMap.put(MSG, "验证码发送失败");
        resultMap.put(INFO, sendResult);
        resultMap.put(STATUS, 0);
        return resultMap;
    }
    
    @RequestMapping(value = VALIDATE_CAPTCHA)
    @ResponseBody
    public Map<String, Object> validateCaptcha(String mobile, String captcha){
        Map resultMap = new HashMap(16);
        // 获取ehcache中的验证码
        Cache cache = cacheManager.getCache("captchaCache");
        Cache.ValueWrapper valueWrapper = cache.get(mobile);
        String cacheCaptcha = valueWrapper.get().toString();
        if (Objects.nonNull(valueWrapper)) {
            if (Objects.equals(cacheCaptcha, captcha)) {
                resultMap.put(MSG, "验证码通过验证");
                resultMap.put(STATUS, 1);
                return resultMap;
            } else {
                resultMap.put(MSG, "验证码错误");
                resultMap.put(STATUS, 0);
                return resultMap;
            }
        }else{
            resultMap.put(MSG, "请发送验证码");
            resultMap.put(STATUS, 0);
            return resultMap;
        }
    }
}
