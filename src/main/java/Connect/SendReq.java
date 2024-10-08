package Connect;

import Config.Setting;

public class SendReq {
    static long currentTimestamp = System.currentTimeMillis() / 1000;
    public static String Login(String Userid){
        return Dispose.build(Userid, Setting.Api.Login(), RequestBodyBuilder.login(Userid, currentTimestamp));
    }
}
