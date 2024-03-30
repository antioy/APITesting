package tests;

import api.GetRequests;
import api.PostRequests;
import helpers.UniqueEmailGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.namespace.QName;
import java.io.IOException;

public class RegistrationAndLogin {

    private static String email;
    private static String password;

    @BeforeTest
    public static void credentials() {
        email = "testcourse111 @mail.bg";
        password = "Uspehi100%%%";
    }

    @Test
    public static void SuccessfulUserRegistration() throws IOException {

        PostRequests postRequests = new PostRequests();
        //Generate unique email address and registration user
        UniqueEmailGenerator uniqueEmail = new UniqueEmailGenerator();
        String email = uniqueEmail.getUniqueRandomEmail();
        postRequests.createAccount(name, email,password);
        Assert.assertTrue(postRequests.getResponseCode().contains("200"));
        Assert.assertTrue(postRequests.getAuthMessage().contains("success"));


    }

    @Test
    public static  void SuccessfulRegistrationAndLogin() throws IOException {
        PostRequests postRequests = new PostRequests();
        UniqueEmailGenerator uniqueEmail = new UniqueEmailGenerator();
        String email = uniqueEmail.getUniqueRandomEmail();
        postRequests.createAccount(name, email,password);
        Assert.assertTrue(postRequests.getResponseCode().contains("200"));
        Assert.assertTrue(postRequests.getAuthMessage().contains("success"));
        //Login user
        postRequests.login(email, password);
        Assert.assertTrue(postRequests.getResponseCode().contains("200"));
        Assert.assertTrue(postRequests.getAuthMessage().contains("success"));
    }
    @Test
    public  static  void SuccessfulLoginAndGetUser() throws IOException {
        PostRequests postRequests = new PostRequests();
        GetRequests getRequests = new GetRequests();
        //Generate unique email address and registration user
        UniqueEmailGenerator uniqueEmail = new UniqueEmailGenerator();
        String email = uniqueEmail.getUniqueRandomEmail();
        String name;
        postRequests.createAccount(name, email,password);
        Assert.assertTrue(postRequests.getResponseCode().contains("200"));
        Assert.assertTrue(postRequests.getAuthMessage().contains("success"));
        //Login user
        postRequests.login(email, password);
        Assert.assertTrue(postRequests.getResponseCode().contains("200"));
        Assert.assertTrue(postRequests.getAuthMessage().contains("success"));
        String token = postRequests.getAccessToken();
        String id = postRequests.getUserId();
        //Get User
        getRequests.getUser(id,token);
        Assert.assertTrue(getRequests.getResponseCode ().contains("200"));
        Assert.assertTrue(getRequests.getAuthMessage().contains(name));
    }

    @Test
    public static void invalidPassword() throws IOException {

        PostRequests postRequests = new PostRequests();
        //Generate unique email address and registration user
        UniqueEmailGenerator uniqueEmail = new UniqueEmailGenerator();
        String email = uniqueEmail.getUniqueRandomEmail();
        String name;
        postRequests.createAccount(name, email,password);
        Assert.assertTrue(postRequests.getResponseCode().contains("200"));
        Assert.assertTrue(postRequests.getAuthMessage().contains("success"));
        //Login user with invalid password
        postRequests.login(email, "2125");
        Assert.assertTrue(postRequests.getResponseCode().contains("200"));
        Assert.assertTrue(postRequests.getAuthMessage().contains("invalid"));
    }

    }


}