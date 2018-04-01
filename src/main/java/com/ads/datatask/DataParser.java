package com.ads.datatask;

import java.util.Map;

/**
 * 数据解析 接口
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/14
 */
public interface DataParser {
    /**
     * 解析sina采集的数据
     * @param result
     */
    void parseSina(String result);
    /**
     * 币看 数据解析
     * @param type 币类别
     * @param content 采集内容
     * @param index 数据索引
     */
    void parserBikan(String type, String content, int index);
    /**
     * 外汇通 数据解析
     * @param content
     */
    void parseZhongfuMarket(String content);
    
    /**
     * 外汇通 数据解析
     * @param content 采集内容
     */
    void parserWaiHuiTong(String content);
    
    
    
}
