package vinylApp.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveReadFile {

    public static final String LOG_FILE_PATH = "databases/logAndPass/logDataBase.txt";
    public static final String PASS_FILE_PATH = "databases/logAndPass/passDataBase.txt";


    public static void saveInFile(ArrayList<String> data, String filePath) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(filePath);
        for (String datum : data) {
            printWriter.write(datum.concat("\n"));
        }
        printWriter.close();
    }


    public static void saveMoreInFile(ArrayList<String> data, String filePath) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        for(String datum : data){
            printWriter.write(datum.concat("\n"));
        }
        printWriter.close();
    }

    public static void saveOneMoreInFile(String data, String filePath) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        printWriter.write(data.concat("\n"));
        printWriter.close();
    }


    public static ArrayList<String> readAllFromFile(String filePath) throws IOException {

        ArrayList<String>copyList = new ArrayList<>();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);
        String readOneLineFromFile= reader.readLine();

        while(readOneLineFromFile != null)
        {
            copyList.add(readOneLineFromFile);
            readOneLineFromFile = reader.readLine();

        }
        reader.close();
        return copyList;
    }

}
