package com.example.testingdomain;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import io.branch.referral.Branch;
import io.branch.referral.BranchError;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv_title);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Branch branch=Branch.getInstance(getApplicationContext());
        branch.initSession(new Branch.BranchReferralInitListener() {
            @Override
            public void onInitFinished(@Nullable JSONObject referringParams, @Nullable BranchError error) {
                if (error==null){
                    Log.d("BranchTest","deepLink"+referringParams.toString());
                    try {
                        if (referringParams.getBoolean("+clicked_branch_link")) {
                            textView.setText("Opened The App By using Branch Link");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },this.getIntent().getData(),this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}