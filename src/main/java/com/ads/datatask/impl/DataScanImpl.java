package com.ads.datatask.impl;

import com.ads.common.http.HttpClientUtil;
import com.ads.common.http.HttpResult;
import com.ads.datatask.DataParser;
import com.ads.datatask.DataScan;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 数据采集实现类
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/14
 */
@Service
public class DataScanImpl implements DataScan {
    private final static Logger LOGGER = LogManager.getLogger(DataScanImpl.class);
    @Autowired
    private HttpClientUtil httpUtil;
    @Autowired
    private DataParser dataParser;

    /**
     * http://market.forex.com.cn/zhongfuMarketIndex/ajaxTable.do?classifyId=001
     */
    @Override
    public void zhongfuDataScan() {
        try {


            HttpResult httpResult = httpUtil.doPost("http://market.forex.com.cn/zhongfuMarketIndex/ajaxTable.do?classifyId=001");
            int statusCode = 200;
            if (Objects.equals(statusCode, httpResult.getStatusCode())) {
                String resultJson = httpResult.getContent();
                dataParser.parserWaiHuiTong(resultJson);
//                LOGGER.info("采集正常");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
