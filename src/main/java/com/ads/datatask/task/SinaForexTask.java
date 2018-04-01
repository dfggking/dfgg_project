package com.ads.datatask.task;

import com.ads.datatask.DataScan;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2018/4/1
 */
public class SinaForexTask extends QuartzJobBean {
    
    private final static Logger LOGGER = LogManager.getLogger(SinaForexTask.class);
    
    @Autowired
    private DataScan dataScan;
    
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        LOGGER.debug("sinaforex task working!");
        dataScan.sinaForex();
    }
}
