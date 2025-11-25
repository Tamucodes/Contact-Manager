import java.util.ArrayList;
import java.util.Scanner;

//contact clas 
class Contact{
    private String name;
    private String phoneNumber;
    private String email;
    //entered names phoneno and email
    public Contact(String name, String phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String getName(){
        return name;
    }
    // for displaying the information on the console
    public void DispalyInfo(){
        System.out.println("Name: " + name + "| Phone Number: " + phoneNumber + "| Email: " + email);
    }
}
// main class
public class App {
    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // add contancts 
    public static void addContact(){
        System.out.print("Enter name:");
        String name  = sc.nextLine();

        System.out.print("Enter phone number:");
        String phoneNumber = sc.nextLine();
        
                
        System.out.print("Enter email:");
        String email = sc.nextLine();
       
        contacts.add(new Contact(name, phoneNumber, email));
        System.out.println("Contact added successfully!");
    }
    //view all contacts
    public static void viewContacts(){
        if(contacts.isEmpty()){
            System.out.print("No contacts available");
            return;
        }

        for(Contact contact : contacts){
            contact.DispalyInfo();
        }
        System.out.println();
    }
    //search contact
    public static void searchContact(){
        System.out.println("Enter the Name to search: ");
        String Name = sc.nextLine();

        for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).getName().equalsIgnoreCase(Name)){
                contacts.get(i).DispalyInfo();
                return;
            }
        }
        System.out.println("Contact not found!");

    }
    //delete contact
    public static void deleltContact(){
        System.out.println("Enter the Name to delete: ");
        String  Name = sc.nextLine();

        for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).getName().equalsIgnoreCase(Name)){
                contacts.remove(i);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }
        System.out.println("Contact not found!"); 
    }
    public static void main(String[] args){
        while(true){
        System.out.println("==make your choice==");
        System.out.println("1. Add Contacts");
        System.out.println("2. View Contacts");
        System.out.println("3. Search Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice){
            case 1: addContact();
                    break;
            case 2: viewContacts();
                    break;  
            case 3: searchContact();
                    break;
            case 4: deleltContact();
                    break;
            case 5: System.out.println("Exiting...");
                    System.exit(0);

                    default: System.out.println("Invalid choice! Please try again.");
        }
    }
        }
}
