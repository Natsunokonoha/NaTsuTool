package Config;

public class ServerConfig {
    private final String host;
    private final int port;
    private final String path;

    public ServerConfig(String host, int port, String path) {
        this.host = host;
        this.port = port;
        this.path = path;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }

    public static ServerConfig getDefaultConfigForLogin(String apiUrl) {
        // Ensure you have imported or properly referenced the Config.Setting.Config.ServerConfig class
        String host = Setting.ServerConfig.Host();
        int port = Setting.ServerConfig.Port();
        String basePath = Setting.ServerConfig.Path();
        String fullPath = basePath.endsWith("/") ? basePath + apiUrl : basePath + "/" + apiUrl;
        return new ServerConfig(host, port, fullPath);
    }
}
