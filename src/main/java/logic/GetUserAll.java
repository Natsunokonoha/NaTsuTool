//package logic;
//
//import Config.Setting;
//import Connect.Dispose;
//import Connect.RequestBodyBuilder;
//
//public class GetUserAll {
//    public static String LoginInf(String Userid){
//        long currentTimestamp = System.currentTimeMillis() / 1000;
//        String loginResult = Dispose.build(Userid, Setting.Api.Login(), RequestBodyBuilder.login(Userid, currentTimestamp), "1"); //从Dispose的build方法获取登录状态
//
//        if (loginResult.equals("100") || loginResult.equals("1")) {
//            System.out.println("登录成功！");
//            int Ratting = Integer.parseInt(Dispose.build(Userid, Setting.Api.ratting(), RequestBodyBuilder.ratting(Userid), "1")); //从Dispose的build的方法获取用户RATTING
//            if (Dispose.build(Userid, Setting.Api.juan(), RequestBodyBuilder.juan(Userid, Ratting), "1").equals("1")) {
//                System.out.println("获取成功！");
//            } else {
//                System.out.println("获取失败，或者已有卷");
//            }
//
//            if (Dispose.build(Userid, Setting.Api.logout(), RequestBodyBuilder.logout(Userid, currentTimestamp), "1").equals("1")) { //退出登录
//                if (Dispose.build(Userid, Setting.Api.ratting(), RequestBodyBuilder.ratting(Userid), "2").equals("0")) { //检查是否退出登录
//                    System.out.println("退出登录");
//                } else {
//                    System.out.println("未成功退出登录");
//                }
//            }
//        } else if (loginResult.equals("102")) {
//            System.out.println("请刷新二维码");
//        } else {
//            System.out.println("登录失败");
//        }
//    }
//}
