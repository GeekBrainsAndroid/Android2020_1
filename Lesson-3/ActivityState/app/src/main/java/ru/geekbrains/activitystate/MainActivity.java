package ru.geekbrains.activitystate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int counter1 = 0;       // первый счетчик
    private TextView textCounter1;  // пользовательский элемент 1-го счетчика

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Получить пользовательский элемент по идентификатору
        textCounter1 = findViewById(R.id.textView1);
    }

    // Обработка кнопки через атрибут onClick в макете
    public void button1_onClick(View view) {
        counter1++;

        // Установить текст на TextView
        textCounter1.setText(String.format(Locale.getDefault(), "%d", counter1));
    }
}