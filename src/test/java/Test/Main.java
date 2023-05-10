package Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {

    @BeforeClass
    public static void setUp(){

        System.out.println("Setting up Drivers & Environment");
    }

    @Test
    public static void login() throws InterruptedException {

        PostLogin.Login();

    }

}
