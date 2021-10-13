package ru.job4j.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class StartUI {

    /*
        Имеется 3 способа внедрения зависимости:

        1. Через конструктор. Правильный способ.

        2. Через поле и аннотацию @Autowired. Нежелательный способ.

        3. Через метод set и аннотацию @Autowired. Нежелательный способ.
     */
    // Здесь используется способ через поле и аннотацию @Autowired
    @Autowired
    private Store store;
    @Autowired
    private ConsoleInput consoleInput;

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }

    @Override
    public String toString() {
        return "StartUI{" +
                "store=" + store +
                '}';
    }
}