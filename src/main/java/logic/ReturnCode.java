package logic;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class ReturnCode {
    public static int main(String Api_Url, byte[] decryptedData, String step) {
        String decryptedString = new String(decryptedData, StandardCharsets.UTF_8);
        System.out.println(decryptedString);

        // 解析JSON数据
        JSONObject jsonObject = new JSONObject(decryptedString);
        int returnCode;

        if (!Objects.equals(Api_Url, "7886b5c1307cdaba12a0c5285c0464f0")) {
            // 提取 returnCode
            returnCode = jsonObject.getInt("returnCode");
        } else {
            if (step.equals("1")) {

                returnCode = jsonObject.getInt("playerRating");
            } else {
                // 处理 isLogin 值
                Object isLogin = jsonObject.get("isLogin");
                if (isLogin instanceof Boolean) {
                    returnCode = (Boolean) isLogin ? 1 : 0; // 将 true 转换为 1，false 转换为 0
                } else {
                    returnCode = jsonObject.getInt("isLogin"); // 如果不是布尔类型，直接尝试获取整数
                }
            }
        }
        return returnCode;
    }
}
