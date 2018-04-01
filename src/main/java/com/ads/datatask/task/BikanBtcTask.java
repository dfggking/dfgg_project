package com.ads.datatask.task;

import com.ads.datatask.DataScan;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2018/4/1
 */
public class BikanBtcTask extends QuartzJobBean {

    @Autowired
    private DataScan dataScan;
    
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        dataScan.bitkanBTC();
    }
}
