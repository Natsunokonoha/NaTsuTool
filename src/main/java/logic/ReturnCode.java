package logic;

import org.json.JSONException;
import org.json.JSONObject;

public class ReturnCode {
    public static String Return(String decryptedString) {
        // 解析JSON数据
        JSONObject jsonObject = new JSONObject(decryptedString);
        return String.valueOf(jsonObject.getInt("returnCode"));

    }

    public static String GetRatting(String decryptedString) {
        // 解析JSON数据
        JSONObject jsonObject = new JSONObject(decryptedString);
        Object ratting = jsonObject.get("playerRating");

        // 检查类型并进行转换
        if (ratting instanceof Integer) {
            return String.valueOf(ratting);  // 如果是整数，将其转换为字符串
        } else if (ratting instanceof String) {
            return (String) ratting;  // 如果已经是字符串，直接返回
        } else {
            throw new JSONException("playerRating的意外类型");
        }
    }

    public static String isLogin(String decryptedString) {
        JSONObject jsonObject = new JSONObject(decryptedString);
        Object isLogin = jsonObject.get("isLogin");
        int returnCode;
        if (isLogin instanceof Boolean) {
            returnCode = (Boolean) isLogin ? 1 : 0; // 将 true 转换为 1，false 转换为 0
        } else {
            returnCode = jsonObject.getInt("isLogin"); // 如果不是布尔类型，直接尝试获取整数
        }
        System.out.println(returnCode);
        return String.valueOf(returnCode);
    }
    public static String playlogId(String decryptedString) {
        JSONObject jsonObject = new JSONObject(decryptedString);
        return String.valueOf(jsonObject.getInt("playlogId"));
    }
}
