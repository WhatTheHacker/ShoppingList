

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    // Containers for storing list items
    static ArrayList<String> shoppingList = new ArrayList<String>();


    public static void main(String[] args) {
        int x = 5;
        x &= 3;
        System.out.println(x);

        show_help();
        add_to_list();
    }

    //> Method for display help
    public static void show_help(){
        System.out.println(
                "================= 🛍 =================\n" +
                "# Welcome to Shopping List App.        \n\n" +
                "> Enter 'DONE' to exit the app.        |\n" +
                "> Enter 'SHOW' to see your items.      | \n" +
                "> Enter 'HELP' to see help.            |\n" +
                "> Enter 'DEL' to delete list item.     |\n" +
                "> Enter 'CLEAR' to remove your list.   |\n" +
                "================= 🛒 ==================");
    }


    //> Method for display users list items
    public  static void show_list(){
        System.out.println("Here is your Regular shopping list");
        System.out.println("-----------------------------------");
        for (String item: shoppingList){
            System.out.println((shoppingList.indexOf(item) + 1) + ". " + item.toUpperCase());
        }
        if (shoppingList.size() <= 1) {
            System.out.println("You have " + shoppingList.size() + " item in your list");
        }
        else {
            System.out.println("You have "+ shoppingList.size() + " items in your list");
        }

    }


    //> Method for remove list
    public static void remove_list(){
        Scanner alert = new Scanner(System.in);
        System.out.println("Are you sure you want to clear your list?\nEnter \"YES\" / \"NO\"");
        String confirm = alert.next();
        if (confirm.contains("yes")){
            shoppingList.clear();
            System.out.println("You just cleared your list completely");
        }
        if (confirm.contains("no")){
            add_to_list();
        }

    }


    //> Method to delete list items
    public  static void delete_item(){

        while (true){
            Scanner delete = new Scanner(System.in);
            System.out.println("Enter 'DONE' to exit Deletion.");
            System.out.print("Enter item to delete >> ");
            String del_item = delete.nextLine();
            if (del_item.contains("done")){
               show_help();
               break;
            }
            shoppingList.remove(del_item);
        }

    }


    //> Method to add item into the list
    public static void add_to_list(){

        while (true){
            Scanner new_item = new Scanner(System.in);
            System.out.print("add item >> ");
            String add_item = new_item.nextLine();

            switch (add_item.toUpperCase()){
                case "DONE":
                    System.out.println("Thanks for using !");
                    System.exit(0);
                    break;
                case "SHOW":
                    show_list();
                    break;
                case "CLEAR":
                    remove_list();
                    break;
                case "DEL":
                    delete_item();
                    break;
                case "HELP":
                    show_help();
                    break;
                default:
                    if (shoppingList.contains(add_item)){
                        System.out.println(add_item + " already in your list");
                    }
                    else if (add_item.contains(",")){
                      // Split the incoming value with coma 
                      String [] split_item = add_item.split(",");
                      // Loop the splitted value and added to the list.
                      for (int i=0; i < split_item.length; i++){
                       shoppingList.add(split_item[i]);
                      }
                    }
                    else{
                        shoppingList.add(add_item);
                    }

            }


        }
    }


}
