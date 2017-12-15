package com.ads.datatask;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * 数据解析
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/14
 */
public interface DataParser {



    /**
     * 外汇通 数据解析
     * @param content 采集内容
     */
    void parserWaiHuiTong(String content);

}
