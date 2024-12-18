package com.tztang.util;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Quartz 调度器工具类
 * @author tztang
 * @since 2024-12-18
 */
@Slf4j
public class QuartzSchedulerUtil {

    private static Scheduler scheduler;

    static {
        try {
            // 获取调度器实例
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();  // 启动调度器
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建一个定时任务
     * @param jobClass 作业类
     * @param jobName 作业名称
     * @param jobGroup 作业组
     * @param triggerName 触发器名称
     * @param triggerGroup 触发器分组
     * @param startTime 开始时间
     * @param repeatInterval 触发器间隔
     * @throws SchedulerException
     */
    public static void addJob(Class<? extends Job> jobClass, String jobName, String jobGroup, String triggerName, String triggerGroup, Date startTime, long repeatInterval) throws SchedulerException {
        // 创建作业
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(jobName, jobGroup)
                .build();
        // 创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .startAt(startTime)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInMilliseconds(repeatInterval)
                        .repeatForever())  // 设置永远重复
                .build();
        // 将作业和触发器注册到调度器中
        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 创建一个定时任务
     * @param jobClass 作业类
     * @param jobName 作业名称
     * @param jobGroup 作业组
     * @param triggerName 触发器名称
     * @param triggerGroup 触发器分组
     * @param cron cron表达式
     * @throws SchedulerException
     */
    public static void addJob(Class<? extends Job> jobClass, String jobName, String jobGroup, String triggerName, String triggerGroup, String cron) throws SchedulerException {
        // 创建作业
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(jobName, jobGroup)
                .build();
        // 创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        // 将作业和触发器注册到调度器中
        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 创建一次性任务
     * @param jobClass 作业类
     * @param jobName 作业名称
     * @param jobGroup 作业组
     * @param triggerName 触发器名称
     * @param triggerGroup 触发器分组
     * @param startTime 开始时间
     * @throws SchedulerException
     */
    public static void addOnceJob(Class<? extends Job> jobClass, String jobName, String jobGroup, String triggerName, String triggerGroup, Date startTime) throws SchedulerException {
        // 创建作业
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(jobName, jobGroup)
                .build();
        // 创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .startAt(startTime)  // 设置开始时间
                .build();
        // 将作业和触发器注册到调度器中
        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 删除任务
     * @param jobName 作业名称
     * @param jobGroup 作业组
     * @throws SchedulerException
     */
    public static void removeJob(String jobName, String jobGroup) throws SchedulerException {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        scheduler.deleteJob(jobKey);
    }

    /**
     * 暂停任务
     * @param jobName 作业名称
     * @param jobGroup 作业组
     * @throws SchedulerException
     */
    public static void pauseJob(String jobName, String jobGroup) throws SchedulerException {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复任务
     * @param jobName 作业名称
     * @param jobGroup 作业组
     * @throws SchedulerException
     */
    public static void resumeJob(String jobName, String jobGroup) throws SchedulerException {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        scheduler.resumeJob(jobKey);
    }

    /**
     * 获取调度器
     * @return
     */
    public static Scheduler getScheduler() {
        return scheduler;
    }

    /**
     * 关闭调度器
     * @return
     */
    public static void shutdown() throws SchedulerException {
        if (scheduler != null) {
            if (scheduler.isStarted()) {
                scheduler.shutdown(true);  // 关闭调度器并等待所有作业完成
            }
        }
    }

    /**
     * 开启调度器
     * @return
     */
    public static void start() throws SchedulerException {
        if (scheduler != null) {
            if (!scheduler.isStarted()) {
                scheduler.start();
            }
        }
    }

}
