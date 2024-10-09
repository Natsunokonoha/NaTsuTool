package logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class Json {
    public static String toUserData(String jsonString) {
        try {
            // 调用处理方法
            return processJson(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 处理 JSON 数据并保持顺序的方法
    public static String processJson(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // 将 JSON 字符串转换为 Jackson 的 ObjectNode
        ObjectNode jsonObject = (ObjectNode) mapper.readTree(jsonString);

        // 删除 userId 字段
        jsonObject.remove("userId");

        // 处理 userData 部分
        if (jsonObject.has("userData")) {
            ObjectNode userData = (ObjectNode) jsonObject.get("userData");

            // 遍历并处理 userData 中的键值对
            userData.fieldNames().forEachRemaining(key -> {
                if (userData.get(key).isNull()) {
                    // 替换 null 值为空字符串
                    userData.put(key, "");
                }
            });
        }
        return mapper.writeValueAsString(jsonObject);
    }
}
