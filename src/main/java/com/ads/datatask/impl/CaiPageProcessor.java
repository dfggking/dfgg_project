package com.ads.datatask.impl;

import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

/**
 * 采集测试
 */
public class CaiPageProcessor implements PageProcessor {
    
    private Site site = Site.me().setRetryTimes(0).setSleepTime(3000).setTimeOut(10000);
    
    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        Elements contentMainEle = html.getDocument().body().getElementsByClass("contentMain");
        String tt = contentMainEle.get(1).html();
        System.out.println(tt);
    }
    
    
    @Override
    public Site getSite() {
        return site;
    }
    
    public static void main(String[] args) {
        
        Spider.create(new CaiPageProcessor()).addUrl("https://chart.icaile.com/chart/gd/?top=-1").thread(5).run();
        
    }
}
