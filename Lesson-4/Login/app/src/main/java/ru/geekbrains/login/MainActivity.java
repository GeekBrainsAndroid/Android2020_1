package ru.geekbrains.login;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends BaseActivity {

    // Регулярные выражения позволяют проверить на соответствие шаблону
    // Это имя. Первая буква большая латинская, остальные маленькие латинские
    Pattern checkLogin = Pattern.compile("^[A-Z][a-z]{2,}$");
    // Это пароль, минимум 6 символов, обязательны маленькая буква, большая буква, цифра
    Pattern checkPassword = Pattern.compile("^(?=^.{6,}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initThemeChooser();
        initTexts();
    }

    private void initTexts() {
        TextInputEditText login = findViewById(R.id.inputLoginName);
        TextInputEditText password = findViewById(R.id.inputPassword);
        final TextInputLayout layoutLogin = findViewById(R.id.loginName);
        final TextInputLayout layoutPassword = findViewById(R.id.password);

        // Чтобы не докучать пользователю при вводе каждой буквы, сделаем проверку при потере фокуса
        login.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            // Как только фокус потерян, сразу проверяем на валидность данные
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) return;
                TextView tv = (TextView) v;
                String value = tv.getText().toString();
                if (checkLogin.matcher(value).matches()) {
                    tv.setError(null);
                } else {
                    tv.setError(getString(R.string.not_name)); // Ошибка отобразится справа
                }
            }
        });

        // Пароль тоже проверим при потере фокуса
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) return;
                TextView tv = (TextView) v;
                String value = tv.getText().toString();
                if (checkPassword.matcher(value).matches()) {
                    layoutPassword.setError(null);
                } else {
                    layoutPassword.setError(getString(R.string.weak_password)); // Ошибка отобразится снизу
                }
            }
        });
    }

    // Инициализация радио-кнопок
    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonMyCoolStyle),
                MyCoolCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialDark),
                AppThemeDarkCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialLight),
                AppThemeLightCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialLightDarkAction),
                AppThemeCodeStyle);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(MyCoolCodeStyle))).setChecked(true);
    }

    // Все инициализации кнопок очень похожи, поэтому создадим метод для переиспользования
    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // сохраним настройки
                setAppTheme(codeStyle);
                // пересоздадим активити, чтобы тема применилась
                recreate();
            }
        });
    }
}