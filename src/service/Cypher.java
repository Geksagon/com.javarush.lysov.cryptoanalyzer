package src.service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class Cypher {
     /*Это алфавит используемый, для нескольких режимов, поскольку так будет лучше,
        чем каждый раз создавать отдельный массив чаров и поэтому алфавит объявлен константой.
         */

    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'й',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ','0', '1', '2', '3', '4', '5', '6', '7','8','9'};

    public static void cypher(String userInputFile, String userOutputFile, int userKey){
        String outputFilePath = userOutputFile+"\\"+"result.txt";
        try {
            Files.createFile(Path.of(outputFilePath));
        }catch (IOException eIOE){
            System.out.println("Простите,но возникла ошибка");
            eIOE.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(Path.of(userInputFile))));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Path.of(outputFilePath))))){
            String inStr;
            while ((inStr = br.readLine()) != null) {
                char[] charBuffArray = inStr.toCharArray();

                for (int i = 0 ; i < charBuffArray.length; i++) {
                    for (int j = 0 ; j < ALPHABET.length; j++) {
                        if (charBuffArray[i] == ALPHABET[j]) {
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
