package com.udacity.gradle.builditbigger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.test.AndroidTestCase;
import android.util.Log;
import android.util.Pair;

import java.util.concurrent.CountDownLatch;


/**
 * Created by rmendoza on 1/5/2016.
 */
public class TestAsynkTask extends AndroidTestCase {

    CountDownLatch signal = null;
    String entireJoke = null;

    public void setUp() throws Exception{
        super.setUp();
        signal = new CountDownLatch(1);
    }

    public void testTask() throws InterruptedException {

        LocalBroadcastManager.getInstance(getContext()).registerReceiver(intentReceiver, new IntentFilter("EndpointTag"));
        EndpointsAsyncTask getJoke = new EndpointsAsyncTask();
        getJoke.execute(new Pair<Context, String>(getContext(), ""));

        signal.await();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(intentReceiver);
        Log.d("Joke is: ", entireJoke);
        assertTrue(entireJoke.length()>0);

    }

    private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            entireJoke = intent.getStringExtra("EntireJoke");
            signal.countDown();
        }
    } ;

}
