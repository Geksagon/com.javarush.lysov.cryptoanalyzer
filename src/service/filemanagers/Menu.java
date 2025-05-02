package src.service.filemanagers;

import java.util.Scanner;

public class Menu {
    public static String isUserInputFilePathMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста,введите путь к файлу, с которым вы хотите работать");
        String userInputFilePath = scanner.nextLine();
        if(Validator.isFileExists(userInputFilePath))  return userInputFilePath;
        else return Menu.isUserInputFilePathMethod();
    }
    public static int isUserKeyMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, введите целое число-ключ,чтобы зашифровать текст");
        String userKeyStr = scanner.nextLine();
        if(Validator.isValidKey(userKeyStr)) return Integer.parseInt(userKeyStr);
        else return Menu.isUserKeyMethod();
    }
    public static String isUserOutputFilePathMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, введите путь куда бы вы хотели сохранить зашифрованный файл");
        String userOutputFilePath = scanner.nextLine();
        if(Validator.isDirectoryExists(userOutputFilePath)) return userOutputFilePath;
        else return Menu.isUserOutputFilePathMethod();
    }
    public static String isUserOutputFileNameMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, введите имя для зашифрованного файла");
        String userOutputFileName = scanner.nextLine();
        if(Validator.isValidFileName(userOutputFileName)) return userOutputFileName;
        else return Menu.isUserOutputFileNameMethod();
    }
}
