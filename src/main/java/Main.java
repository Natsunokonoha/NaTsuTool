import Config.Setting;
import Connect.RemoveLogin;
import Connect.SendReq;
import logic.Json;
import logic.ModifyData;
import logic.UserInputUtils;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        long currentTimestamp = System.currentTimeMillis() / 1000;
        System.out.println("当前时间戳："+currentTimestamp);
        String Userid = UserInputUtils.getUserInput(); // 调用UserInputUtils的getUserInput方法用户输入获取 Userid
        String Select = UserInputUtils.Select(); // 从用户输入获取操作选择

        switch (Select) {
            case "1":  // 如果选择1
                String loginResult = Json.tologinIn(SendReq.Login(Userid, currentTimestamp));
                System.out.println(loginResult);
                if (loginResult.matches("\\d+") && loginResult.length() > 10) {
                    System.out.println("登录成功！");
                    if (Json.Return(SendReq.Track(Userid, Json.GetRatting(SendReq.Ratting(Userid)))).equals("1")){
                        System.out.println("获取成功！");
                    } else {
                        System.out.println("获取失败，或者已有卷");
                    }
                if (Json.Return(SendReq.Logout(Userid,currentTimestamp)).equals("1")){
                    if (Json.isLogin(SendReq.Ratting(Userid)).equals("0")){    //检查是否退出登录
                        System.out.println("退出登录");
                    } else {
                        System.out.println("未成功退出登录");
                    }
                }
                }else if (loginResult.equals("100")){
                    System.out.println("警告，你已经登陆现在尝试直接获取");
                    if (Json.Return(SendReq.Track(Userid, Json.GetRatting(SendReq.Ratting(Userid)))).equals("1")){
                        System.out.println("获取成功！");
                    } else {
                        System.out.println("获取失败，或者已有卷");
                    }
                }
                break;
            case "2":
                long datetime = UserInputUtils.TimeToTimestamp();
                ExecutorService executor = Executors.newFixedThreadPool(Setting.Others.Thread());
                RemoveLogin removeLogin = new RemoveLogin(Userid, datetime);
                Future<Long> future = executor.submit(removeLogin);
                try {
                    // 获取并打印结果
                    Long result = future.get();
                    System.out.println("机台DataTime: " + result);
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("获取机台DataTime失败QAQ");
                } finally {
                    // 关闭 ExecutorService
                    executor.shutdown();
                }
                break;
            case "3":
                try {
                    System.out.println(ModifyData.menu(Userid,currentTimestamp));
                    loginOut(currentTimestamp, Userid);
                }catch (Exception e){
                    System.out.println("发生错误！");
                    loginOut(currentTimestamp, Userid);
                }
                break;
            default:
                System.out.println("乱输是吧？奖励你关一把小黑屋");
                SendReq.Login(Userid, currentTimestamp);
                System.out.println(currentTimestamp);
                break;
        }
    }

    private static void loginOut(long currentTimestamp, String userid) {
        SendReq.Logout(userid, currentTimestamp);
        if (Json.Return(SendReq.Logout(userid,currentTimestamp)).equals("1")){
            if (Json.isLogin(SendReq.Ratting(userid)).equals("0")){    //检查是否退出登录
                System.out.println("退出登录");
            } else {
                System.out.println("未成功退出登录");
            }
        }
    }
}
