package Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Main {

    @BeforeClass
    public static void setUp() {

        System.out.println("Setting up Drivers & Environment");
    }

    @Test(
            priority = 1
    )
    public static void login() throws InterruptedException {

        PostLogin.Login();

    }

}
