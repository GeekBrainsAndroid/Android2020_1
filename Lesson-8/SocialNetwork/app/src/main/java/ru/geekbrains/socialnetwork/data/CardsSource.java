package ru.geekbrains.socialnetwork.data;

public interface CardsSource {
    CardData getCardData(int position);
    int size();
}
