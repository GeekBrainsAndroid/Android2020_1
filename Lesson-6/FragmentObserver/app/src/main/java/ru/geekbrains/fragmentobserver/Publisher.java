package ru.geekbrains.fragmentobserver;

import java.util.ArrayList;
import java.util.List;

// Обработчик подписок
public class Publisher {

    private List<Observer> observers;   // Все обозреватели

    public Publisher() {
        observers = new ArrayList<>();
    }

    // Подписать
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    // Отписать
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    // Разослать событие
    public void notify(String text) {
        for (Observer observer : observers) {
            observer.updateText(text);
        }
    }
}