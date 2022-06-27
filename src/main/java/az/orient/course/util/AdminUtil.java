package az.orient.course.util;

import az.orient.course.main.Main;
import az.orient.course.method.Method;

import java.util.Scanner;

public class AdminUtil {

    public static void start() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();

        if (MainUtil.login(username, password, FileUtility.ADMIN_FILE_PATH)) {
            System.out.println("Successfully logged in!!!");
            AdminUtil.process();
        } else {
            System.out.println("username or password is incorrect!!!");
        }
    }

    public static void process() throws Exception {
        System.out.println("1. See all current dictionaries in system:\n" +
                "2. Create new Dictionary:\n" +
                "3. Add new word to dictionary\n" +
                "4. Delete word from dictionary\n" +
                "5. Update the word in the dictionary\n" +
                "6. Create new admin\n" +
                "7. Return login menu\n" +
                "8. Exit");

        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                Method.seeAllDictionaries();
                process();
                break;
            case 2:
                Method.createNewDictionary();
                process();
                break;
            case 3:
                String filePath=Method.findDictFilePath();
                Method.addNewWord(filePath);
                process();
                break;
            case 4:
                 filePath=Method.findDictFilePath();

                System.out.println("Enter first word: ");
                String firstWord = sc.next();

                System.out.println("Enter second word: ");
                String secondWord = sc.next();

                String word = firstWord + "-" + secondWord;

                Method.deleteWord(word,filePath);
                System.out.println("Successfully deleted!");
                process();
                break;
            case 5:
                filePath= Method.findDictFilePath();

                System.out.println("Which word do you want to update?");
                 word=sc.next();

                System.out.println("Which word do you want replace "+word+" with?");
                String newWord=sc.next();

                Method.update(word,newWord,filePath);
                System.out.println("Successfuly updated!");
                process();
                break;
            case 6:
                Method.addNewAdmin();
                Main.main(null);
                break;
            case 7:
                Main.main(null);
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid!!!");

        }

    }
}
