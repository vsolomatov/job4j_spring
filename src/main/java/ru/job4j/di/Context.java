package ru.job4j.di;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Имитация реализации контекста DI.
    В этом примере мы будем использовать рефлексию.
    Рефлексия позволяет узнать какие элементы имеет класс в процессе выполнения программы.
 */
public class Context {
    private Map<String, Object> els = new HashMap<>();

    public void reg(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalStateException("Class has multiple constructors : " + cl.getCanonicalName());
        }
        Constructor con = constructors[0];
        List<Object> args = new ArrayList<>();
        for (Class arg : con.getParameterTypes()) {
            if (!els.containsKey(arg.getCanonicalName())) {
                throw new IllegalStateException("Object doesn't found in context : " + arg.getCanonicalName());
            }
            args.add(els.get(arg.getCanonicalName()));
        }
        try {
            els.put(cl.getCanonicalName(), con.newInstance(args.toArray()));
        } catch (Exception e) {
            throw new IllegalStateException("Coun't create an instance of : " + cl.getCanonicalName(), e);
        }
    }

    /*
        Метод get возвращает проинициализированный объект.
     */
    public <T> T get(Class<T> inst) {
        return (T) els.get(inst.getCanonicalName()); // здесь мы используем рефлексию: inst.getCanonicalName(), т.е. имя класса мы узнаем в процессе выполнения программы
    }
}
