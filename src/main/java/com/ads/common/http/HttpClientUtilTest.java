package com.ads.common.http;

import com.ads.controller.CaptchaController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

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
