package com.ads.controller;

import com.ads.common.base.BaseController;
import com.ads.common.http.HttpClientUtil;
import com.ads.common.http.HttpResult;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.core.convert.Property;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 * 验证码Controller
 *
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017-06-28
 */
@Controller
@RequestMapping(value="/captcha")
public class CaptchaController extends BaseController {
    private final static Logger LOGGER = LogManager.getLogger(CaptchaController.class);
    /** 发送验证码 */
    private final static String CAPTCHA_SEND = "/send";
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private HttpClientUtil httpClientUtil;
    /**
     * 发送验证码
     * @return
     */
    @RequestMapping(value = CAPTCHA_SEND)
    @ResponseBody
    public Map<String, Object> sendCaptcha(String mobile) {
        Map resultMap = new HashMap(16);
        Random random = new Random();
        int captcha = random.nextInt(10000);
        String url = "http://utf8.api.smschinese.cn/";
        String smsText = "验证码：" + captcha;
        Map<String, String> params = new HashMap<String, String>(16);
        params.put("Uid", "dfggking");
        params.put("Key", "6d11046ab9964806e1ed");
        params.put("smsMob", mobile);
        params.put("smsText", smsText);
        HttpResult httpResult = null;
        try {
            httpResult = httpClientUtil.doPost(url, params);
            int statusCode = 200;
            if (Objects.equals(statusCode, httpResult.getStatusCode())) {
                
                // 验证码存入ehcache 时长90s
                Cache captchaCache = cacheManager.getCache("captchaCache");
                captchaCache.put(mobile, captcha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultMap.put(STATUS, httpResult.getStatusCode());
        resultMap.put(MSG, httpResult.getContent());
        return resultMap;
    }
}
