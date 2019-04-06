package com.example.pellu.hafizaoyunu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;

/**
 * Created by pellu on 05-Apr-18.
 */

public class kart extends Button {

    boolean acikMi = false;
    boolean cevrilebilir = true;
    int arkaPlanID;
    int onPlanID = 0;
    Drawable on;
    Drawable arka;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public kart(Context context, int id) {

        super(context);
        setId(id);

        arkaPlanID = R.drawable.arka;

        if (id % 6 == 1)
            onPlanID = R.drawable.blue;

        if (id % 6 == 2)
            onPlanID = R.drawable.mavi;

        if (id % 6 == 3)
            onPlanID = R.drawable.green;

        if (id % 6 == 4)
            onPlanID = R.drawable.yesil;

        if (id % 6 == 5)
            onPlanID = R.drawable.red;

        if (id % 6 == 0)
            onPlanID = R.drawable.kirmizi;

        arka = AppCompatDrawableManager.get().getDrawable(context, arkaPlanID);
        on = AppCompatDrawableManager.get().getDrawable(context, onPlanID);
        setBackground(arka);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void cevir() {

        if (cevrilebilir) {
            if (!acikMi) {
                // arkasi cevriliyse
                setBackground(on);
                acikMi = true;
            } else {
                setBackground(arka);
                acikMi = false;
            }
        }
    }
}
