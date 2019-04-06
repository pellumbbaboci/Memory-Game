package com.example.pellu.hafizaoyunu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txt;
    private void init(){
        txt = (EditText)findViewById(R.id.editText);
        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this,target1.class);
                i.putExtra("mesaj",txt.getText().toString());
                startActivity(i);
            }

        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}
