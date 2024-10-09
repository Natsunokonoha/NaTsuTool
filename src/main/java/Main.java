import Connect.RemoveLogin;
import Connect.SendReq;
import logic.ModifyData;
import logic.ReturnCode;
import logic.UserInputUtils;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        long currentTimestamp = System.currentTimeMillis() / 1000;
        String Userid = UserInputUtils.getUserInput(); // 调用UserInputUtils的getUserInput方法用户输入获取 Userid
        String Select = UserInputUtils.Select(); // 从用户输入获取操作选择

        int numberOfThreads = 5; // 设置线程池中的线程数量

        switch (Select) {
            case "1":  // 如果选择1
                String loginResult = SendReq.Login(Userid, currentTimestamp);
                if (loginResult.equals("100") || loginResult.equals("1")) {
                    System.out.println("登录成功！");
                    if (ReturnCode.Return(SendReq.Track(Userid,Integer.parseInt(ReturnCode.GetRatting(SendReq.Ratting(Userid))))).equals("1")){
                        System.out.println("获取成功！");
                    } else {
                        System.out.println("获取失败，或者已有卷");
                    }
                if (ReturnCode.Return(SendReq.Logout(Userid,currentTimestamp)).equals("1")){
                    if (ReturnCode.isLogin(SendReq.Ratting(Userid)).equals("0")){    //检查是否退出登录
                        System.out.println("退出登录");
                    } else {
                        System.out.println("未成功退出登录");
                    }
                }
                }else if (loginResult.equals("102")) {
                    System.out.println("请刷新二维码");
                } else {
                    System.out.println("登录失败");
                }
                break;
            case "2":
                long datetime = UserInputUtils.TimeToTimestamp();
                ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
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
                System.out.println(ModifyData.menu(Userid,currentTimestamp));
                break;
            default:
                System.out.println("乱输是吧？奖励你关一把小黑屋");
                SendReq.Login(Userid, currentTimestamp);
                System.out.println(currentTimestamp);
                break;
        }
    }
}
