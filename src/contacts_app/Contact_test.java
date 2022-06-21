package contacts_app;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static java.nio.file.Files.exists;
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

    public static void formatContacts() throws FileNotFoundException {
        Scanner sc1 = new Scanner(file);
        while (sc1.hasNextLine()){
            contacts.add(new Contact(sc1.next() + " "+ sc1.next(), sc1.nextLong()));
        }

    }
    public static void searchContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of your contact: ");
        String search = sc.nextLine();
        System.out.println("Matched contacts: ");
        for (Contact contact: contacts) {
            if (contact.getName().toUpperCase().contains(search.toUpperCase())) {
                System.out.println(contact.getName() + " | " + contact.getNumber());
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
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> newContacts = new ArrayList<>();
         System.out.println("Please Enter the Name you would like to delete: ");
         String search = sc.nextLine();
         for (Contact contact : contacts) {
             if(!contact.getName().toUpperCase().contains(search.toUpperCase())){
                 newContacts.add(contact);
             }
         }
         contacts = newContacts;
         addContactFile();
     }


    public static void showContacts() throws IOException{

        System.out.println("name | Phone #");
        System.out.println("=-=-=-=-=-=-=-");
        for (Contact contact: contacts) {
            System.out.printf("%s  |  %d\n", contact.getName(), contact.getNumber());
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
                case 1:
                    System.out.println("1 was  selected");
                    showContacts();
                    break;
                case 2:
                    System.out.println("2 was  selected");

                    break;
                case 3:
                    System.out.println("3 was  selected");
                    searchContact();
                    break;
                case 4:
                    System.out.println("4 was  selected");
                    deleteContact();
                    break;
                case 5:
                    System.out.println("5 was  selected");
                    Stop = false;
                    break;
            }
        } while (Stop);
    }


    public static void main(String[] args) throws IOException {
        MenuManager();
    }
}