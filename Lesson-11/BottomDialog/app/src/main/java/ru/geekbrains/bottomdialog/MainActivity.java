package ru.geekbrains.bottomdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyBottomSheetDialogFragment dialogFragment =
                        MyBottomSheetDialogFragment.newInstance();
                dialogFragment.setOnDialogListener(dialogListener);
                dialogFragment.show(getSupportFragmentManager(),
                        "dialog_fragment");
            }
        });
    }

    // Слушатель диалога, сюда попадает управление
    // при выборе пользователем кнопки в диалоге
    private OnDialogListener dialogListener = new OnDialogListener() {
        @Override
        public void onDialogOk() {
            Toast.makeText(MainActivity.this, "Нажата Ок", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onDialogYes() {
            Toast.makeText(MainActivity.this, "Нажата Yes", Toast.LENGTH_SHORT).show();
        }
    };
}
