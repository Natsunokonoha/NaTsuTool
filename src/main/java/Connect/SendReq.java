package Connect;

import Config.Setting;

public class SendReq {
    public static String Login(String Userid, Long currentTimestamp){
        return Dispose.build(Userid, Dispose.obfuscate(Setting.Api.Login()), RequestBodyBuilder.login(Userid, currentTimestamp));
    }
    public static String Ratting(String Userid){
        return Dispose.build(Userid, Dispose.obfuscate(Setting.Api.ratting()), RequestBodyBuilder.ratting(Userid));
    }
    public static String Track(String Userid,int Ratting){
        return Dispose.build(Userid, Dispose.obfuscate(Setting.Api.juan()), RequestBodyBuilder.juan(Userid, Ratting));
    }
    public static String Logout(String Userid, Long currentTimestamp){
        return Dispose.build(Userid, Dispose.obfuscate(Setting.Api.logout()), RequestBodyBuilder.logout(Userid, currentTimestamp));
    }
    public static String userData(String Userid){
        return Dispose.build(Userid, Dispose.obfuscate(Setting.Api.userData()), RequestBodyBuilder.userData(Userid));
    }
    public static String userExtend(String Userid){
        return Dispose.build(Userid, Dispose.obfuscate(Setting.Api.userExtend()), RequestBodyBuilder.userExtend(Userid));
    }
    public static String userOption(String Userid){
        return Dispose.build(Userid, Dispose.obfuscate(Setting.Api.userOption()), RequestBodyBuilder.userOption(Userid));
    }
    public static String userMapList(String Userid){
        return Dispose.build(Userid, Dispose.obfuscate(Setting.Api.userMapList()), RequestBodyBuilder.userMapList(Userid));
    }
}
