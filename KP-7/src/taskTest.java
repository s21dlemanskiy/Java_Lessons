import junit.framework.TestCase;

public class taskTest extends TestCase {
    public void test_task(){
        assertTrue(Main.task("login", "password", "password"));
        assertFalse(Main.task("login  ", "password", "password"));
        assertFalse(Main.task("login", "passwor11d", "password"));
        assertTrue(Main.task("login_", "password12_", "password12_"));
    }

    public void test_check_function(){
        boolean thrown = false;
        try {
            Main.checkACcaunt("login", "password", "password");
        }catch (WrongLoginException | WrongPasswordException e){
            thrown = true;
        }
        assertFalse(thrown);
        try{
            Main.checkACcaunt("login  ", "password", "password");
        }catch (WrongLoginException | WrongPasswordException e){
            thrown = true;
        }
        assertTrue(thrown);
        thrown = false;
        try{
            Main.checkACcaunt("login  ", "password", "password");
        }catch (WrongLoginException | WrongPasswordException e){
            thrown = true;
        }
        assertTrue(thrown);
        thrown = false;
        try{
            Main.checkACcaunt("login  ", "password", "password");
        }catch (WrongLoginException | WrongPasswordException e){
            thrown = true;
        }
        assertTrue(thrown);


    }
}
