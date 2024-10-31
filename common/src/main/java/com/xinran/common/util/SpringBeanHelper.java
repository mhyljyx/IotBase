package com.xinran.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author xuehy
 * @since 2021/12/9
 */
@Component
public class SpringBeanHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 通过spring上下文获取到当前代理
     * @param klass
     * @param <T>
     * @return bean
     */
    public <T> T getBean(Class<T> klass) {
        return applicationContext.getBean(klass);
    }

}
