public class UserValidator {

    public boolean validateUser(String username, int password){
        for(int i = 0; Users.getUserList().size() > i ; i++){
            System.out.println(i);
            System.out.println("input: " + username + "    validator: " + Users.getUserList().get(i).getUsername());
            System.out.println("input: " + password + "    validator: " + Users.getUserList().get(i).getPassword());


            if(!Users.getUserList().get(i).getUsername().equals(username) && Users.getUserList().get(i).getPassword() != password) {
                    System.out.println("                    Wrong input");
                    throw new NoSuchUserException();
            } else {
                System.out.println("Welcome Back");
            }
        }
        return true;
    }
}
