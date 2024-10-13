package logic;

import Connect.SendReq;

public class BuildUserAll {
    public static String Basic(String userid ,Long currentTimestamp){
        String codeId = Json.tologinIn(SendReq.Login(userid, currentTimestamp));
        if (!codeId.equals("1")) {
            switch (codeId) {
                case "102":
                    System.out.println("登陆状态异常！可能是没有刷新二维码");
                    if (ReturnCode.Return(SendReq.Logout(userid,currentTimestamp)).equals("1")){
                        if (ReturnCode.isLogin(SendReq.Ratting(userid)).equals("0")){    //检查是否退出登录
                            System.out.println("退出登录");
                        } else {
                            System.out.println("未成功退出登录");
                        }
                    }
                    break;
                case "103":
                    System.out.println("登陆状态异常！可能是错误的userID");
                    break;
                default:
                    System.out.println("未知错误！");
            }
            System.exit(0);
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
