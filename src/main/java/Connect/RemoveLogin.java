package Connect;

import java.util.concurrent.Callable;
import Config.Setting;

public class RemoveLogin implements Callable<Long> {

    private final String userId;
    private long datetime;

    public RemoveLogin(String userId, long datetime) {
        this.userId = userId;
        this.datetime = datetime;
    }



    @Override
    public Long call() {
        long res = datetime;
        int track = 0;
        while (Dispose.build(userId, Setting.Api.ratting(), RequestBodyBuilder.ratting(userId), "2").equals("1")){
            Dispose.build(userId, Setting.Api.logout(), RequestBodyBuilder.logout(userId, datetime), "1");
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
