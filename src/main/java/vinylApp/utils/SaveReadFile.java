package vinylApp.utils;

import java.io.*;
import java.util.ArrayList;


public class SaveReadFile {

    public SaveReadFile() {
    }
// -----------------without streams don't work JAR file after building maven (TO READ).

    //TO SAVE
    public static String LOG_FILE_PATH = "src/main/resources/databases/logAndPass/logDataBase.txt";
    public static String PASS_FILE_PATH = "src/main/resources/databases/logAndPass/passDataBase.txt";


    //to READ
    public InputStream logFilePathStream = getClass().
            getResourceAsStream("/databases/logAndPass/logDataBase.txt");

    public InputStream passFilePathStream = getClass().
            getResourceAsStream("/databases/logAndPass/passDataBase.txt");


    public static void saveOneMoreInFile(String data, String filePath) throws FileNotFoundException {

        FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        printWriter.write(data.concat("\n"));
        printWriter.close();
    }


    public static ArrayList<String> readAllFromFile(InputStream stream) throws IOException {
        ArrayList<String> copyList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new
                InputStreamReader(stream));

        String readOneLineFromFile = bufferedReader.readLine();

        while (readOneLineFromFile != null) {
            copyList.add(readOneLineFromFile);
            readOneLineFromFile = bufferedReader.readLine();
        }
        bufferedReader.close();   // when i CLOSE THIS I CANT READ FILES MORE THAN ONE   !! !  : O
                                //but when i left open i can't create new database
        return copyList;
    }
}


//
    // public static void createNewFileIfNotExist (String filePath) {
//
    //     File f = new File(filePath);
    //     if(!f.exists()){
    //         try {
    //             f.createNewFile();
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         }
    //     }else{
    //         System.out.println("File already exists");
    //     }





/* OLD VERSION DON'T WORK WHEN I RUN JAR FILE in IDEA OK

    public static final String LOG_FILE_PATH = "src/main/resources/databases/logAndPass/logDataBase.txt";
    public static final String PASS_FILE_PATH = "src/main/resources/databases/logAndPass/passDataBase.txt";


    public static void saveOneMoreInFile(String data, String filePath) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        printWriter.write(data.concat("\n"));
        printWriter.close();
    }


    public static ArrayList<String> readAllFromFile(String filePath) throws IOException {

        ArrayList<String> copyList = new ArrayList<>();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);
        String readOneLineFromFile = reader.readLine();

        while (readOneLineFromFile != null) {
            copyList.add(readOneLineFromFile);
            readOneLineFromFile = reader.readLine();

        }
        reader.close();
        return copyList;
    }


 */