package logic;

import Connect.RequestBodyBuilder;

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
