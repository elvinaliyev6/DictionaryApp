package az.orient.course.util;

import az.orient.course.main.Main;
import az.orient.course.method.Method;

import java.util.Scanner;

public class UserUtil {
    public static void process() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. See all current dictionaries in system:\n" + "2. Search word: \n" + "3. Return login menu: \n" + "4. Exit");

        switch (sc.nextInt()) {
            case 1:
                Method.seeAllDictionaries();
                process();
                break;
            case 2:
                System.out.println("Which dictionary do you want to translate the word in?");
                sc = new Scanner(System.in);
                String dictName = sc.next();

                String filePath = FileUtility.FOLDER_PATH.concat("/").concat(dictName + ".txt");

                System.out.println("Write word which you want translate: ");
                String word = sc.next();

                String result = Method.translate(word, filePath);
                System.out.println("Result=" + result);
                process();
                break;
            case 3:
                Main.main(null);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid!!!");

        }
    }
}
