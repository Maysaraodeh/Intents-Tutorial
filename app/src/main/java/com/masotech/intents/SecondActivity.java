package com.masotech.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {


    Button mBack;
    EditText mNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mBack = (Button) findViewById(R.id.intent_back);
        mNumber2 = (EditText) findViewById(R.id.et_number_second);


        String number = getIntent().getStringExtra("number");
        mNumber2.setText(number);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();

                data.setData(Uri.parse(mNumber2.getText().toString()));
                setResult(RESULT_OK , data);
                finish();
            }
        });
    }
}
