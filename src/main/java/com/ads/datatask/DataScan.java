package com.ads.datatask;

import java.util.List;
import java.util.Map;

/**
 * 数据采集 接口
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/14
 */
public interface DataScan {
    
    /**
     * 1、新浪外汇采集器
     */
    void sinaForex();

    /**
     * 2、BTC采集器
     * https://tvc4.forexpros.com/e6da7627478c36c2df0784dca86630c5/1552703924/6/6/28/quotes?symbols=Bitfinex:BTC/USD,Bitfinex:ETH/USD,ZB_COM:LTC/USD,,Bittrex:BCH/BTC
     */
    void bitkanBTC();
    
    /**
     * 3、高频彩 采集器
     * 网址：http://www.caipiaoapi.com/
     * 格式：{"rows":20,"code":"jx11x5","remain":"329hrs","data":[{"expect":"2019031708","opencode":"03,01,05,06,09","opentime":"2019-03-17 11:51:23","opentimestamp":1552794683},{"expect":"2019031707","opencode":"05,11,08,07,09","opentime":"2019-03-17 11:31:34","opentimestamp":1552793494},{"expect":"2019031706","opencode":"01,03,02,04,11","opentime":"2019-03-17 11:11:26","opentimestamp":1552792286},{"expect":"2019031705","opencode":"01,07,03,10,06","opentime":"2019-03-17 10:51:29","opentimestamp":1552791089},{"expect":"2019031704","opencode":"06,09,02,08,05","opentime":"2019-03-17 10:31:25","opentimestamp":1552789885},{"expect":"2019031703","opencode":"01,07,02,04,08","opentime":"2019-03-17 10:11:31","opentimestamp":1552788691},{"expect":"2019031702","opencode":"04,03,02,01,11","opentime":"2019-03-17 09:51:28","opentimestamp":1552787488},{"expect":"2019031701","opencode":"07,08,02,09,06","opentime":"2019-03-17 09:31:24","opentimestamp":1552786284},{"expect":"2019031642","opencode":"05,04,02,06,09","opentime":"2019-03-16 23:11:34","opentimestamp":1552749094},{"expect":"2019031641","opencode":"02,08,07,11,09","opentime":"2019-03-16 22:51:30","opentimestamp":1552747890},{"expect":"2019031640","opencode":"06,11,09,05,04","opentime":"2019-03-16 22:31:38","opentimestamp":1552746698},{"expect":"2019031639","opencode":"02,04,05,08,01","opentime":"2019-03-16 22:11:34","opentimestamp":1552745494},{"expect":"2019031638","opencode":"09,06,04,02,01","opentime":"2019-03-16 21:51:16","opentimestamp":1552744276},{"expect":"2019031637","opencode":"02,10,03,04,09","opentime":"2019-03-16 21:31:22","opentimestamp":1552743082},{"expect":"2019031636","opencode":"10,03,02,07,06","opentime":"2019-03-16 21:11:22","opentimestamp":1552741882},{"expect":"2019031635","opencode":"08,11,03,01,02","opentime":"2019-03-16 20:51:24","opentimestamp":1552740684},{"expect":"2019031634","opencode":"01,05,11,03,10","opentime":"2019-03-16 20:31:30","opentimestamp":1552739490},{"expect":"2019031633","opencode":"05,06,11,04,08","opentime":"2019-03-16 20:11:27","opentimestamp":1552738287},{"expect":"2019031632","opencode":"11,08,05,10,03","opentime":"2019-03-16 19:52:17","opentimestamp":1552737137},{"expect":"2019031631","opencode":"01,02,07,11,08","opentime":"2019-03-16 19:31:23","opentimestamp":1552735883}]}
     */
    void cai();
    
}
