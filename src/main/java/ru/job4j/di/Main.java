package ru.job4j.di;

/*
    Класс демонстрирует использование нашего класса Context, имитирующего контекст
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        // Мы сами не создаем объекты классов Store, ConsoleInput, StartUIContext за нас это делает класс Context.
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUIContext.class);

        StartUIContext ui = context.get(StartUIContext.class);

        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
    }
}
