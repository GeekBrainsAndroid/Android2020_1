package ru.geekbrains.resources;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Вывод ресурсов в строки программно
        TextView descriptionLanguage = findViewById(R.id.textVLang);
        descriptionLanguage.setText(getResources().getString(R.string.descriptionLanguage));
        TextView textLanguage = findViewById(R.id.textLang);
        textLanguage.setText(getResources().getString(R.string.language));
    }
}