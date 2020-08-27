package ru.geekbrains.fragmentnavigation;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;

public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        initSwitchBackStack(view);
        initRadioAdd(view);
        initRadioReplace(view);
        initSwitchBackAsRemove(view);
        initSwitchDeleteBeforeAdd(view);
    }

    private void initRadioReplace(View view) {
        RadioButton radioButtonReplace = view.findViewById(R.id.radioButtonReplace);
        radioButtonReplace.setChecked(!Settings.IsAddFragment);
        radioButtonReplace.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.IsAddFragment = !isChecked;
                writeSettings();
            }
        });
    }

    private void initRadioAdd(View view) {
        RadioButton radioButtonAdd = view.findViewById(R.id.radioButtonAdd);
        radioButtonAdd.setChecked(Settings.IsAddFragment);
        radioButtonAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.IsAddFragment = isChecked;
                writeSettings();
            }
        });
    }

    private void initSwitchBackStack(View view) {
        // Элемент пользовательского интерфейса - переключатель
        // По функционалу очень похож на CheckBox, но имеет другой дизайн
        SwitchCompat switchUseBackStack = view.findViewById(R.id.switchBackStack);
        switchUseBackStack.setChecked(Settings.IsBackStack);
        switchUseBackStack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.IsBackStack = isChecked;
                writeSettings();
            }
        });
    }

    private void initSwitchBackAsRemove(View view) {
        SwitchCompat switchBackAsRemove = view.findViewById(R.id.switchBackAsRemove);
        switchBackAsRemove.setChecked(Settings.IsBackAsRemove);
        switchBackAsRemove.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.IsBackAsRemove = isChecked;
                writeSettings();
            }
        });
    }

    private void initSwitchDeleteBeforeAdd(View view) {
        SwitchCompat switchDeleteBeforeAdd = view.findViewById(R.id.switchDeleteBeforeAdd);
        switchDeleteBeforeAdd.setChecked(Settings.IsDeleteBeforeAdd);
        switchDeleteBeforeAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.IsDeleteBeforeAdd = isChecked;
                writeSettings();
            }
        });
    }

    // Сохранение настроек приложения
    private void writeSettings(){
        // Специальный класс для хранения настроек
        SharedPreferences sharedPref = requireActivity().getSharedPreferences(Settings.SHARED_PREFERENCE_NAME, MODE_PRIVATE);
        // Настройки сохраняются посредством специального класса editor.
        SharedPreferences.Editor editor = sharedPref.edit();
        // Задаем значения настроек
        editor.putBoolean(Settings.IS_BACK_STACK_USED, Settings.IsBackStack);
        editor.putBoolean(Settings.IS_ADD_FRAGMENT_USED, Settings.IsAddFragment);
        editor.putBoolean(Settings.IS_BACK_AS_REMOVE_FRAGMENT, Settings.IsBackAsRemove);
        editor.putBoolean(Settings.IS_DELETE_FRAGMENT_BEFORE_ADD, Settings.IsDeleteBeforeAdd);
        // Сохраняем значения настроек
        editor.apply();
    }
}
