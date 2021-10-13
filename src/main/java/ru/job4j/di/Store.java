package ru.job4j.di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
/*
Перечистим все режимы.

    1. singleton - объект создает один раз на всю виртуальную машину.

    2. prototype - каждый раз создается новый объект.

    3. session - объект существует, пока существует сессия пользователя.

    4. request - объект существует, пока существует запрос.

    5. application - объект существует, пока существует ServletContext.

    6. websocket - объект существует, пока есть активная сессия для web-сокета.


    Spring по умолчанию создает объекты в режиме singleton, то есть один объект на виртуальную машину.
 */
public class Store {
    private List<String> data = new ArrayList<>();

    public void add(String value) {
        data.add(value);
    }

    public List<String> getAll() {
        return data;
    }

    @Override
    public String toString() {
        return "Store{" +
                "data=" + data +
                '}';
    }
}