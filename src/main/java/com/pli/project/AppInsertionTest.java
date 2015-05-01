package com.pli.project;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppInsertionTest {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy-hh:mm:ss");
    final static Logger logger = Logger.getLogger(AppInsertionTest.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        final DatabaseUtil threadMonitorUtil = (DatabaseUtil) context.getBean("threadMonitorUtil");
        ScheduledExecutorService executor =
                Executors.newSingleThreadScheduledExecutor();
        Runnable periodicTask = new Runnable() {
            public void run() {
                int count = threadMonitorUtil.jdbcTemplate.queryForInt("select count(*) from itable4");
                System.out.println(sdf.format(new Date()).toString() + ":" + count);
            }
        };
        executor.scheduleAtFixedRate(periodicTask, 0, 10, TimeUnit.SECONDS);
        DatabaseUtil dbInsertionUtil = (DatabaseUtil) context.getBean("dbInsertionUtil");
        dbInsertionUtil.millionInsertIndex();
    }


}