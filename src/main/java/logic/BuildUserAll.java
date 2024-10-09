package logic;

import Config.Setting;
import Connect.Dispose;
import Connect.RequestBodyBuilder;

public class BuildUserAll {
    public static String Basic(String Userid ,Long currentTimestamp){
        return ReturnCode.playlogId(Dispose.build(Userid, Setting.Api.Login(), RequestBodyBuilder.login(Userid, currentTimestamp)));
    }
    public static String userData(String Userid){
        return Json.toUserData(Dispose.build(Userid, Setting.Api.userData(), RequestBodyBuilder.userData(Userid)));
    }
}
