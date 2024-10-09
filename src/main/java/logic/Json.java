package logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;
import java.time.Instant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Json {
    public static String toUserData(String jsonString, Long dateTime) {
        try {
            // 调用处理方法
            return processJson(jsonString, dateTime);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 处理 JSON 数据并保持顺序的方法
    public static String processJson(String jsonString, Long dateTime) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // 将 JSON 字符串转换为 Jackson 的 ObjectNode
        ObjectNode jsonObject = (ObjectNode) mapper.readTree(jsonString);

        // 删除 userId 字段
        jsonObject.remove("userId");

        // 创建一个新的有序 Map 来保存字段的顺序
        Map<String, JsonNode> orderedFields = new LinkedHashMap<>();

        // 按你希望的顺序定义字段
        if (jsonObject.has("userData")) {
            ObjectNode userData = (ObjectNode) jsonObject.get("userData");

            // 删除字段
            userData.remove("friendCode");
            userData.remove("nameplateId");
            userData.remove("trophyId");
            userData.remove("cmLastEmoneyCredit");
            userData.remove("cmLastEmoneyBrand");

            // 遍历并处理 userData 中的其他键值对，处理未定义的字段，并替换 null 值为空字符串
            Iterator<String> fieldNames = userData.fieldNames();
            while (fieldNames.hasNext()) {
                String key = fieldNames.next();
                if (!orderedFields.containsKey(key)) {
                    JsonNode value = userData.get(key);
                    // 调用 nonNullNode 来处理 null 值
                    orderedFields.put(key, nonNullNode(value));
                }
            }

            // 例如，先处理某些特定字段，再处理其他字段
            orderedFields.put("accessCode", userData.has("accessCode") ? userData.get("accessCode") : mapper.nullNode());
            orderedFields.put("userName", userData.has("userName") ? userData.get("userName") : mapper.nullNode());
            orderedFields.put("isNetMember", userData.has("isNetMember") ? userData.get("isNetMember") : mapper.nullNode());
            orderedFields.put("iconId", userData.has("iconId") ? userData.get("iconId") : mapper.nullNode());
            orderedFields.put("plateId", userData.has("plateId") ? userData.get("plateId") : mapper.nullNode());
            orderedFields.put("titleId", userData.has("titleId") ? userData.get("titleId") : mapper.nullNode());
            orderedFields.put("partnerId", userData.has("partnerId") ? userData.get("partnerId") : mapper.nullNode());
            orderedFields.put("frameId", userData.has("frameId") ? userData.get("frameId") : mapper.nullNode());
            orderedFields.put("selectMapId", userData.has("selectMapId") ? userData.get("selectMapId") : mapper.nullNode());
            orderedFields.put("totalAwake", userData.has("totalAwake") ? userData.get("totalAwake") : mapper.nullNode());
            orderedFields.put("gradeRating", userData.has("gradeRating") ? userData.get("gradeRating") : mapper.nullNode());
            orderedFields.put("musicRating", userData.has("musicRating") ? userData.get("musicRating") : mapper.nullNode());
            orderedFields.put("playerRating", userData.has("playerRating") ? userData.get("playerRating") : mapper.nullNode());
            orderedFields.put("highestRating", userData.has("highestRating") ? userData.get("highestRating") : mapper.nullNode());
            orderedFields.put("gradeRank", userData.has("gradeRank") ? userData.get("gradeRank") : mapper.nullNode());
            orderedFields.put("classRank", userData.has("classRank") ? userData.get("classRank") : mapper.nullNode());
            orderedFields.put("courseRank", userData.has("courseRank") ? userData.get("courseRank") : mapper.nullNode());
            orderedFields.put("charaSlot", userData.has("charaSlot") ? userData.get("charaSlot") : mapper.nullNode());
            orderedFields.put("charaLockSlot", userData.has("charaLockSlot") ? userData.get("charaLockSlot") : mapper.nullNode());
            orderedFields.put("contentBit", userData.has("contentBit") ? userData.get("contentBit") : mapper.nullNode());
            orderedFields.put("playCount", userData.has("playCount") ? userData.get("playCount") : mapper.nullNode());
            orderedFields.put("currentPlayCount", userData.has("currentPlayCount") ? userData.get("currentPlayCount") : mapper.nullNode());
            orderedFields.put("renameCredit", userData.has("renameCredit") ? userData.get("renameCredit") : mapper.nullNode());
            orderedFields.put("mapStock", userData.has("mapStock") ? userData.get("mapStock") : mapper.nullNode());
            orderedFields.put("eventWatchedDate", userData.has("eventWatchedDate") ? userData.get("eventWatchedDate") : mapper.nullNode());
            orderedFields.put("lastGameId", userData.has("lastGameId") ? userData.get("lastGameId") : mapper.nullNode());
            orderedFields.put("lastRomVersion", userData.has("lastRomVersion") ? userData.get("lastRomVersion") : mapper.nullNode());
            orderedFields.put("lastDataVersion", userData.has("lastDataVersion") ? userData.get("lastDataVersion") : mapper.nullNode());
            orderedFields.put("lastLoginDate", userData.has("lastLoginDate") ? userData.get("lastLoginDate") : mapper.nullNode());
            orderedFields.put("lastPlayDate", userData.has("lastPlayDate") ? userData.get("lastPlayDate") : mapper.nullNode());
            orderedFields.put("lastPlayCredit", userData.has("lastPlayCredit") ? userData.get("lastPlayCredit") : mapper.nullNode());
            orderedFields.put("lastPlayMode", userData.has("lastPlayMode") ? userData.get("lastPlayMode") : mapper.nullNode());
            orderedFields.put("lastPlaceId", userData.has("lastPlaceId") ? userData.get("lastPlaceId") : mapper.nullNode());
            orderedFields.put("lastPlaceName", userData.has("lastPlaceName") ? userData.get("lastPlaceName") : mapper.nullNode());
            orderedFields.put("lastAllNetId", userData.has("lastAllNetId") ? userData.get("lastAllNetId") : mapper.nullNode());
            orderedFields.put("lastRegionId", userData.has("lastRegionId") ? userData.get("lastRegionId") : mapper.nullNode());
            orderedFields.put("lastRegionName", userData.has("lastRegionName") ? userData.get("lastRegionName") : mapper.nullNode());
            orderedFields.put("lastClientId", userData.has("lastPlaceName") ? userData.get("lastPlaceName") : mapper.nullNode());
            orderedFields.put("lastCountryCode", userData.has("lastCountryCode") ? userData.get("lastCountryCode") : mapper.nullNode());
            orderedFields.put("lastSelectEMoney", userData.has("lastSelectEMoney") ? userData.get("lastSelectEMoney") : mapper.nullNode());
            orderedFields.put("lastSelectTicket", userData.has("lastSelectTicket") ? userData.get("lastSelectTicket") : mapper.nullNode());
            orderedFields.put("lastSelectCourse", userData.has("lastSelectCourse") ? userData.get("lastSelectCourse") : mapper.nullNode());
            orderedFields.put("lastCountCourse", userData.has("lastCountCourse") ? userData.get("lastCountCourse") : mapper.nullNode());
            orderedFields.put("firstGameId", userData.has("firstGameId") ? userData.get("firstGameId") : mapper.nullNode());
            orderedFields.put("firstRomVersion", userData.has("firstRomVersion") ? userData.get("firstRomVersion") : mapper.nullNode());
            orderedFields.put("firstDataVersion", userData.has("firstDataVersion") ? userData.get("firstDataVersion") : mapper.nullNode());
            orderedFields.put("firstPlayDate", userData.has("firstPlayDate") ? userData.get("firstPlayDate") : mapper.nullNode());
            orderedFields.put("compatibleCmVersion", userData.has("compatibleCmVersion") ? userData.get("compatibleCmVersion") : mapper.nullNode());
            orderedFields.put("dailyBonusDate", userData.has("dailyBonusDate") ? userData.get("dailyBonusDate") : mapper.nullNode());
            orderedFields.put("dailyCourseBonusDate", userData.has("dailyCourseBonusDate") ? userData.get("dailyCourseBonusDate") : mapper.nullNode());
            orderedFields.put("lastPairLoginDate", userData.has("lastPairLoginDate") ? userData.get("lastPairLoginDate") : mapper.nullNode());
            orderedFields.put("lastTrialPlayDate", userData.has("lastTrialPlayDate") ? userData.get("lastTrialPlayDate") : mapper.nullNode());
            orderedFields.put("playVsCount", userData.has("playVsCount") ? userData.get("playVsCount") : mapper.nullNode());
            orderedFields.put("playSyncCount", userData.has("playSyncCount") ? userData.get("playSyncCount") : mapper.nullNode());
            orderedFields.put("winCount", userData.has("winCount") ? userData.get("winCount") : mapper.nullNode());
            orderedFields.put("helpCount", userData.has("helpCount") ? userData.get("helpCount") : mapper.nullNode());
            orderedFields.put("comboCount", userData.has("comboCount") ? userData.get("comboCount") : mapper.nullNode());
            orderedFields.put("totalDeluxscore", userData.has("totalDeluxscore") ? userData.get("totalDeluxscore") : mapper.nullNode());
            orderedFields.put("totalBasicDeluxscore", userData.has("totalBasicDeluxscore") ? userData.get("totalBasicDeluxscore") : mapper.nullNode());
            orderedFields.put("totalAdvancedDeluxscore", userData.has("totalAdvancedDeluxscore") ? userData.get("totalAdvancedDeluxscore") : mapper.nullNode());
            orderedFields.put("totalExpertDeluxscore", userData.has("totalExpertDeluxscore") ? userData.get("totalExpertDeluxscore") : mapper.nullNode());
            orderedFields.put("totalMasterDeluxscore", userData.has("totalMasterDeluxscore") ? userData.get("totalMasterDeluxscore") : mapper.nullNode());
            orderedFields.put("totalReMasterDeluxscore", userData.has("totalReMasterDeluxscore") ? userData.get("totalReMasterDeluxscore") : mapper.nullNode());
            orderedFields.put("totalSync", userData.has("totalSync") ? userData.get("totalSync") : mapper.nullNode());
            orderedFields.put("totalBasicSync", userData.has("totalBasicSync") ? userData.get("totalBasicSync") : mapper.nullNode());
            orderedFields.put("totalAdvancedSync", userData.has("totalAdvancedSync") ? userData.get("totalAdvancedSync") : mapper.nullNode());
            orderedFields.put("totalExpertSync", userData.has("totalExpertSync") ? userData.get("totalExpertSync") : mapper.nullNode());
            orderedFields.put("totalMasterSync", userData.has("totalMasterSync") ? userData.get("totalMasterSync") : mapper.nullNode());
            orderedFields.put("totalReMasterSync", userData.has("totalReMasterSync") ? userData.get("totalReMasterSync") : mapper.nullNode());
            orderedFields.put("totalAchievement", userData.has("totalAchievement") ? userData.get("totalAchievement") : mapper.nullNode());
            orderedFields.put("totalBasicAchievement", userData.has("totalBasicAchievement") ? userData.get("totalBasicAchievement") : mapper.nullNode());
            orderedFields.put("totalAdvancedAchievement", userData.has("totalAdvancedAchievement") ? userData.get("totalAdvancedAchievement") : mapper.nullNode());
            orderedFields.put("totalExpertAchievement", userData.has("totalExpertAchievement") ? userData.get("totalExpertAchievement") : mapper.nullNode());
            orderedFields.put("totalMasterAchievement", userData.has("totalMasterAchievement") ? userData.get("totalMasterAchievement") : mapper.nullNode());
            orderedFields.put("totalReMasterAchievement", userData.has("totalReMasterAchievement") ? userData.get("totalReMasterAchievement") : mapper.nullNode());
            orderedFields.put("playerOldRating", userData.has("playerOldRating") ? userData.get("playerOldRating") : mapper.nullNode());
            orderedFields.put("playerNewRating", userData.has("playerNewRating") ? userData.get("playerNewRating") : mapper.nullNode());

            // 处理 datetime 字段，如果为空则使用当前时间戳
            if (userData.has("datetime")) {
                JsonNode dateTimeNode = userData.get("datetime");
                if (dateTimeNode.isNull() || dateTimeNode.asText().isEmpty()) {
                    // 使用当前时间戳作为默认值
                    long currentTimestamp = Instant.now().getEpochSecond();  // 获取当前的 Unix 时间戳（秒）
                    orderedFields.put("datetime", TextNode.valueOf(String.valueOf(currentTimestamp)));
                } else {
                    orderedFields.put("datetime", nonNullNode(dateTimeNode));
                }
            } else {
                // 如果没有 datetime 字段，添加当前时间戳
                long currentTimestamp = Instant.now().getEpochSecond();
                orderedFields.put("datetime", TextNode.valueOf(String.valueOf(currentTimestamp)));
            }

            // 对其他字段进行处理
            userData.fieldNames().forEachRemaining(key -> {
                if (!orderedFields.containsKey(key)) {
                    JsonNode value = userData.get(key).isNull() ? TextNode.valueOf("") : userData.get(key);
                    orderedFields.put(key, value);
                }
            });
        }

        // 创建一个新的 ObjectNode 按照顺序填充字段
        ObjectNode orderedObjectNode = mapper.createObjectNode();
        orderedFields.forEach(orderedObjectNode::set); // 使用 'set' 方法来避免类型冲突

        // 将处理好的对象转换回 JSON 字符串
        return mapper.writeValueAsString(orderedObjectNode);
    }

    // 辅助方法，将 null 值替换为空字符串
    private static JsonNode nonNullNode(JsonNode node) {
        if (node == null || node.isNull()) {
            return TextNode.valueOf(""); // 如果为 null 或 JSON 中的 null 值，替换为 ""
        }
        if (node.isObject()) {
            // 如果是 ObjectNode，递归处理
            ObjectNode objectNode = (ObjectNode) node;
            objectNode.fields().forEachRemaining(entry -> {
                objectNode.set(entry.getKey(), nonNullNode(entry.getValue())); // 递归处理内部字段
            });
            return objectNode;
        }
        if (node.isArray()) {
            // 如果是数组，遍历数组元素
            ArrayNode arrayNode = (ArrayNode) node;
            for (int i = 0; i < arrayNode.size(); i++) {
                arrayNode.set(i, nonNullNode(arrayNode.get(i))); // 递归处理数组中的每个元素
            }
            return arrayNode;
        }
        return node; // 如果不是 null，返回原值
    }
}
