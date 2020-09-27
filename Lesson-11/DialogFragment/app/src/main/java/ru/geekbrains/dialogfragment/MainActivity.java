package ru.geekbrains.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fragmentBuilderButton = findViewById(R.id.dialogBuilder);
        fragmentBuilderButton.setOnClickListener(fragmentBuilderAction);
        Button fragmentCustomButton = findViewById(R.id.dialogCustom);
        fragmentCustomButton.setOnClickListener(fragmentCustomAction);
    }

    private View.OnClickListener fragmentBuilderAction = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment dlgBuilder = new DialogBuilderFragment();
            dlgBuilder.show(getSupportFragmentManager(), "transactionTag");
        }
    };

    private View.OnClickListener fragmentCustomAction = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment dlgCustom = new DialogCustomFragment();
            dlgCustom.show(getSupportFragmentManager(), "transactionTag");
        }
    };

    // Метод для общения с диалоговыми окнами
    public void onDialogResult(String resultDialog){
        Toast.makeText(this, "Выбрано " + resultDialog, Toast.LENGTH_SHORT).show();
    }
}