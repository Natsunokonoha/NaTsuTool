package logic;

import Config.Setting;
import Connect.Dispose;
import Connect.RequestBodyBuilder;

public class GetUserAll {
    public static String Basic(String Userid ,Long currentTimestamp){
        return ReturnCode.playlogId(Dispose.build(Userid, Setting.Api.Login(), RequestBodyBuilder.login(Userid, currentTimestamp)));
    }
    public static String UserAll(String Userid ,Long currentTimestamp){
        return String.format("{\"userId\":%s}", Basic(Userid, currentTimestamp));
    }
}
