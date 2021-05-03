import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidation {
    static boolean CheckForRepeatingChars = true;
    public static void main(String[] args) {
        Scanner userPassword = new Scanner(System.in);
        System.out.println("Input Password:");
        isValidPassword(userPassword.nextLine());
    }

    //Skal være mellem 6 og 40 tegn
    //Skal indeholde både bogstaver og tal
    //Må ikke indeholde visse specialtegn, herunder æ, ø og å
    //Må ikke indeholde det samme tegn 4 gange i træk
    //Må hverken starte eller slutte med et blanktegn
    //Må ikke indeholde dit cpr- eller NemID-nummer
    //Der skelnes ikke mellem store og små bogstaver.
    //Tilladte specialtegn er: { } ! # " $ ’ % ^ & , * ( ) _ + - = : ; ? . og @.

    public static void isValidPassword(String password) {
        if (lengthCheck(password)){
            if(containsLettersAndNumbersCheck(password)){
                if (specialSymbolsCheck(password)){
                    if (hasRepeatChars(password)){
                        if(startAndEndConditionCheck(password)){
                            System.out.println("password is valid");
                        }
                    }
                }
            }
        }

        }
    //Works
    public static boolean lengthCheck(String password) {
        int shortLength = 6;
        int maxLength = 40;
        if (password.length() > shortLength && password.length() < maxLength) {
            System.out.println("Valid length");
            return true;
        } else {
            System.out.println("invalid length");
            return false;
        }
    }
    //Works
    public static boolean containsLettersAndNumbersCheck(String password) {
        String numberCheck = ".*[0-9].*";
        String lowerCaseLetterCheck = ".*[a-z].*";
        String upperCaseLetterCheck = ".*[A-Z].*";

        if (password.matches(numberCheck) && (password.matches(lowerCaseLetterCheck) || password.matches(upperCaseLetterCheck))) {
            System.out.println("Contains both numbers and letters");
            return true;
        } else {
            System.out.println("Doesn't contain numbers and letters");
            return false;
        }
    }
    //Doesn't work 100%
    public static boolean specialSymbolsCheck (String password){
        Pattern specialLettersCheck = Pattern.compile("[^a-z0-9 ]");
        Matcher comparePasswordToSpecialLettersCheck = specialLettersCheck.matcher(password);
        boolean consistOfSpecialSymbols = comparePasswordToSpecialLettersCheck.find();
        if (!consistOfSpecialSymbols || !password.contains("æ") || !password.contains("Æ") || !password.contains("å") || !password.contains("Å") || !password.contains("ø") || !password.contains("Ø")) {
            System.out.println("Doesn't contain special numbers");
            return true;
        } else {
            System.out.println("Contain special numbers");
            return false;
        }
    }
    //Doesn't work
    public static boolean hasRepeatChars(String password) {
        if (CheckForRepeatingChars) {
            for (int i = 0; i < password.length(); i += 4) {
                char a = password.charAt(i);
                char[] data = {a, a, a, a};
                String repeat = new String(data);
                if (!password.contains(repeat)) {
                    System.out.println("Doesn't have repeating numbers");
                    return true;
                }
            }
        } else {
            System.out.println("Have repeating numbers");
            return false;
        }
        System.out.println("This shouldn't happen");
        return false;
    }
    //works
    public static boolean startAndEndConditionCheck (String password){
            Pattern p = Pattern.compile("^[^\\ ].*[^\\ .]$");
            Matcher m = p.matcher(password);
            if (m.find()){
                System.out.println("Doesn't start or end with space");
                return true;
            } else {
                System.out.println("Starts or end with space");
                return false;
            }
    }
}
