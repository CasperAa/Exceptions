public class UserValidator {
    boolean endValidator = true;
    boolean userExist = false;

    public boolean validateUser(String username, int password) {
        while (endValidator) {
            for (int i = 0; Users.getUserList().size() > i; i++) {
                if (Users.getUserList().get(i).getUsername().equals(username) && Users.getUserList().get(i).getPassword() == password) {
                    System.out.println("Welcome Back!");
                    userExist = true;
                }
            }
            if (!userExist) {
                throw new NoSuchUserException();
            }
        endValidator = false;
        }
        return true;
    }
}


