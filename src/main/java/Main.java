import Config.Setting;
import Connect.Dispose;
import Connect.RemoveLogin;
import Connect.RequestBodyBuilder;
import logic.Modify_data;
import logic.UserInputUtils;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        long currentTimestamp = System.currentTimeMillis() / 1000;
        String Userid = UserInputUtils.getUserInput(); // 调用UserInputUtils的getUserInput方法用户输入获取 Userid
        String Select = UserInputUtils.Select(); // 从用户输入获取操作选择

        int numberOfThreads = 5; // 设置线程池中的线程数量

        if (Select.equals("1")) { // 如果选择1

            String loginResult = Dispose.build(Userid, Setting.Api.Login(), RequestBodyBuilder.login(Userid, currentTimestamp), "1"); //从Dispose的build方法获取登录状态
            if (loginResult.equals("100") || loginResult.equals("1")) {
                System.out.println("登录成功！");
                int Ratting = Integer.parseInt(Dispose.build(Userid, Setting.Api.ratting(), RequestBodyBuilder.ratting(Userid), "1")); //从Dispose的build的方法获取用户RATTING
                if (Dispose.build(Userid, Setting.Api.juan(), RequestBodyBuilder.juan(Userid, Ratting), "1").equals("1")) {
                    System.out.println("获取成功！");
                } else {
                    System.out.println("获取失败，或者已有卷");
                }

                if (Dispose.build(Userid, Setting.Api.logout(), RequestBodyBuilder.logout(Userid, currentTimestamp), "1").equals("1")) { //退出登录
                    if (Dispose.build(Userid, Setting.Api.ratting(), RequestBodyBuilder.ratting(Userid), "2").equals("0")) { //检查是否退出登录
                        System.out.println("退出登录");
                    } else {
                        System.out.println("未成功退出登录");
                    }
                }
            } else if (loginResult.equals("102")) {
                System.out.println("请刷新二维码");
            } else {
                System.out.println("登录失败");
            }
        } else if (Select.equals("2")) {
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
        } else if (Select.equals("3")) {
            System.out.println(Modify_data.main(Userid));
        } else {
            System.out.println("乱输是吧？奖励你关一把小黑屋");
            Dispose.build(Userid, Setting.Api.Login(), RequestBodyBuilder.login(Userid, currentTimestamp), "1");
            System.out.println(currentTimestamp);
        }
    }
}
