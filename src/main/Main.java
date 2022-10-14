package main;

import util.InputUtil;
import util.MenuUtil;


public class Main {
    public static void main(String[] args) {


        int menu = 0;
        while (true) {
            menu = InputUtil.requiredNumber("What do you want to do?" +
                    "\n1.Register students" +
                    "\n2.Show all students" +
                    "\n3.Find students" +
                    "\n4.Update students" +
                    "\n5.Exit");
            MenuUtil.processMenu(menu);

        }
    }
}
