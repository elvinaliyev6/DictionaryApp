package az.orient.course.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {

    public static final String ADMIN_FILE_PATH = "C://dictionary/admin.txt";
    public static final String USER_FILE_PATH = "C://dictionary/user.txt";
    public static final String FOLDER_PATH = "C://dictionary";
    public static final String DICTIONARIES_FILE_PATH = "C://dictionary/dictionaries.txt";

    private static void writeIntoFile(String fileName, String text, boolean append) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, append));) {
            bw.write(text);
            bw.newLine();
        }
    }

    public static void writeIntoFile(String fileName, String text) throws Exception {
        writeIntoFile(fileName, text, false);
    }

    public static void appendIntoFile(String fileName, String text) throws Exception {
        writeIntoFile(fileName, text, true);
    }

    public static List<String> readFile(String fileName) throws Exception {

        List<String> list = new ArrayList<>();
        BufferedReader bw = new BufferedReader(new FileReader(fileName));

        while(bw.ready()) {
            String s = bw.readLine();
            list.add(s);
        }
        return list;
    }


}
