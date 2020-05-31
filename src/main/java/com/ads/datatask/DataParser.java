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
     * @param content 采集内容
     */
    void parserBikan(String content);
  
    void parserGd11x5(String content);
    
    void parserLn11x5(String jsonLn11x5);
    
    void parserJx11x5(String jsonJx11x5);
    
    void parserCqssc(String jsonCqssc);
    
    void parserJl11x5(String jsonJl11x5);
}
