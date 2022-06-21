package contacts_app;

import java.util.Scanner;

public class Contact_test {
    public static void main(String[] args) {


        boolean StopOn = true;
        do {
            System.out.println("1. View Saved Contacts");
            System.out.println("2. Add New Contacts");
            System.out.println("3. Search Saved contacts by name");
            System.out.println("4. Delete Existing Contact");
            System.out.println("5. Exit/Close Application");
            System.out.println("Enter an option(1, 2, 3, 4, or 5): ");

            Scanner sc = new Scanner(System.in);
            int UserChoice = sc.nextInt();
            switch (UserChoice) {
                case 1:
                    System.out.println("was 1 selected");
                    break;
                case 2:
                    System.out.println("was 2 selected");
                    break;
                case 3:
                    System.out.println("was 3 selected");
                    break;
                case 4:
                    System.out.println("was 4 selected");
                    break;
                case 5:
                    System.out.println("was 5 selected");
                    StopOn=false;
                    break;
            }

        } while (StopOn);

    }
}



//        if (UserChoice == 1){
//            //view contacts
//            System.out.println("1 was selected");
//        }
//        if (UserChoice == 2){
//            //add contacts
//            System.out.println("2 was selected");
//        }
//        if (UserChoice == 3){
//            //search for contacts
//            System.out.println("3 was selected");
//        }
//        if (UserChoice == 4){
//            //delete contacts
//            System.out.println("4 was selected");
//        }
//        if (UserChoice == 5){
//            //exit app
//            System.out.println("5 was selected");
//        }


//        public class ContactsApp{
//            private static path filepath = path.of(System.getProperty("user.dir"));
//            private static File file;
//            private Static ArrayList<Contacts> contacts = new ArrayList<>();
//
//
//            public static void initializedFile()  {

//    }
//}


