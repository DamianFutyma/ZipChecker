package model;

import java.util.Scanner;

public class CheckingGivenPostCode {

    static String postCode=null;

    static void checkString(){
         while (true){
             Scanner scanner= new Scanner(System.in);
             String codeToCheck=scanner.nextLine();
             String pattern="[0-9]{2}-?[0-9]{3}";
             if(codeToCheck.matches(pattern)){
                 postCode=codeToCheck;
                 break;

             }else
                 System.out.println("Wrong format of zip code. Type new post code!");
         }
    }

}
