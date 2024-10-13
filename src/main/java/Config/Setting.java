package Config;

public class Setting {

    public static class Api {
        // 内部静态类 Login
        public static String Login() { return "d1d4e8194631fe932a399fa96483fe7b"; }
        public static String ratting() {
            return "7886b5c1307cdaba12a0c5285c0464f0";
        }
        public static String juan() {
            return "949d55efb2ea032f511b97aa153473f7";
        }
        public static String logout() {
            return "6165a4a2828e5ac54c215da37b83a71d";
        }
        public static String userData() { return "9bf7b5cbd258358e0de2188b324b6272"; }
        public static String userExtend() { return "73f95003558d73b3392337a7a86459e4"; }
        public static String userOption() { return "dc877d2c8fbb9305317ed79e71b48e56"; }
        public static String userCharacterList() { return "16768656af052a9a3cd612e3a612a219"; } //旅行伙伴updata
        public static String userItemList() { return "e168a0bcd17a57ce9ce302b4ad9c4713";} //用户物品
        public static String userMapList() { return "05ee513488df5591935157cc6877399e"; }

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

        public static String Version() {return "1.40"; }
    }
    public static String clientId() {
        return "A63E01E1191";
    }

    public static class Others {
        public static int Thread() { return 5; }
    }
}
