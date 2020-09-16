//package com.mwl.screens;
//
//import asciiPanel.AsciiPanel;
//import com.mwl.ard.ApplicationMain;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import javax.swing.*;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.Assert.*;
//
//public class LoadingScreenTest {
//    AsciiPanel panel = new AsciiPanel();
//    ApplicationMain app = new ApplicationMain();
//
//    @Before
//    public void setUp() throws Exception {
//        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        app.setVisible(true);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void displayOutputTest() throws Exception {
//        Screen test = new LoadingScreen();
//        test.displayOutput(panel);
//        System.out.println("hello?");
//        TimeUnit.SECONDS.sleep(10);
//    }
//
//    @Test
//    public void respondToUserInput() {
//    }
//}