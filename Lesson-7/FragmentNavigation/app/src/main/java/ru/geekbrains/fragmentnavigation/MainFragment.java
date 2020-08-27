package ru.geekbrains.fragmentnavigation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        setHasOptionsMenu(true);
        initPopupMenu(view);
        return view;
    }

    private void initPopupMenu(View view) {
        TextView text = view.findViewById(R.id.textView);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = requireActivity();
                PopupMenu popupMenu = new PopupMenu(activity, v);
                activity.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                Menu menu = popupMenu.getMenu();
                menu.findItem(R.id.item2_popup).setVisible(false);
                menu.add(0, 123456, 12, R.string.new_menu_item_added);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.item1_popup:
                                Toast.makeText(getContext(), "Chosen popup item 1", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.item2_popup:
                                Toast.makeText(getContext(), "Chosen popup item 2", Toast.LENGTH_SHORT).show();
                                return true;
                            case 123456:
                                Toast.makeText(getContext(), "Chosen new item added", Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add){
            Toast.makeText(getContext(), "Chosen add", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}