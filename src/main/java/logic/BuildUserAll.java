package logic;

import Connect.SendReq;

public class BuildUserAll {
    public static String Basic(String userid, Long currentTimestamp) {
        String codeId = Json.tologinIn(SendReq.Login(userid, currentTimestamp));

        // 检查是否是 loginId 或 returnCode
        if (codeId != null && codeId.matches("\\d+") && codeId.length() > 10) {
            System.out.println("Login successful, loginId: " + codeId);
        } else {
            // 处理 returnCode 情况
            if (!codeId.equals("1")) {
                switch (codeId) {
                    case "null":
                    case "100":
                    case "102":
                        System.out.println("登陆状态异常！可能是没有刷新二维码或者没有正确退出登录");
                        if (Json.Return(SendReq.Logout(userid, currentTimestamp)).equals("1")) {
                            if (Json.isLogin(SendReq.Ratting(userid)).equals("0")) {
                                System.out.println("退出登录");
                            } else {
                                System.out.println("未成功退出登录");
                            }
                        }
                        break;
                    case "103":
                        System.out.println("登陆状态异常！可能是错误的 userID");
                        break;
                    default:
                        System.out.println("未知错误！" + codeId);
                }
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

    public static String userRatting(String Userid){
        return Json.touserRatting(SendReq.userRatting(Userid)); //udemae参数并未排序1111111
    }

    public static String userChargeList(String Userid){
        return Json.touserChargeList(SendReq.userChargeList(Userid));
    }

    public static String userMapList(String Userid){
        return Json.touserMapList(SendReq.userMapList(Userid));
    }
}
