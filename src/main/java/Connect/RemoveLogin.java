package Connect;

import java.util.concurrent.Callable;
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
        int track = 0, order = 0;

        while (ReturnCode.isLogin(SendReq.Ratting(Userid)).equals("1")) {
            SendReq.Logout(Userid, datetime);
            System.out.println(datetime);
            datetime++;

            if (datetime - res == 60) {
                res = datetime;
                track++;

                if (track == 30) {
                    datetime -= 3600;
                    order++;
                    if (order == 2) {
                        System.out.println("失败");
                        return 0L;
                    }
                    System.out.println("正推失败，尝试反推");
                }
            }
        }
        return datetime - 1;
    }

}
