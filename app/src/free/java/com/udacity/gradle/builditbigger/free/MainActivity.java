package com.udacity.gradle.builditbigger.free;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.rmendoza.myapplication.backend.myApi.MyApi;
import com.example.rmendoza.textviewtodisplay.TextViewToDisplay;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;

import java.io.IOException;

public class MainActivity extends ActionBarActivity {

    String entireJoke = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(intentReceiver, new IntentFilter("EndpointTag"));
    }

    @Override
    protected void onPause() {

        LocalBroadcastManager.getInstance(this).unregisterReceiver(intentReceiver);
        super.onPause();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){

//        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
        //JokeSmith myJoker = new JokeSmith();
        //Intent myIntent = new Intent(this, TextViewToDisplay.class);
        //myIntent.putExtra("EntireJoke", myJoker.getJoke());
        //startActivity(myIntent);

        EndpointsAsyncTask getJoke = new EndpointsAsyncTask();
        getJoke.execute(new Pair<Context, String>(this, ""));

    }

    private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            entireJoke = intent.getStringExtra("EntireJoke");

            Intent myIntent = new Intent(context, TextViewToDisplay.class);
            myIntent.putExtra("EntireJoke", entireJoke);
            startActivity(myIntent);

        }
    };


/*    public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
        private MyApi myApiService = null;
        private Context context;

        @Override
        protected String doInBackground(Pair<Context, String>... params) {
            if(myApiService == null) {  // Only do this once
                *//*MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                            });*//*
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setRootUrl("https://javajokes-1156.appspot.com/_ah/api/");

                // end options for devappserver

                myApiService = builder.build();
            }

            context = params[0].first;
            //String name = params[0].second;

            try {
                //return myApiService.getJoke(name).execute().getData();
                return myApiService.getJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
            Intent myIntent = new Intent(context, TextViewToDisplay.class);
            myIntent.putExtra("EntireJoke", result);
            startActivity(myIntent);
        }
    }*/


}
