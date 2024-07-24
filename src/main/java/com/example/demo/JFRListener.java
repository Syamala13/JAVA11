//package com.example.demo;
//
//import jdk.jfr.Recording;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@WebListener
//public class JFRListener implements ServletContextListener {
//    private Recording recording;
//    private final Path recordingPath = Paths.get("D:\\TESTING\\recording.jfr");
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        recording = new Recording();
//        recording.start();
//        System.out.println("JFR recording started.");
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        if (recording != null) {
//            try {
//                recording.stop();
//                recording.dump(recordingPath);
//                System.out.println("JFR recording stopped. Data saved to " + recordingPath);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
