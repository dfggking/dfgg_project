package com.ads.datatask.task;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Component;

/**
 * 将Spring beans注入到Quartz中
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/14
 */
@Component
public class QuartzJobFactory extends SpringBeanJobFactory {

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        // 调用父类方法
        Object jobInstance = super.createJobInstance(bundle);
        // 注入
        beanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
