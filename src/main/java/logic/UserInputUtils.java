package logic;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class UserInputUtils {

    public static String getUserInput() {
//        System.out.println(System.currentTimeMillis());
        System.out.print("请输入 userId：");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
    public static String Select() {
        System.out.println("扣1发卷扣2解小黑屋");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
    public static long TimeToTimestamp(){
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();
        Scanner scanner = new Scanner(System.in);

        System.out.print("是否知道机台DataTime？（1/0）");
        int is = scanner.nextInt();
        if(is == 1){
            System.out.println("输入机台DataTime（一次只推±30分钟）：");
            return scanner.nextInt();
        }
        else{
            // 获取用户输入的时和分
            System.out.print("请输入小时(0-23): ");
            int hour = scanner.nextInt();
            System.out.print("请输入分钟(0-59): ");
            int minute = scanner.nextInt();

            // 将年月日和用户输入的时分合并成LocalDateTime对象
            LocalDateTime dateTime = currentDate.atTime(hour, minute);

            // 将LocalDateTime对象转换为时间戳
            return dateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
        }
    }
}
