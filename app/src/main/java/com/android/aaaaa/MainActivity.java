package com.android.aaaaa;



import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends  AppCompatActivity {

    Button btn;
    ProgressBar pb;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.start);
        pb = (ProgressBar) findViewById(R.id.progressBar);
        t = (TextView) findViewById(R.id.status);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText("Working...");
                btn=(Button)findViewById(R.id.start);
                pb=(ProgressBar)findViewById(R.id.progressBar);
                pb.setProgress(0);
                final int totalProgressTime=100;
                final Thread thread=new Thread(){
                    @Override
                    public void run(){
                        int jumpTime=0;
                        while (jumpTime<totalProgressTime){
                            try{
                                sleep(1000);
                                jumpTime += 1;
                                pb.setProgress(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                };

                thread.start();
            }
        });

    }
}