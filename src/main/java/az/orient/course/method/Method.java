package az.orient.course.method;

import az.orient.course.util.AdminUtil;
import az.orient.course.util.FileUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class Method {

    public static void seeAllDictionaries() throws Exception {
        try {
            List<String> list = FileUtility.readFile(FileUtility.DICTIONARIES_FILE_PATH);
            for (String s : list) {
                System.out.println(s);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("There is no dictionary is system!!!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void createNewDictionary() throws Exception {

        System.out.println("Which language do you want to make a dictionary?");
        Scanner sc = new Scanner(System.in);

        String dictName = sc.nextLine();
        String filePath = FileUtility.FOLDER_PATH + "/" + dictName + ".txt";

        List<String> dictList = FileUtility.readFile(FileUtility.DICTIONARIES_FILE_PATH);

        for (String dict : dictList) {
            if (dict.equalsIgnoreCase(dictName)) {
                System.out.println(dictName + " is already exist");
                AdminUtil.process();
            }
        }

        PrintWriter writer = new PrintWriter(filePath, "UTF-8");
        writer.close();

        FileUtility.appendIntoFile(FileUtility.DICTIONARIES_FILE_PATH, dictName);
        System.out.println("Success!!!");
    }

    public static void addNewWord(String filePath) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first word: ");
        String firstWord = sc.next();

        System.out.println("Enter second word: ");
        String secondWord = sc.next();

        String text = firstWord + "-" + secondWord;

        FileUtility.appendIntoFile(filePath, text);
        System.out.println("Success!!!");

    }

    public static void addNewAdmin() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String username = sc.next();

        System.out.println("Enter password");
        String password = sc.next();

        List<String> list = FileUtility.readFile(FileUtility.ADMIN_FILE_PATH);

        for (String s : list) {
            String[] arr = s.split(" ");
            if (username.equalsIgnoreCase(arr[0])) {
                System.out.println("username is already exist!!!");
                AdminUtil.process();
            }
        }
        String text = username + " " + password;
        FileUtility.appendIntoFile(FileUtility.ADMIN_FILE_PATH, text);
        System.out.println("Success!!!");
    }

    public static void deleteWord(String word, String filePath) throws Exception {

        List<String> words = FileUtility.readFile(filePath);

        for (int i = 0; i < words.toArray().length; i++) {
            if (words.get(i).equalsIgnoreCase(word)) continue;

            FileUtility.writeIntoFile(filePath, words.get(i));
        }
    }

    public static String translate(String word, String filePath) throws Exception {
        Map<String, String> map = new HashMap<>();
        String res = null;
        Scanner scanner = new Scanner(new FileReader(filePath));

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            String[] dataParse = data.split("-");
            map.put(dataParse[0], dataParse[1]);
            map.put(dataParse[1], dataParse[0]);
        }

        if (map.containsKey(word)) {
            res = map.get(word);
        } else {
            res = "Not Found!";
        }
        map.clear();
        return res;
    }

    public static void update(String word, String newWord, String filePath) throws Exception {

        List<String> words = FileUtility.readFile(filePath);

        Map<String, String> dictMap = new HashMap<>();

        for (String s : words) {
            String[] arr = s.split("-");
            dictMap.put(arr[0], arr[1]);
        }

        Collection<String> values = dictMap.values();
        List<String> valuesList = new ArrayList<>();
        valuesList.addAll(values);

        Set<String> keys = dictMap.keySet();
        List<String> keysList =new ArrayList<>();
        keysList.addAll(keys);

        if (values.contains(word)) {
            valuesList.set(valuesList.indexOf(word), newWord);
        }

        if (keys.contains(word)) {
            keysList.set(keysList.indexOf(word), newWord);
        }

        PrintWriter writer = new PrintWriter(filePath);
        writer.close();

        for (int i = 0; i < words.toArray().length; i++) {
            String text = keysList.get(i) + "-" + valuesList.get(i);
            FileUtility.appendIntoFile(filePath, text);
        }
    }

    public static String findDictFilePath() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which dictionary do you want to change?");
        String dictName = sc.next();


        List<String> list = FileUtility.readFile(FileUtility.DICTIONARIES_FILE_PATH);

        for (String s : list) {
            if (s.equalsIgnoreCase(dictName)) {
                String filePath = FileUtility.FOLDER_PATH.concat("/").concat(dictName + ".txt");
                return filePath;
            }
        }
        throw new FileNotFoundException("Not Found");
    }
}
