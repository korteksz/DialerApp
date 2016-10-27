package com.example.user.dialerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "NUMBER";
    public final static int REQ_DIAL = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button dial = (Button) findViewById(R.id.dial_button);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {

                Toast.makeText(MainActivity.this,"Teszt", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, DialerActivity.class);
                EditText editText = (EditText) findViewById(R.id.number_editText);
                String message = editText.getText().toString();
                intent.putExtra(EXTRA_MESSAGE,message);
                //startActivity(intent);
                startActivityForResult(intent, REQ_DIAL);

            }

        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_DIAL){
            if(resultCode == RESULT_OK){
                Toast.makeText(this, "Result OK", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Result Cancelled", Toast.LENGTH_LONG).show();
            }

        }
    }
}
