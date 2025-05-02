package src;

import src.service.cyphers.BruteForceDecypher;
import src.service.cyphers.Cypher;
import src.service.cyphers.Decypher;
import src.service.filemanagers.Menu;
import src.service.filemanagers.Validator;


import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
    boolean exit = true, secondExit = true;

    while(exit){
        System.out.println(" ");
        System.out.println("МЕНЮ:");
        System.out.println(" ");
        System.out.println("1.Шифрование");
        System.out.println("2.Расшифрование");
        System.out.println("3.Выход");

        switch (Validator.isCorrectNumberForMenu()) {
            case 1:
                Cypher.cypher();
                break;
            case 2:
                while (secondExit){
                    System.out.println(" ");
                    System.out.println("1.Расшифровка с имеющимся ключом");
                    System.out.println("2.Расшифрование методом БрутФорса");
                    System.out.println("3.Выход в главное меню");
                    switch (Validator.isCorrectNumberForMenu()) {
                        case 1:
                            Decypher.decypher();
                            break;
                        case 2:
                            BruteForceDecypher.bruteForceDecypher();
                            break;
                        case 3:
                            secondExit = false;
                            break;
                    }
                }
                secondExit = true;
                break;
            case 3:
                exit = false;
                break;
        }
    }
    }
}
