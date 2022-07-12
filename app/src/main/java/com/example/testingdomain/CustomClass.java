package com.example.testingdomain;

import android.app.Application;

import io.branch.referral.Branch;

public class CustomClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Branch logging for debugging
        Branch.enableTestMode();
        Branch.enableLogging();

        // Branch object initialization
        Branch.getAutoInstance(this);
    }
}
