package ru.job4j.di;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class ConsoleInput {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        //System.out.print(question);
        return scanner.nextLine();
    }

    public String ask(String question, ArrayList<String> range) {
        String key = this.ask(question);

        boolean exist = false;
        for (String value : range) {
            //System.out.println(value);
            if (key.equals(value)) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}

