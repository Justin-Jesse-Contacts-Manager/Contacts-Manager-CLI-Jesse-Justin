package contacts_app;

import java.io.*;
import java.nio.file.*;
import java.nio.file.Path;
import java.util.*;


public class Contact_test {
    private static  Path filepath = Path.of(System.getProperty("user.dir"));
    private static File file;
    private static  ArrayList<Contact> contacts = new ArrayList<>();






    public static void createContactsFile() throws IOException {
        System.out.println("Welcome to our Contacts App, Please wait while the program initializes");
        if (Files.exists(Path.of(filepath + "/contacts.txt"))) {
            System.out.println("Contacts file Found");
        } else {
            Files.createFile(Path.of(filepath + "/contacts.txt"));
            System.out.println("Contacts file Not Found, Contacts.TXT folder has been added,Program will now restart to verify changes ");
            System.exit(0);
        }
        file = new File(filepath + "/contacts.txt");
    }

//    public static void formatContacts() throws IOException {
//
//        while (contacts.hasNextLine()){
//            contacts.add(new Contact(sc.next() + " "+ sc.next(), sc.nextLong()));
//        }
//
//    }

    public static void addContact() throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the name of your new contact: ");
        String contactName = sc.nextLine();
        System.out.println("Please enter the Phone # of your new contact: ");
        long contactNumber = sc.nextLong();
        Contact newContact = new Contact(contactName, contactNumber);

        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println();
        pw.print(newContact.getName()+ " " + newContact.getNumber());
        pw.close();


    }


    public static void searchContact() throws IOException {
        List<String>Contacts = Files.readAllLines(Paths.get("contacts.txt"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of your contact: ");
        String search = sc.nextLine();
        System.out.println("Matched contacts: ");
        for (String Contact : Contacts) {
            if (Contact.toUpperCase().contains(search.toUpperCase())) {
                System.out.printf("%s\n",Contact);
            }
        }
    }

     public static void addContactFile() throws IOException{
         FileWriter fw = new FileWriter(file);
         PrintWriter pw = new PrintWriter(fw);
         int counter = 0;
         for (Contact contact: contacts) {
             if (counter != contacts.size() - 1) {
                 pw.println(contact.getName() + " " + contact.getNumber());
             } else {
                 pw.print(contact.getName() + " " + contact.getNumber());
             }
             counter++;
         }
         pw.close();
     }

     public static void deleteContact() throws IOException{
         List<String>Contacts = Files.readAllLines(Paths.get("contacts.txt"));
         Scanner sc = new Scanner(System.in);
//        ArrayList<Contact> newContacts = new ArrayList<>();
         System.out.println("Please Enter the Name you would like to delete: ");
         String search = sc.nextLine();
         for (String Contact : Contacts) {
             if(Contact.toUpperCase().contains(search.toUpperCase())){
                 System.out.println("User Found");
                 System.out.println(Contact);
                 System.out.printf("Are you sure you would like to delete : %s\n Yes / No",Contact);
                 String Confirm = sc.nextLine();
                 if(Confirm.equals("Yes")){
                        Contact = "";
                 }
                 if(Confirm.equals("No")){
                     System.out.println("Canceling Current Task");
                     break;
                 }else {
                     System.out.println("User canceled last Command, Closing current Loop");
                     break;
                 }
             }else {
                 System.out.println("sorry I did not recognize that Command, Closing current Loop");
                 break;
             }
         }
     }


    public static void showContacts() throws IOException {
        List<String>Contacts = Files.readAllLines(Paths.get("contacts.txt"));
        System.out.println("name | Phone #");
        System.out.println("=-=-=-=-=-=-=-");
        for (String Contact : Contacts) {
            System.out.printf("%s\n", Contact);
        }
    }


    public static void MenuManager() throws IOException {
//        formatContacts();
        createContactsFile();

        boolean Stop = true;
        System.out.println("1. View Saved Contacts");
        System.out.println("2. Add New Contacts");
        System.out.println("3. Search Saved contacts by name");
        System.out.println("4. Delete Existing Contact");
        System.out.println("5. Exit/Close Application");
        System.out.println("Enter an option(1, 2, 3, 4, or 5): ");
        do {


            Scanner sc = new Scanner(System.in);
            int UserChoice = sc.nextInt();
            switch (UserChoice) {
                case 1 -> {
                    System.out.println("1 was  selected");
                    showContacts();
                }
                case 2 -> {
                    System.out.println("2 was  selected");
                    addContact();
                }
                case 3 -> {
                    System.out.println("3 was  selected");
                    searchContact();
                }
                case 4 -> {
                    System.out.println("4 was  selected");
                    deleteContact();
                }
                case 5 -> {
                    System.out.println("5 was  selected");
                    Stop = false;
                }
            }
        } while (Stop);
    }


    public static void main(String[] args) throws IOException {
        MenuManager();
    }
}