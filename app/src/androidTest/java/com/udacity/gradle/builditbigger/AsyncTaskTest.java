package com.udacity.gradle.builditbigger;



import android.test.UiThreadTest;

import junit.framework.TestCase;

import java.util.concurrent.CountDownLatch;

/**
 * Created by macbook on 21/11/16.
 */


public class AsyncTaskTest extends TestCase implements EndPointAsyncTask.PassedJoke {

    private EndPointAsyncTask endPointAsyncTask;

    private CountDownLatch countDownLatch = null;


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        countDownLatch = new CountDownLatch(1);
        endPointAsyncTask = new EndPointAsyncTask(this);
    }

    @UiThreadTest
    public void testString() throws InterruptedException{
        endPointAsyncTask.execute();
        countDownLatch.await();
    }

    @Override
    public void passJoke(String joke) {
        assertTrue("There is no joke", !joke.isEmpty());
        countDownLatch.countDown();
    }
}