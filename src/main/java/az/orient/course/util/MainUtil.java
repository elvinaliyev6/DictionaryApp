package az.orient.course.util;

import java.io.*;
import java.util.Scanner;

public class MainUtil {

    public static void process() throws Exception {
        Scanner sc=new Scanner(System.in);

        System.out.println("admin or user?");

        switch (sc.next()) {
            case "admin":
                AdminUtil.start();
                break;
            case "user":
                UserUtil.process();
                break;
            default:
                System.out.println("Invalid");
                break;
        }
    }

    public static boolean login(String username, String password, String filePath) throws Exception {
        File file=new File(FileUtility.FOLDER_PATH);
        if(!file.exists()){
            file.mkdir();
        }
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
            String[] arr = br.readLine().split(" ");
            if (username.equalsIgnoreCase(arr[0]) && password.equalsIgnoreCase(arr[1])) {
                return true;
            }
        }
        return false;
    }

}
