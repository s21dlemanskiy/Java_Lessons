import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Test;

public class Main {
    public static void main(String[] args) {

    }

    public static boolean task(String login, String password, String confirmPassword){
        try{
            checkACcaunt(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            return false;
        }
    }

    public static boolean tasktask(String login, String password, String confirmPassword){
        try{
            checkACcaunt(login, password, confirmPassword);
            return true;
        } catch (WrongPasswordException e) {
            return false;
        } catch (WrongLoginException e) {
            return false;
        }
    }

    public static void checkACcaunt(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        String regex_login = "^[A-Z|a-z|_]{0,20}$";
        if (! Pattern.compile(regex_login).matcher(login).matches()){
            throw new WrongLoginException("Login dosn't match pattern(mast cunsists of latin letters and '_' and be not longet then 20)");
        }
        String regex_password = "^[A-Z|a-z|_|\\d]{0,20}$";
        if (! Pattern.compile(regex_login).matcher(login).matches()){
            throw new WrongPasswordException("Password dosn't match pattern(mast cunsists of latin letters and digitals and '_' and be not longet then 20)");
        }
        if (! password.equals(confirmPassword)){
            throw new WrongPasswordException("Password and confirmPassword not equal");
        }

    }
}