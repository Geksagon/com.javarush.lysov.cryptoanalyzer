package src.service.cyphers;

import src.service.filemanagers.FileManager;
import src.service.filemanagers.Menu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class Cypher {
     /*Это алфавит используемый, для нескольких режимов, поскольку так будет лучше,
        чем каждый раз создавать отдельный массив чаров и поэтому алфавит объявлен константой.
         */

    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'й',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э','ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ','0',
            '1', '2', '3', '4', '5', '6', '7','8','9','A', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'Й',
            'И','К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э','Ю', 'Я'};

    public static void cypher(){
        String userInputFile = Menu.isUserInputFilePathMethod();
        int userKey = Menu.isUserKeyMethod();
        String userOutputFile = Menu.isUserOutputFilePathMethod();
        String userOutputFileName = Menu.isUserOutputFileNameMethod();

        if (userKey > ALPHABET.length) {
            if (userKey % 85 == 0) userKey = 85;
            else userKey = userKey % 85;
        }

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
                            if((userKey + j) > 85) {
                                charBuffArray[i] = ALPHABET[j + userKey-86];
                                break;
                            }
                            else
                                charBuffArray[i] = ALPHABET[j + userKey];
                            break;
                        }
                    }
                }
                String outStr = new String(charBuffArray);
                bw.write(outStr);
                bw.newLine();

            }

            System.out.println("Всё готово,проверьте!");

        }catch (IOException eIOE){
            System.out.println("Простите,но возникла ошибка");
            eIOE.printStackTrace();
        }

    }
}
