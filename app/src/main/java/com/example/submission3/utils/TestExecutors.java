package com.example.submission3.utils;

import java.util.concurrent.Executor;

public class TestExecutors implements Executor {

    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
