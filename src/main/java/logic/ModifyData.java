package logic;

import Connect.SendReq;

public class ModifyData {
    public static String menu(String userId, Long currentTimestamp) {
        BuildUserAll.userData(userId, currentTimestamp);
        return SendReq.Logout(userId, currentTimestamp);
    }
//        String Select = UserInputUtils.GetUserInputForUserAll();
//        switch (Select) {
//            case "1":
//
//                break;
//        }
//    }
}
