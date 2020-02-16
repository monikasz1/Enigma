package file.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileTool { //w metodzie będzie przyjmował ścieżke do pliku, żeby zwrócic stringa sformatowanego jak tekst
    public static String getFileContent(String pathToFile) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {      //pobieramy resourca, tu bedzie resourcem buffered reader
            String line = reader.readLine(); //readline przechodzi do następnej linii
            while (line != null) {
                stringBuilder.append(line).append("\n");
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + pathToFile);
        } catch (IOException e) {
            System.out.println("Some problem with file ... :" + e);
        }
        return stringBuilder.toString();
    }
}

