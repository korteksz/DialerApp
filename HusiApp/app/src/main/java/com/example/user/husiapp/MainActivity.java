package com.example.user.husiapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<AlcoholVolume> alcoholVolumeList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText volume = (EditText)findViewById(R.id.volume);
        final EditText alcohol = (EditText)findViewById(R.id.alcohol);
        Button add = (Button) findViewById(R.id.add);
        final TextView listText = (TextView) findViewById(R.id.list_textView);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String volumeStr = volume.getText().toString();
                String alcoholStr = alcohol.getText().toString();
                String volumeAlc = String.format("%s ml - %s %%", volumeStr, alcoholStr);

                listText.append(volumeAlc + "\n");

                AlcoholVolume alcVol = new AlcoholVolume();
                alcVol.setAlohol(Double.parseDouble(alcoholStr));
                alcVol.setVolume(Integer.parseInt(volumeStr));
                alcoholVolumeList.add(alcVol);
            }
        });

        listText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.getParcelableArrayListExtra(com.example.user.husiapp.ListActivity.KEY_ALCOHOL_LIST, alcoholVolumeList);
                startActivity(intent);
            }
        });

    }
}
