package ru.geekbrains.resources;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSomeTexts();

        AppCompatImageView image = findViewById(R.id.imageView);
        loadImageFromAsset(image, "android.png");

        initList();
    }

    private void initSomeTexts() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/19659.ttf");

        // Вывод ресурсов в строки программно
        TextView descriptionLanguage = findViewById(R.id.textVLang);
        descriptionLanguage.setText(getResources().getString(R.string.descriptionLanguage));
        descriptionLanguage.setTypeface(tf);
        TextView textLanguage = findViewById(R.id.textLang);
        textLanguage.setText(getResources().getString(R.string.language));
    }

    private void loadImageFromAsset(ImageView image, String fileName) {
        try {
            InputStream ims = getAssets().open(fileName);
            // загружаем как Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // выводим картинку в ImageView
            image.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }

    private void initList(){
        LinearLayout layoutList = findViewById(R.id.layoutList);

        // Получить массив со строками из ресурсов
        String[] versions = getResources().getStringArray(R.array.version_names);

        // Получить из ресурсов массив указателей на изображения
        TypedArray imgs = getResources().obtainTypedArray(R.array.version_logos);

        // При помощи этого объекта будем доставать элементы, спрятанные в android_item.xml
        LayoutInflater ltInflater = getLayoutInflater();

        for (int i = 0; i < versions.length; i++){
            String version = versions[i];
            // Достаем элемент из item.xml
            View item = ltInflater.inflate(R.layout.android_item, layoutList, false);
            // Находим в этом элементе TextView
            TextView tv = item.findViewById(R.id.textAndroid);
            tv.setText(version);

            // Выбрать по индексу подходящее изображение
            AppCompatImageView imgLogo = item.findViewById(R.id.imageAndroid);
            imgLogo.setImageResource(imgs.getResourceId(i, -1));

            layoutList.addView(item);
        }
    }
}