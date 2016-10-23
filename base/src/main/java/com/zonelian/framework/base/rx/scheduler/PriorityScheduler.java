package com.zonelian.framework.base.rx.scheduler;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.SchedulerLifecycle;

/**
 * Created by kernel on 16/9/7.
 * Email: 372786297@qq.com
 */
@Deprecated
public class PriorityScheduler extends Scheduler implements SchedulerLifecycle{
    private ThreadFactory threadFactory;

    @Override
    public Worker createWorker() {
        return new PriorityWorker();
    }

    private static class PriorityWorker extends Scheduler.Worker {

        @Override
        public Subscription schedule(Action0 action) {
            return null;
        }

        @Override
        public Subscription schedule(Action0 action, long delayTime, TimeUnit unit) {
            return null;
        }

        @Override
        public void unsubscribe() {

        }

        @Override
        public boolean isUnsubscribed() {
            return false;
        }
    }


    @Override
    public void start() {

    }

    @Override
    public void shutdown() {

    }
}
