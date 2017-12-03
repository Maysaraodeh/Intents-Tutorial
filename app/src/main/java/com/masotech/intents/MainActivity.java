package com.masotech.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button mNext;
    EditText mEditText;
    private static final int REQUEST_CODE = 701;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNext = (Button) findViewById(R.id.intent_btn);
        mEditText = (EditText) findViewById(R.id.et_number);

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this , SecondActivity.class);
                i.putExtra("number" , mEditText.getText().toString());
                startActivityForResult(i , REQUEST_CODE );

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            String number = data.getData().toString();
            mEditText.setText(number);
        }


    }
}
