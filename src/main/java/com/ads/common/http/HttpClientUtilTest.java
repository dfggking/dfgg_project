package com.ads.common.http;

import com.ads.controller.CaptchaController;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

/**
 * httpclient test
 * @author dfggking
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class HttpClientUtilTest {
    @Autowired
    private CaptchaController captchaController;
    @Test
    public void sendCatcha() throws IOException {
//        int i = captchaController.sendCaptcha("17671711476");
//        System.out.println(i);

        System.out.println();
    }
}
