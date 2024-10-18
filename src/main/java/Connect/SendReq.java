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
        String[] userMapAll = new String[4];
        userMapAll[0] = Dispose.build(Userid, Dispose.obfuscate(Setting.Api.userMapList()), RequestBodyBuilder.userMapList(Userid, "0"));
        userMapAll[1] = Dispose.build(Userid, Dispose.obfuscate(Setting.Api.userMapList()), RequestBodyBuilder.userMapList(Userid, "100005"));
        userMapAll[2] = Dispose.build(Userid, Dispose.obfuscate(Setting.Api.userMapList()), RequestBodyBuilder.userMapList(Userid, "200054"));
        userMapAll[3] = Dispose.build(Userid, Dispose.obfuscate(Setting.Api.userMapList()), RequestBodyBuilder.userMapList(Userid, "300058"));
        return userMapAll[0]+","+userMapAll[1]+","+userMapAll[2]+","+userMapAll[3];
    }
    public static String userRatting(String Userid){
        return Dispose.build(Userid, Dispose.obfuscate(Setting.Api.userRatting()),RequestBodyBuilder.userRatting(Userid));
    }
    public static String userChargeList(String Userid){
        return Dispose.build(Userid, Dispose.obfuscate(Setting.Api.userChargeListforTrack()), RequestBodyBuilder.userCharacterList(Userid));
    }
}
