package ru.geekbrains.socialnetwork.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import ru.geekbrains.socialnetwork.R;
import ru.geekbrains.socialnetwork.data.CardsSource;
import ru.geekbrains.socialnetwork.data.CardsSourceImpl;

public class SocialNetworkFragment extends Fragment {

    public static SocialNetworkFragment newInstance() {
        return new SocialNetworkFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_socialnetwork, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_lines);
        // Получим источник данных для списка
        CardsSource data = new CardsSourceImpl(getResources()).init();
        initRecyclerView(recyclerView, data);
        return view;
    }

    private void initRecyclerView(RecyclerView recyclerView, CardsSource data){

        // Эта установка служит для повышения производительности системы
        recyclerView.setHasFixedSize(true);

        // Будем работать со встроенным менеджером
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Установим адаптер
        final SocialNetworkAdapter adapter = new SocialNetworkAdapter(data);
        recyclerView.setAdapter(adapter);

        // Установим слушателя
        adapter.SetOnItemClickListener(new SocialNetworkAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), String.format("Позиция - %d", position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}