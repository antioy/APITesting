package helpers;

public class JsonParser {

    public static void main(String[] args) {    }

    public static String getAccessToken(String in) {
        String[] json = in.split(",");
        String data = json[5];
        data = data.replace("}", "");
        String[] key = data.split(":");
        String value = key[1];
        String value1 = value.replace("\"", "");
        String accessToken = value1.replace("\n", "");
        return accessToken;
    }

    public static String getResponseCode(String in) {
        String[] json = in.split(",");
        String data = json[0];
        data = data.replace("{", "");
        String[] key = data.split(":");
        String value = key[1];

        String code = value.replace("\"", "");
        return code;
    }

    public static String getAuthMessage(String in) {
        String[] json = in.split(",");
        String data = json[2];
        data = data.replace("{", "");
        String[] key = data.split(":");
        String value = key[2];
        String message = value.replace("\"", "");
        return message;
    }

    public static String getId(String in) {
        String[] json = in.split(",");
        String data = json[2];
        data = data.replace("{", "");
        String[] key = data.split(":");
        String value = key[2];
        String message = value.replace("\"", "");
        return message;
    }
}
