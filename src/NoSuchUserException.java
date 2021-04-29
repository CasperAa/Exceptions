public class NoSuchUserException extends RuntimeException{
    NoSuchUserException(){
    super("User does not exist");
    }
}
