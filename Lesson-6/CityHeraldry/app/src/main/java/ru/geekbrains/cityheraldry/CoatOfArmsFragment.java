package ru.geekbrains.cityheraldry;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CoatOfArmsFragment extends Fragment {

    public static final String ARG_INDEX = "index";
    private int index;

    // Фабричный метод создания фрагмента
    // Фрагменты рекомендуется создавать через фабричные методы.
    public static CoatOfArmsFragment newInstance(int index) {
        CoatOfArmsFragment f = new CoatOfArmsFragment();    // создание

        // Передача параметра
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Таким способом можно получить головной элемент из макета
        View view = inflater.inflate(R.layout.fragment_coat_of_arms, container, false);
        // найти в контейнере элемент-изображение
        AppCompatImageView imageCoatOfArms = view.findViewById(R.id.coat_of_arms);
        // Получить из ресурсов массив указателей на изображения гербов
        TypedArray images = getResources().obtainTypedArray(R.array.coat_of_arms_imgs);
        // Выбрать по индексу подходящий
        imageCoatOfArms.setImageResource(images.getResourceId(index, -1));
        return view;
    }
}