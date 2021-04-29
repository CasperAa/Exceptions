public class UserValidator {
    public boolean validateUser(String username, int password){
        for(int i = 0; i < Users.getUserList().size(); i++){
            if(!username.equals(Users.getUsername()) && password != Users.getPassword()) {
                throw new NoSuchUserException();
        }
        if(!username.equals(Users.getUsername()) && password != Users.getPassword()) {
            throw new NoSuchUserException();
        }
        return true;
    }
}
