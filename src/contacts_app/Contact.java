package contacts_app;

import java.util.Scanner;

public class Contact {
    public static void main(String[] args) {

        System.out.println("1. View Saved Contacts");
        System.out.println("2. Add New Contacts");
        System.out.println("3. Search Saved contacts by name");
        System.out.println("4. Delete Existing Contact");
        System.out.println("5. Exit/Close Application");
        System.out.println("Enter an option(1, 2, 3, 4, or 5): ");

        Scanner sc = new Scanner(System.in);
        int UserChoice = sc.nextInt();

        if (UserChoice == 1){
            //view contacts
            System.out.println("1 was selected");

        }
        if (UserChoice == 2){
            //add contacts
            System.out.println("2 was selected");
        }
        if (UserChoice == 3){
            //search for contacts
            System.out.println("3 was selected");
        }
        if (UserChoice == 4){
            //delete contacts
            System.out.println("4 was selected");
        }
        if (UserChoice == 5){
            //exit app
            System.out.println("5 was selected");
        }


//        public class ContactsApp{
//            private static path filepath = path.of(System.getProperty("user.dir"));
//            private static File file;
//            private Static ArrayList<Contacts> contacts = new ArrayList<>();
//
//
//            public static void initializedFile()  {

    }
}
