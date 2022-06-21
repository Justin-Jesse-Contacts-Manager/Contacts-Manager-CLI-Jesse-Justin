package contacts_app;

import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Contact_test {
    private static final Path filepath = Path.of(System.getProperty("user.dir"));
    private static File file;
    private static final ArrayList<Contact> contacts = new ArrayList<>();


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

//    public static void FormatContacts() throws FileNotFoundException {
//        Scanner sc = new Scanner(file);
//        while (sc.hasNextLine()){
//            contacts.add(new Contact(sc.next() + " "+ sc.next(), sc.nextLong()));
//        }
//
//    }
    public static void showContacts() throws IOException{

        System.out.println("name | Phone #");
        System.out.println("=-=-=-=-=-=-=-");
        for (Contact contact: contacts) {
            System.out.printf("%s  |  %d\n", contact.getName(), contact.getNumber());
        }
    }


    public static void MenuManager() throws IOException {
//        FormatContacts();
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
                    break;
                case 4:
                    System.out.println("4 was  selected");
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
