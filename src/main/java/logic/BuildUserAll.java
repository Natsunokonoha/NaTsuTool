package logic;

import Connect.SendReq;

public class BuildUserAll {
    public static String Basic(String userid ,Long currentTimestamp){
        String codeId = ReturnCode.playlogId(SendReq.Login(userid, currentTimestamp));
        System.out.println(codeId);
        if (!codeId.equals("1")){
            if (codeId.equals("100")){
                System.out.println("你处于登陆状态！请未登录的时候重试！");
            }else if (codeId.equals("102")) {
                System.out.println("请刷新二维码");
            } else {
                System.out.println("未知错误！");
            }
            System.exit(0);
        }
        return codeId;
    }
    public static String userData(String Userid,Long dateTime){
        return Json.toUserData(SendReq.userData(Userid),dateTime);
    }
}
