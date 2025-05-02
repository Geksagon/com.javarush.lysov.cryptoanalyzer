package src.service.filemanagers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class Validator {

    private static final char[] ALLOWED_CHARACTERS = {'\\', '/', ';', ':', '*', '|', '"', '<', '>'};

    public static boolean isValidKey(String key) {
        try {
            int keyInt = Integer.parseInt(key);
            if(keyInt < 0 ){
                System.out.println("Кажется вы ввели отрицательное число число");
                System.out.println("Попробуйте ещё раз");
                return false;
            } else if (keyInt == 0) {
                System.out.println("Кажется вы ввели ноль в качестве числа");
                System.out.println("Попробуйте ещё раз");
                return false;
            } else{
            System.out.println("Вы ввели число" + " " + key);
            return true;
            }
        }catch(NumberFormatException exFE){
            System.out.println("Кажется вы ввели не число или превысили лимит числа");
            System.out.println("Попробуйте ещё раз");
            return false;
        }
    }
    public static boolean isNumberNotHigh(String keyString, int limit){
        try {
            int keyInt = Integer.parseInt(keyString);
            if (keyInt > limit) {
                System.out.println("Кажется вы выбрали пункт которого нет в списке");
                System.out.println("Попробуйте ещё раз");
                return false;
            }
            else return true;
        }catch(NumberFormatException exFE){
            System.out.println("Кажется вы ввели не число или превысили лимит числа");
            System.out.println("Попробуйте ещё раз");
            return false;
        }

    }

    public static int isCorrectNumberForMenu(){
        Scanner scanner = new Scanner(System.in);
        String bufferChoice;
        while (true) {
            bufferChoice = scanner.nextLine();
            if (Validator.isNumberNotHigh(bufferChoice, 3) && Validator.isValidKey(bufferChoice)){
                return Integer.parseInt(bufferChoice);
            }
        }
    }

    public static boolean isFileExists(String InputFilePath) {
        Path pathIFP = Path.of(InputFilePath);
        if(Files.exists(pathIFP) && Files.isRegularFile(pathIFP)) return true;
        else {
            System.out.println("Такого файла не существует или вы ввели неправильный путь");
            return false;
        }
    }
    public static boolean isDirectoryExists(String OutputDirectoryPath){
        if(Files.isDirectory(Path.of(OutputDirectoryPath))) return true;
        else {
            System.out.println("Такой директории не существует или вы ввели неправильный путь к ней");
            return false;
        }
    }
    public static boolean isValidFileName(String userOutputFileName){
        char[] charNameArray = userOutputFileName.toCharArray();

            for (int i = 0 ; i < charNameArray.length; i++) {
                for (int j = 0; j < ALLOWED_CHARACTERS.length; j++) {
                    if (charNameArray[i] == ALLOWED_CHARACTERS[j]) {
                        System.out.println("Вы использовали недопустимые знаки");
                        return false;
                    }
                }

            }
        return true;
    }

}

