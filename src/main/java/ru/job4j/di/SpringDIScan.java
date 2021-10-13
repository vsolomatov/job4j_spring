package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
    Класс демонстрирует использование сканирования проекта на те классы, которые должны быть в контексте.

    Чтобы Spring понял, какие классы нужно зарегистрировать в Context нужно эти классы пометить аннотацией @Component, смотри классы Store, StartUI, ConsoleInput

    Spring bean - это класс, который зарегистрирован в Spring Context
 */
public class SpringDIScan {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // Spring сканирует папки ru.job4j.di. Если класс отмечен аннотацией @Component, то он регистрирует этот класс в контексте.
        context.scan("ru.job4j.di");
        context.refresh();

        // Получаем из контекста Spring bean
        StartUI ui = context.getBean(StartUI.class);
        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
    }
}