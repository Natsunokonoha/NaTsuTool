package Connect;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import Config.Setting;

public class RequestBodyBuilder {

    public static String login(String userId, long currentTimestamp) {
        return String.format("{\"userId\":%s,\"accessCode\":\"\",\"regionId\":2,\"placeId\":2067,\"clientId\":\"%s\",\"dateTime\":%d,\"isContinue\":true,\"genericFlag\":0}", userId, Setting.clientId(), currentTimestamp);
    }

    public static String ratting(String userId) {
        return String.format("{\"userId\":%s,\"segaIdAuthKey\":\"\"}",userId);
    }

    public static String juan(String userId, int playerRating) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");

        String purchaseDate = currentTime.format(formatter);
        String validDate = currentTime.plusDays(90).format(formatter);

        return String.format("{\"userId\":%s,\"userChargelog\":{\"chargeId\":6,\"price\":1,\"purchaseDate\":\"%s\",\"playCount\":1,\"playerRating\":%d,\"placeId\":2067,\"regionId\":2,\"clientId\":\"%s\"},\"userCharge\":{\"chargeId\":6,\"stock\":1,\"purchaseDate\":\"%s\",\"validDate\":\"%s\"}}", userId, purchaseDate, playerRating, Setting.clientId(), validDate, validDate);
    }
    public static String logout(String userId, long currentTimestamp) {
        return String.format("{\"userId\":%s,\"accessCode\":\"\",\"regionId\":2,\"placeId\":2067,\"clientId\":\"%s\",\"dateTime\":%d,\"type\":5}", userId, Setting.clientId() ,currentTimestamp);
    }
}