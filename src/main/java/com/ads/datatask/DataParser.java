package com.ads.datatask;

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
    
    /**
     * 币看 数据解析
     * @param type 币类别
     * @param content 采集内容
     * @param index 数据索引
     */
    Map<String, Object> parserBikan(String type, String content, int index);
}
