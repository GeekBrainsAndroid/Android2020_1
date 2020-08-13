package ru.geekbrains.intentprocess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private final static String TEXT = "PARAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle == null){
            return;
        }
        String text  = bundle.getString(TEXT); // получить данные из Intent
        TextView textView = findViewById(R.id.textEcho);
        textView.setText(text); // Сохранить их в TextView
    }
}