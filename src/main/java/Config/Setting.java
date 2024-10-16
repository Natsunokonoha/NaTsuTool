package Config;

public class Setting {

    public static class Api {
        // 内部静态类 Login
        public static String Login() { return "UserLoginApiMaimaiChn"; }
        public static String ratting() {
            return "GetUserPreviewApiMaimaiChn";
        }
        public static String juan() {
            return "UpsertUserChargelogApiMaimaiChn";
        }
        public static String logout() {
            return "UserLogoutApiMaimaiChn";
        }
        public static String userData() { return "GetUserDataApiMaimaiChn"; }
        public static String userExtend() { return "GetUserExtendApiMaimaiChn"; }
        public static String userOption() { return "GetUserOptionApiMaimaiChn"; }
        public static String userCharacterList() { return "16768656af052a9a3cd612e3a612a219"; } //旅行伙伴updata
        public static String userItemList() { return "e168a0bcd17a57ce9ce302b4ad9c4713";} //用户物品
        public static String userMapList() { return "GetUserMapApiMaimaiChn"; }
    }

    public static class Key {
        public static String AES(){
            return "n7bx6:@Fg_:2;5E89Phy7AyIcpxEQ:R@";
        }
        public static String IV(){
            return ";;KjR1C3hgB1ovXa";
        }
        public static String obfuscate(){return "BEs2D5vW";}
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
