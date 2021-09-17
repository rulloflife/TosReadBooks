package kh.edu.rupp.fe.ite.tosreadbooks;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
