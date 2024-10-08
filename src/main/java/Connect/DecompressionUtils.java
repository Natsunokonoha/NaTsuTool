package Connect;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import Config.Setting;

public class DecompressionUtils {

    public static byte[] decompress(byte[] compressedData) {
        try {
            Inflater inflater = new Inflater();
            inflater.setInput(compressedData);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            return outputStream.toByteArray();
        } catch (DataFormatException e) {
            return compressedData;
        }
    }

    public static class AESUtils {
        private static final byte[] AES_KEY = Setting.Key.AES().getBytes(StandardCharsets.UTF_8);
        private static final byte[] AES_IV = Setting.Key.IV().getBytes(StandardCharsets.UTF_8);

        public static byte[] aesEncrypt(byte[] plaintext) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                SecretKeySpec secretKey = new SecretKeySpec(AES_KEY, "AES");
                IvParameterSpec ivSpec = new IvParameterSpec(AES_IV);
                cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
                return cipher.doFinal(plaintext);
            } catch (NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException | javax.crypto.NoSuchPaddingException | javax.crypto.IllegalBlockSizeException | javax.crypto.BadPaddingException e) {
                throw new RuntimeException("AES 加密失败: " + e.getMessage());
            }
        }

        public static byte[] aesDecrypt(byte[] ciphertext) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                SecretKeySpec secretKey = new SecretKeySpec(AES_KEY, "AES");
                IvParameterSpec ivSpec = new IvParameterSpec(AES_IV);
                cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
                return cipher.doFinal(ciphertext);
            } catch (NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException | javax.crypto.NoSuchPaddingException | javax.crypto.IllegalBlockSizeException | javax.crypto.BadPaddingException e) {
                throw new RuntimeException("AES 解密失败: " + e.getMessage());
            }
        }
    }
}
