package ru.geekbrains.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button alert1 = findViewById(R.id.alertDialog1);
        alert1.setOnClickListener(clickAlertDialog1);
        Button alert3 = findViewById(R.id.alertDialog3);
        alert3.setOnClickListener(clickAlertDialog3);
    }

    private View.OnClickListener clickAlertDialog1 = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            // Создаём билдер и передаём контекст приложения
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            // В билдере указываем заголовок окна (можно указывать как ресурс,
            // так и строку)
            builder.setTitle(R.string.exclamation)
                    // Указываем сообщение в окне (также есть вариант со
                    // строковым параметром)
                    .setMessage(R.string.press_button)
                    // Можно указать и пиктограмму
                    .setIcon(R.mipmap.ic_launcher_round)
                    // Из этого окна нельзя выйти кнопкой Back
                    .setCancelable(false)
                    // Устанавливаем кнопку (название кнопки также можно
                    // задавать строкой)
                    .setPositiveButton(R.string.button,
                            // Ставим слушатель, нажатие будем обрабатывать
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Toast.makeText(MainActivity.this, "Кнопка нажата", Toast.LENGTH_SHORT).show();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
            Toast.makeText(MainActivity.this, "Диалог открыт", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener clickAlertDialog3 = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            // Создаём билдер и передаём контекст приложения
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            // В билдере указываем заголовок окна (можно указывать как ресурс, так
            // и строку)
            builder.setTitle(R.string.exclamation)
                    // Указываем сообщение в окне (также есть вариант со строковым
                    // параметром)
                    .setMessage("2 + 2 = 4 ?")
                    // Из этого окна нельзя выйти кнопкой Back
                    .setCancelable(false)
                    // Устанавливаем отрицательную кнопку
                    .setNegativeButton(R.string.no,
                            // Ставим слушатель, будем обрабатывать нажатие
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Toast.makeText(MainActivity.this, "Нет!", Toast.LENGTH_SHORT).show();
                                }
                            })
                    // Устанавливаем нейтральную кнопку
                    .setNeutralButton(R.string.dunno,
                            // Ставим слушатель, будем обрабатывать нажатие
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Toast.makeText(MainActivity.this, "Не знаю!", Toast.LENGTH_SHORT).show();
                                }
                            })
                    // Устанавливаем кнопку (название кнопки также можно задавать
                    // строкой)
                    .setPositiveButton(R.string.yes,
                            // Ставим слушатель, будем обрабатывать нажатие
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Toast.makeText(MainActivity.this, "Да!", Toast.LENGTH_SHORT).show();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    };
}
