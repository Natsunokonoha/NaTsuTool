package logic;

import Connect.SendReq;

public class BuildUserAll {
    public static String Basic(String userid ,Long currentTimestamp){
        return ReturnCode.playlogId(SendReq.Login(userid,currentTimestamp));
    }
    public static String userData(String Userid,Long dateTime){
        return Json.toUserData(SendReq.userData(Userid),dateTime);
    }
}
