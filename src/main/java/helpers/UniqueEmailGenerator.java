package helpers;
import org.apache.commons.lang3.RandomStringUtils;
public class UniqueEmailGenerator {
    public static String getUniqueRandomEmail(){

        String lowCharacters = "abcdefghijklmnopqrstuvwxy";
        String upperCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXY";
        String numberCharacters = "0123456789";

        return RandomStringUtils.random(3,lowCharacters)
                + RandomStringUtils.random(3,upperCharacters)
                + RandomStringUtils.random(3,numberCharacters)
                +"@mail.com";
    }
}

