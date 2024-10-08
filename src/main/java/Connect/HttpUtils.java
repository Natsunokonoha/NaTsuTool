package Connect;

import javax.net.ssl.HttpsURLConnection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;


public class HttpUtils {

    public static byte[] sendHttpRequest(String host, int port, String path, byte[] requestData, Map<String, String> headers) throws IOException {
        URL url = new URL("https", host, port, path);  // 使用https协议
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();  // 用HttpsURLConnection代替HttpURLConnection
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        for (Map.Entry<String, String> header : headers.entrySet()) {
            connection.setRequestProperty(header.getKey(), header.getValue());
        }

        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(requestData);
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            try (InputStream inputStream = connection.getInputStream()) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                return outputStream.toByteArray();
            }
        } else {
            try (InputStream errorStream = connection.getErrorStream()) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = errorStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                throw new IOException("请求失败: " + outputStream.toString(StandardCharsets.UTF_8));
            }
        }
    }
}
