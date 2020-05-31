package com.ads.datatask.task;

import com.ads.datatask.DataScan;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class CaiTask extends QuartzJobBean {
    
    @Autowired
    private DataScan dataScan;
    
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        dataScan.cai();
    }
}
