package ru.geekbrains.cityheraldry;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CoatOfArmsFragment extends Fragment {

    public static final String ARG_CITY = "city";
    private City city;

    // Фабричный метод создания фрагмента
    // Фрагменты рекомендуется создавать через фабричные методы.
    public static CoatOfArmsFragment newInstance(City city) {
        CoatOfArmsFragment f = new CoatOfArmsFragment();    // создание

        // Передача параметра
        Bundle args = new Bundle();
        args.putParcelable(ARG_CITY, city);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            city = getArguments().getParcelable(ARG_CITY);
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
        imageCoatOfArms.setImageResource(images.getResourceId(city.getImageIndex(), -1));
        // Установить название города
        TextView cityNameView = view.findViewById(R.id.textView);
        cityNameView.setText(city.getCityName());
        return view;
    }
}