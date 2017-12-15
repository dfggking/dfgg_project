package com.ads.controller;

import com.ads.common.http.HttpClientUtil;
import com.ads.common.http.HttpResult;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.Property;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class CaptchaController {
    private final static Logger LOGGER = LogManager.getLogger(CaptchaController.class);
    /** 发送验证码 */
    private final static String CAPTCHA_SEND = "/send";
    @Autowired
    private HttpClientUtil httpClientUtil;
    /**
     * 发送验证码
     * @return
     */
    @RequestMapping(value = CAPTCHA_SEND)
    public int sendCaptcha(String tel) throws IOException {
        Random random = new Random();
        int captcha = random.nextInt(10000);

        String url = "http://utf8.api.smschinese.cn/";
        String smsText = "验证码：" + captcha;
        Map<String, String> params = new HashMap<String, String>();
        params.put("Uid", "dfggking");
        params.put("Key", "6d11046ab9964806e1ed");
        params.put("smsMob", tel);
        params.put("smsText", smsText);
        HttpResult httpResult = httpClientUtil.doPost(url, params);
        int status_code = 200;
        if (Objects.equals(httpResult.getStatusCode(), status_code)) {
            return 1;
        }
        return 0;
    }
}
