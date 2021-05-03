import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NemIdAuthorizer {
    public static void main(String[] args) throws FileNotFoundException {
        Users.createTheListWithUsers();
        askForCPR();
    }

    //A try / catch, checks if user is in the list, trows exception if false
    public static void isValidInput(String username, int password){
        try{
            UserValidator validator = new UserValidator();
            validator.validateUser(username, password);

        } catch (InputMismatchException exception){
            throw new NoSuchUserException();
        }
    }
    //Method ask for user input
    public static void askForCPR(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter username");
        String username = userInput.nextLine();
        System.out.println("Enter password");
        int password = userInput.nextInt();
        isValidInput(username, password);
    }
}
