package model;

import java.io.IOException;

public class Menu {


    public static void myMenu() throws IOException {
        System.out.println("Welcome in the CodeFinder 9000. Please enter searching zip code!");
        CheckingGivenPostCode.checkString();
        JSONReader.showJSON(CheckingGivenPostCode.postCode);

    }
}
