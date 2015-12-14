/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.rmendoza.myapplication.backend;

//import com.example.rmendoza.myapplication.backend.myApi.MyApi;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.jokes.JokeSmith;

import java.io.IOException;

import javax.inject.Named;
import javax.naming.Context;

import javafx.util.Pair;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.rmendoza.example.com",
                ownerName = "backend.myapplication.rmendoza.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        JokeSmith myJoker = new JokeSmith();

        response.setData(myJoker.getJoke());

        return response;
    }

}



