package com.company;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<>();

//        cities.add("Athens");
//        cities.add("New York");
//        cities.add("Shanghai");
//        cities.add("Suzhou");

//        visitCities(cities);


        System.out.println(addCitiesInOrder(cities,"New York"));
        System.out.println(addCitiesInOrder(cities,"Boston"));
        addCitiesInOrder(cities, "ZooCity");
        System.out.println(addCitiesInOrder(cities,"Shanghai"));
        System.out.println(addCitiesInOrder(cities,"Athens"));
        System.out.println(addCitiesInOrder(cities,"Watertown"));
        System.out.println(addCitiesInOrder(cities,"Madison"));
        System.out.println(addCitiesInOrder(cities,"Waterville"));
        System.out.println(addCitiesInOrder(cities,"Boston"));
        System.out.println(addCitiesInOrder(cities,"Boston"));
        System.out.println("Now adding weird name");
        System.out.println(addCitiesInOrder(cities,"~!#$%&&*("));

        menu(cities);

    }

    public static void visitCities(LinkedList<String> cities) {
        Iterator<String> I = cities.iterator();

        System.out.println();
        System.out.println("****************");
        while (I.hasNext()) {
            System.out.println("Now visiting: " + I.next());
        }

        System.out.println("*****************");
    }

    public static boolean addCitiesInOrder(LinkedList<String> cities,String cityToAdd) {
        ListIterator<String> I = cities.listIterator();

        while(I.hasNext()) {
            int compare = I.next().compareTo(cityToAdd);
            System.out.println("compare equals: " + compare);

            if(compare == 0) {
                System.out.println("City already added");
                return false;
            }
            else if(compare > 0) {
                I.previous();
                I.add(cityToAdd);
                return true;
            }

        }

        I.add(cityToAdd);
        return true;
    }

    public static void menu(LinkedList<String> cities) {


        ListIterator<String> I = cities.listIterator();

        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        while(flag) {
            System.out.println("Press 1 to go to the previous city");
            System.out.println("Press 2 to go to the next city");
            System.out.println("Press 3 to exit");
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                if (I.hasPrevious()) {
                    System.out.println("Now going back to " + I.previous());
                } else {
                    System.out.println("You are at the first city");
                }
            }
            if (userInput == 2) {
                if (I.hasNext())
                    System.out.println("Now going to: " + I.next());
            } else {
                System.out.println("No more cities to go to");
            }
            if (userInput == 3) {
                System.out.println("Goodbye");
                flag = false;
            }
        }

    }

}
