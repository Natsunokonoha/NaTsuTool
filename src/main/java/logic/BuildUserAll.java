package logic;

import Connect.SendReq;

public class BuildUserAll {
    public static String Basic(String Userid ,Long currentTimestamp){
        return ReturnCode.playlogId(SendReq.Login(Userid,currentTimestamp));
    }
    public static String userData(String Userid){
        return Json.toUserData(SendReq.userData(Userid));
    }
}
