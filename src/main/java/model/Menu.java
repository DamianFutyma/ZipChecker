package model;

import java.io.IOException;

public class Menu {


    public static void myMenu() throws IOException {
        System.out.println("Witaj w programie! Prosze o podanie kodu pocztowego");
        CheckingGivenPostCode.checkString();
        JSONReader.showJSON(CheckingGivenPostCode.postCode);

    }
}
