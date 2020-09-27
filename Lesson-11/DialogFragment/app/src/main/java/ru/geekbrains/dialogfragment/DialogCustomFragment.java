package ru.geekbrains.dialogfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class DialogCustomFragment extends DialogFragment {

    private EditText editText;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Подключаем макет
        View view = inflater.inflate(R.layout.dialogfragment_custom, null);

        // Устанавливаем слушателя
        view.findViewById(R.id.button).setOnClickListener(listener);
        editText = view.findViewById(R.id.editText);

        // Запретить выход из диалога ничего не выбрав
        setCancelable(false);
        return view;
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Закрываем диалог
            dismiss();
            // Передаём в Activity информацию об нажатой кнопке
            String answer = editText.getText().toString();
            ((MainActivity) requireActivity()).onDialogResult(answer);
        }
    };

}
