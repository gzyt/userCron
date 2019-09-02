package com.example.demo;


public class QuartzSimple {

    public static void main(String[] args) {

        //简单任务调度，每隔多少时间执行一次，执行n次
        usercronController.handleSimpleTrigger("44033", "3333","44033", "3333", HelloJob.class, 1, 1);
        //复杂调度，每天的什么时候执行任务
//        usercronController.hadleCronTrigger("44033", "3333","44033", "3333",HelloJob.class,"0 19 19 * * ? *");

    }
}
