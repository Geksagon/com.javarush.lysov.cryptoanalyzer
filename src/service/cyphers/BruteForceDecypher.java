package src.service.cyphers;

import src.service.filemanagers.FileManager;
import src.service.filemanagers.Menu;
import src.service.filemanagers.PostCheckerFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForceDecypher {
    
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'й',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э','ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ','0',
            '1', '2', '3', '4', '5', '6', '7','8','9','A', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'Й',
            'И','К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э','Ю', 'Я'};
    public static void bruteForceDecypher (){

        String userInputFile = Menu.isUserInputFilePathMethod();
        String userOutputFile = Menu.isUserOutputFilePathMethod();
        String userOutputFileName = Menu.isUserOutputFileNameMethod();

        for (int programKey = 2; programKey < ALPHABET.length; programKey++) {

            Path outputFilePath = Path.of(FileManager.outFilePath(userOutputFile,userOutputFileName));

            try {
                Files.createFile(outputFilePath);
            }catch (IOException eIOE){
                System.out.println("Простите,но возникла ошибка");
                eIOE.printStackTrace();
            }

            try(BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(Path.of(userInputFile))));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(outputFilePath)))){
                String inStr;
                while ((inStr = br.readLine()) != null) {
                    char[] charBuffArray = inStr.toCharArray();

                    for (int i = 0 ; i < charBuffArray.length; i++) {
                        for (int j = 0 ; j < ALPHABET.length; j++) {
                            if (charBuffArray[i] == ALPHABET[j]) {
                                if((j-programKey) < 0) {
                                    charBuffArray[i] = ALPHABET[(ALPHABET.length + (j - programKey))];
                                    break;
                                }
                                else
                                    charBuffArray[i] = ALPHABET[j - programKey];
                                break;
                            }
                        }
                    }
                    String outStr = new String(charBuffArray);
                    bw.write(outStr);
                    bw.newLine();

                }
                

            }catch (IOException eIOE){
                System.out.println("Простите,но возникла ошибка");
                eIOE.printStackTrace();
            }

            try {

                if(PostCheckerFile.postCheckerFile(outputFilePath)) break;
                else Files.delete(outputFilePath);
            }catch (IOException eIOE){

                System.out.println("Простите,но возникла ошибка");
                eIOE.printStackTrace();
            }
        }
        System.out.println("Всё готово,проверьте!");




    }
}
