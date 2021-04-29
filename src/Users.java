import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {


    private final String username;
    private final int password;
    private static ArrayList<Users> UserList;

        //Constructor
        public Users (String username, int password) {
            this.username = username;
            this.password = password;
        }

        //method that transfers data from CSV file to the program
        public static void createTheListWithUsers() throws FileNotFoundException {
            File fileWithUsers = new File("Files/NamesWithPassword.csv");
            Scanner fileScanner = new Scanner(fileWithUsers);
            UserList = new ArrayList<>();

            //Skips metadata
            fileScanner.nextLine();

            //While-loop, for all rows in the file
            while (fileScanner.hasNext()) {

                String currentUser = fileScanner.nextLine();
                //Split-method for at opdele linjen

                String[] lineAsArray = currentUser.split(",");

                String username = lineAsArray[0].trim();
                int password = Integer.parseInt(lineAsArray[1].trim());

                //Opretter et ny instance af ingrediensen
                Users newUser = new Users(username, password);
                //Tilføjer den til ArrayListen
                UserList.add(newUser);
            }
        }

    public int getPassword() {
        return password;
    }
    public String getUsername(){
        return username;
    }

    public static ArrayList<Users> getUserList() {
        return UserList;
    }
}
