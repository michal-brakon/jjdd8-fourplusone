//package com.infoshareacademy.service;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.ejb.Schedule;
//import javax.ejb.Singleton;
//import javax.ejb.Startup;
//import javax.inject.Inject;
//
//@Singleton
//@Startup
//public class Scheduler {
//
//    private static final Logger logger = LoggerFactory.getLogger(Scheduler.class.getName());
//
//    @Inject
//    ReservationService reservationService;
//
//    @Schedule(hour = "0", minute = "20/5", second = "0", info = "Every 1 minute timer")
//    public void Schedule () {
//        reservationService.removeUnconfirmedReservations();
//        logger.debug("Checking unconfirmed reservations");
//    }
//}
