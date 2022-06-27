package az.orient.course.main;

import az.orient.course.util.AdminUtil;
import az.orient.course.util.FileUtility;
import az.orient.course.util.MainUtil;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        try {
            MainUtil.process();
        }catch (FileNotFoundException ex){
            System.err.println("Fayl tapilmadi");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
