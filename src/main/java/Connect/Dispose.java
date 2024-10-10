package Connect;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import Config.ServerConfig;

public class Dispose {
    public static String build(String userId, String Api_Url, String dataToEncrypt) {
        byte[] plaintext = dataToEncrypt.getBytes(StandardCharsets.UTF_8);

        byte[] encryptedData = DecompressionUtils.AESUtils.aesEncrypt(plaintext);

        ServerConfig config = ServerConfig.getDefaultConfigForLogin(Api_Url); // 获取默认的服务器配置

        Map<String, String> headers = RequestHeadersBuilder.buildHeaders(userId, encryptedData.length, config.getHost(), config.getPort(), Api_Url);
        try {
            byte[] responseData = HttpUtils.sendHttpRequest(config.getHost(), config.getPort(), config.getPath(), encryptedData, headers);
            byte[] decompressedData = DecompressionUtils.decompress(responseData);
            byte[] decryptedData = DecompressionUtils.AESUtils.aesDecrypt(decompressedData);

            // 转换为字符串并打印解密后的数据
//            System.out.println(new String(decryptedData, StandardCharsets.UTF_8));
            return new String(decryptedData, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("加密或解密失败: " + e.getMessage());
            return "Error: " + e.getMessage();
        }
    }
}