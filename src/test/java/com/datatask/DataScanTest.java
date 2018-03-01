package com.datatask;

import com.ads.common.http.HttpClientUtil;
import com.ads.common.http.HttpResult;
import com.ads.common.util.UUIDUtils;
import com.ads.datatask.DataScan;
import com.ads.entity.Forex;
import com.ads.service.ForexService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DataScanTest {
    @Autowired
    private HttpClientUtil httpUtil;
    @Autowired
    private DataScan ds;
    @Autowired
    private ForexService forexService;
    
    @Test
    public void zhongfuParser(){
        ds.zhongfuDataScan();
    }
    
    @Test
    public void testZfmarket(){
        String result = ds.zhongfuMarketDataScan();
    }
    
    @Test
    public void scanForexList(){
        try {
            HttpResult httpResult = httpUtil.doPost("http://market.forex.com.cn/zhongfuMarketIndex/ajaxTable" +
                    ".do?classifyId=001");
            int statusCode = 200;
            if (Objects.equals(statusCode, httpResult.getStatusCode())) {
                String resultJson = httpResult.getContent();
    
                JSONObject json = JSON.parseObject(resultJson);
    
                List<Map<String, Object>> forexList = (List<Map<String, Object>>) json.get("list");
                List<Forex> list = new ArrayList<>();
                for (Map<String, Object> entry : forexList) {
                    Forex forex = new Forex();
                    forex.setId(UUIDUtils.getUUID());
                    forex.setSymbolId((String) entry.get("symbolId"));
                    forex.setSymbolCode((String) entry.get("symbolCode"));
                    forex.setSymbolName((String) entry.get("symbolName"));
                    forex.setEnabled("1");
                    forex.setCreatedTime(new Timestamp(System.currentTimeMillis()));
                    list.add(forex);
                }
                forexService.addBatch(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testBitkanDataScan(){
        ds.bitkanDataScan();
    }
}
