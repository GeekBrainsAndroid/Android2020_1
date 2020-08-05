package ru.geekbrains.account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Constants {
    private EditText txtName;
    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        account = new Account();
        initView();
    }

    private void initView() {
        Button btnGreetings = findViewById(R.id.btnGreetings);
        final TextView txtGreetings = findViewById(R.id.textHello);
        txtName = findViewById(R.id.textName);
        btnGreetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String sayHello = getString(R.string.say_hello) + name;
                txtGreetings.setText(sayHello);
            }
        });

        Button btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Чтобы стартовать активити надо подготовить интент
                // В данном случае это будет явный интент, поскольку здесь передается класс активити
                Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
                populateAccount();
                // Передача данных через интент
                runSettings.putExtra(YOUR_ACCOUNT, account);
                // Метод стратует активити, указанную в интенте
                startActivity(runSettings);
            }
        });
    }

    private void populateAccount(){
        account.setName(txtName.getText().toString());
    }
}