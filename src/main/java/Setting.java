public class Setting {

    public static class Api {
        // 内部静态类 Login
        public static String Login() {
            return "d1d4e8194631fe932a399fa96483fe7b";
        }
        public static String ratting() {
            return "7886b5c1307cdaba12a0c5285c0464f0";
        }
        public static String juan() {
            return "949d55efb2ea032f511b97aa153473f7";
        }
        public static String logout() {
            return "6165a4a2828e5ac54c215da37b83a71d";
        }
    }

    public static class Key {
        public static String AES(){
            return "n7bx6:@Fg_:2;5E89Phy7AyIcpxEQ:R@";
        }
        public static String IV(){
            return ";;KjR1C3hgB1ovXa";
        }
    }

    public static class ServerConfig {
        public static String Host() {
            return "maimai-gm.wahlap.com";
        }

        public static int Port() {
            return 42081;
        }

        public static String Path() {
            return "/Maimai2Servlet/";
        }
    }

}
