package Connect;

import java.util.concurrent.Callable;
import Config.Setting;
import logic.ReturnCode;

public class RemoveLogin implements Callable<Long> {

    private final String Userid;
    private long datetime;

    public RemoveLogin(String Userid, long datetime) {
        this.Userid = Userid;
        this.datetime = datetime;
    }



    @Override
    public Long call() {
        long res = datetime;
        int track = 0;
        while (ReturnCode.isLogin(SendReq.Ratting(Userid)).equals("1")){
            SendReq.Logout(Userid, datetime);
            System.out.println(datetime);
            datetime++;
            if (datetime - res == 60){
                track++;
                res = datetime;
                if (track == 30) {
                    datetime = datetime - 240;
                    res = datetime;
                    System.out.println("正推失败，尝试反推");
                } else if (track == 4) {
                    System.out.println("失败");
                    return 0L;
                }
            }
        }
        return datetime - 1;
    }
}
