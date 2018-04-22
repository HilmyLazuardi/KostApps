package com.example.hilmylazuardi.studykasus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img1,img2,img3;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = (ImageView) findViewById(R.id.btnHal1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), KosActivity.class);
                startActivity(i);
            }
        });

        img2 = (ImageView) findViewById(R.id.btnHal2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), BioActivity.class);
                startActivity(i);
            }
        });

        img3 = (ImageView) findViewById(R.id.btnHal3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), Pesan.class);
                startActivity(i);
            }
        });
    }
    public void onStart(){
        super.onStart();
        progressDialog = ProgressDialog.show(this, "Harap Tunggu",
                "Process.....",true);
        CountDownTimer timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }
}
