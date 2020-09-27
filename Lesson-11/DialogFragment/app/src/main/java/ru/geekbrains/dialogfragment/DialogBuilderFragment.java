package ru.geekbrains.dialogfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogBuilderFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Вытаскиваем макет диалога
        // https://stackoverflow.com/questions/15151783/stackoverflowerror-when-trying-to-inflate-a-custom-layout-for-an-alertdialog-ins
        final View contentView = requireActivity().getLayoutInflater().inflate(R.layout.dialog_custom, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity())
                .setTitle(R.string.title_dialog)
                .setView(contentView)
                .setPositiveButton(R.string.done, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText editText = contentView.findViewById(R.id.editText);
                        String answer = editText.getText().toString();
                        dismiss();
                        ((MainActivity) requireActivity()).onDialogResult(answer);
                    }
                });
        return builder.create();
    }
}
