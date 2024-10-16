package logic;

import Config.Setting;
import Connect.Dispose;
import Connect.RequestBodyBuilder;
import Connect.RequestHeadersBuilder;

public class ModifyData {
    public static String menu(String userId, Long currentTimestamp) {
        return RequestBodyBuilder.UserAll(userId, currentTimestamp);
    }
//        String Select = UserInputUtils.GetUserInputForUserAll();
//        switch (Select) {
//            case "1":
//
//                break;
//        }
//    }
}
