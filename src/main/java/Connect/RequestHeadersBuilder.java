package Connect;

import Config.Setting;

import java.util.LinkedHashMap;
import java.util.Map;

public class RequestHeadersBuilder {

    public static Map<String, String> buildHeaders(String userId, int contentLength, String host, int port, String Api_Url) {
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("number", "0");
        headers.put("Content-Type", "application/json");
        headers.put("User-Agent", String.format("%s#%s", Api_Url, userId));
        headers.put("charset", "UTF-8");
        headers.put("Mai-Encoding", String.format("%s", Setting.ServerConfig.Version()));
        headers.put("Content-Length", String.valueOf(contentLength));
        headers.put("Expect", "100-continue");
        headers.put("Host", String.format("%s:%d", host, port));
        return headers;
    }
}