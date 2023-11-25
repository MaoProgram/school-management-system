package Domain.Dto;
import Domain.Dao.Crud.Services;
import Domain.Dao.Crud.academicManager;
import Domain.Entity.Course;
import Domain.Entity.Student;

import java.util.Scanner;

public class Menu {
academicManager academic = new academicManager();
Student students = new Student();
Course courses = new Course();
Services services = new Services();
    public void menuPrincipal() {
        Scanner VlInput = new Scanner(System.in);
        int selector = showMenuPrincipalOptions();
        while (selector != 5) {

            switch (selector) {

                case 1 -> academic.addStudent();
                case 2 -> academic.consultStudent();
                case 3 -> academic.addStudent();
                case 4 -> academic.consultStudent();

            }
            selector = showMenuPrincipalOptions();
        }
    }


    static int showMenuPrincipalOptions() {
        String[] menuInventSale = {
                "Management School",
                "1. Add Student",
                "2. Consult Student",
                "3. Add Course",
                "4. Consult Course",
                "5. Enroll Student Course",
                "6. Unsubscribe Student Course",
                "Choose an option:"

        };
        printMenuWithBorder(menuInventSale);


        Scanner scanner = new Scanner(System.in);
        int selector = 5;
        try {
            selector = scanner.nextInt();
            if (selector < 1 || selector > 4) {
                System.out.println("| The Option selected is not valid. Please try again |");
                showMenuPrincipalOptions();
            }
        } catch (Exception e) {
            System.out.println("| The Option selected is not valid. Please try again |");
            System.out.println("You are entering a different type of character");
            showMenuPrincipalOptions();
        }
        return selector;

    }

    public static void printMenuWithBorder(String[] mainMenu) {
        int maxLength = 0;
        for (String item : mainMenu) {
            if (item.length() > maxLength) {
                maxLength = item.length();
            }
        }
        // Imprimir el borde superior
        printBorder(maxLength + 4);

        // Imprimir el contenido del menú
        for (int i = 0; i < mainMenu.length; i++) {
            int espaciosAntes = (maxLength - mainMenu[i].length()) / 2;
            int espaciosDespues = maxLength - mainMenu[i].length() - espaciosAntes;
            if (i == 0) {
                System.out.println("*" + addSpaces(espaciosAntes) + " " + mainMenu[i] + addSpaces(espaciosDespues) + "*");
            } else {

                System.out.println("* " + mainMenu[i] + addSpaces(espaciosDespues));
            }
        }

        // Imprimir el borde inferior
        printBorder(maxLength + 4);
    }

    public static void printBorder(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }
        System.out.println();

    }

    public static String addSpaces(int count) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }
}