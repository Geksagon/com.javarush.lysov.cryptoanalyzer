package src.service.filemanagers;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public static String outFilePath(String userOutputFile, String userOutputFileName ){

        String outputFilePath = userOutputFile + "\\" + userOutputFileName + ".txt";
        Path userPath = Path.of(userOutputFile +"\\"+ userOutputFileName +".txt");

        for (int i = 1; i < Integer.MAX_VALUE ; i++) {
            if(Files.exists(userPath) && !(Files.exists(Path.of((userOutputFile+"\\" + userOutputFileName + " " + "(1)" + ".txt"))))){
                outputFilePath = userOutputFile+"\\" + userOutputFileName + " " + "(1)" + ".txt";
                break;
            }
            else if (Files.exists(Path.of((userOutputFile+"\\" + userOutputFileName + " " + "(" + i + ")" + ".txt"))) && !(Files.exists(Path.of((userOutputFile + "\\" + userOutputFileName + " " + "(" + (i+1) + ")" + ".txt"))))) {
                outputFilePath = userOutputFile+"\\" + userOutputFileName + " " + "(" + (i+1) + ")" + ".txt";
                break;
            }
            else if (!(Files.exists((userPath)))) break;
        }
        return outputFilePath;
    }
}
