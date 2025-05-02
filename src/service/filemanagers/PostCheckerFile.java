package src.service.filemanagers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;

public class PostCheckerFile {
    private static final HashSet<String> FREQUENTLY_USED_WORDS = new HashSet<>(Arrays.asList("быть","кто","что","она","это","этот","свой",
            "который","весь","все","всё","так","для","мочь","год","один","его","тот","человек","только",
            "такой","себя","сказать","ещё","еще","мой","или","говорить","время","уже","когда","другой",
            "наш","если","знать","вот","сам","день","дело","при","стать","чтобы","самый","жизнь","очень",
            "даже","два","нет","рука","первый","под","где","новый","слово","какой","раз","теперь", "идти",
            "без","после","иметь","там","ничто","должен","большой","видеть","место","хотеть","можно",
            "глаз"));
    public static boolean postCheckerFile (Path programInputFile){


        try(BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(programInputFile)))){
            String inStr;
            while ((inStr = br.readLine()) != null) {
                if (inStr.trim().isEmpty()) {
                    continue;
                }
                for (String word : inStr.split("\\s+")) {
                    if (!word.isEmpty()) {
                        if (FREQUENTLY_USED_WORDS.contains(word.toLowerCase())) {
                            return true;
                        }
                    }
                }
            }
        }catch (IOException eIOE){
            System.out.println("Простите,но возникла ошибка");
            eIOE.printStackTrace();
        }
        return false;
    }
}
