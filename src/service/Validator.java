package src.service;

import java.nio.file.Files;
import java.nio.file.Path;


public class Validator {
    public static boolean isValidKey(String key) {
        try {
            int keyInt = Integer.parseInt(key);
            if(keyInt < 0 ){
                System.out.println("Кажется вы ввели отрицательное число число");
                System.out.println("Попробуйте ещё раз");
                return true;
            } else if (keyInt == 0) {
                System.out.println("Кажется вы ввели ноль в качестве числа");
                System.out.println("Попробуйте ещё раз");
                return true;

            } else{
                System.out.println("Вы ввели число" +" "+key);
                return false;
            }
        }catch(NumberFormatException exFE){
            System.out.println("Кажется вы ввели не число или превысили лимит числа");
            System.out.println("Попробуйте ещё раз");
            return true;
        }
    }
    public static boolean isFileExists(String filePath) {
        if(Files.exists(Path.of(filePath))) return false;
        else {
            System.out.println("Такого файла не существует или вы ввели неправильный путь");
            return true;
        }
    }
}

