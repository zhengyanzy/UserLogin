package com.zy.myshop.comment.until;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//public class MyApplicationContext {
//    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");;
//}

public class MyApplicationContext implements ApplicationContextAware, DisposableBean {
    public static final Logger logger = LoggerFactory.getLogger(MyApplicationContext.class);
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return applicationContext;
    }

    public void destroy() throws Exception {
        logger.debug("清空 applicationContext");
        System.out.println("清空application.....");
        applicationContext = null;

    }


    public static <T> T getBean(String name) {
        assertContextInjected();
        logger.info("getbean");
        System.out.println("getBean........");
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        assertContextInjected();
        return applicationContext.getBean(clazz);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("加载 application");
        System.out.println("加载application");
        MyApplicationContext.applicationContext = applicationContext;
    }

    private static void assertContextInjected() {
        Validate.validState(applicationContext != null, "applicationContext 属性未注入，请在 spring-context.xml 配置中定义 SpringContext");
    }
}
