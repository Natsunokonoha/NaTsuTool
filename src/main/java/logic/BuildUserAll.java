package logic;

import Connect.SendReq;

public class BuildUserAll {
    public static String Basic(String userid ,Long currentTimestamp){
        String codeId = Json.tologinIn(SendReq.Login(userid, currentTimestamp));
        if (!codeId.equals("1")) {
            switch (codeId) {
                case "102":
                    System.out.println("登陆状态异常！可能是没有刷新二维码");
                    System.exit(0);
                case "103":
                    System.out.println("登陆状态异常！可能是错误的userID");
                    System.exit(0);
                case "null":
                    System.out.println("未知错误！");
                    System.exit(0);
            }

        }
        return codeId;
    }

    public static String userData(String Userid,Long dateTime){
        return Json.toUserData(SendReq.userData(Userid),dateTime);
    }

    public static String userExtend(String Userid){
        return Json.touserExtend(SendReq.userExtend(Userid));
    }

    public static String userOption(String Userid){
        return Json.touserOption(SendReq.userOption(Userid));
    }
    public static String userMapList(String Userid){
        return Json.touserMapList(SendReq.userMapList(Userid));
    }
}
