package com.security.valpro.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPractise implements Runnable {
    @Override
    public void run() {

    }

    class Demo{
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newSingleThreadScheduledExecutor();
    }
}