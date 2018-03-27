package com.ads.datatask.task;

import com.ads.common.http.HttpClientUtil;
import com.ads.common.http.HttpResult;
import com.ads.datatask.DataScan;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.IOException;

/**
 * 外汇通 数据扫描任务
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/14
 */
public class WhtDataScanTask extends QuartzJobBean {
    private final static Logger LOGGER = LogManager.getLogger(WhtDataScanTask.class);

    @Autowired
    private DataScan dataScan;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        dataScan.zhongfu();
    }
}
