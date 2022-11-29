package com.javatpoint.microservices.currencyexchangeservice.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
  @Scheduled(cron = "0 22 13 * * ? ")
  public void cronJobSch() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    Date now = new Date();
    String strDate = sdf.format(now);
    System.out.println("Java cron job expression:: " + strDate);
  }

//  @Scheduled(fixedRate = 1000)
//  public void fixedRateSch() {
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//
//    Date now = new Date();
//    String strDate = sdf.format(now);
//    System.out.println("Fixed Rate scheduler:: " + strDate);
//  }
//
//  @Scheduled(fixedDelay = 2000, initialDelay = 10000)
//  public void fixedDelaySch() throws InterruptedException {
////    Thread.sleep(10000);
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//    Date now = new Date();
//    String strDate = sdf.format(now);
//    System.out.println("Fixed Delay scheduler:: " + strDate);
//  }
}
