public class Base64Utils {
    public static String encode(byte[] data) {
        return java.util.Base64.getEncoder().encodeToString(data);
    }
}
