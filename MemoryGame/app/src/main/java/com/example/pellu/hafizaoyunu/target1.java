package com.example.pellu.hafizaoyunu;

import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.security.PrivateKey;

public class target1 extends AppCompatActivity {


    private TextView txt;

    private void init() {
        Intent i = getIntent();
        String str = i.getStringExtra("mesaj");
        txt = (TextView) findViewById(R.id.textView2);
        txt.setText(str);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target1);

        init();

        final int[] sonKart = {0};
        GridLayout gl = (GridLayout) findViewById(R.id.kartlar);
        final kart kartlar[] = new kart[12];
        for (int j = 1; j <= 12; j++) {
            kartlar[j - 1] = new kart(this, j);
            kartlar[j - 1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final kart k = (kart) v;
                    k.cevir();

                    if (sonKart[0] > 0) {

                        final kart k2 = (kart) findViewById(sonKart[0]);
                        if (k2.onPlanID == k.onPlanID && k2.getId() != k.getId()) {

                            //Matched 
                            k.cevrilebilir = false;
                            k2.cevrilebilir = false;

                            int count = 0;
                            for (int i = 0; i < 12; i++) {
                                if (kartlar[i].cevrilebilir == false) {
                                    count++;
                                }
                                if (count == 12) {
                                    TextView txt = (TextView) findViewById(R.id.txtKuqe);
                                    txt.setText("Tebrikler Oyunu Kazandiniz!");
                                }
                            }
                        } else {
                            // they didnt matched turn back both 
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k.cevir();
                                    k2.cevir();
                                }
                            }, 600);
                            sonKart[0] = 0;
                        }
                    } else {
                        sonKart[0] = k.getId();
                    }
                }
            });
        }
        // mix the cards
        for (int j = 0; j < 12; j++) {
            int random = (int) (Math.random() * 12);
            kart k = kartlar[random];
            kartlar[random] = kartlar[j];
            kartlar[j] = k;
        }
        for (int j = 0; j < 12; j++) {
            gl.addView(kartlar[j]);
        }
    }
}
