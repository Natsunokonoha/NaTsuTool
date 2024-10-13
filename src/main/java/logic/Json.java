package logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Json {

    private static boolean containsOnlyZeros(ArrayNode arrayNode) {
        for (JsonNode element : arrayNode) {
            if (!element.isInt() || element.intValue() != 0) {
                return false;
            }
        }
        return true;
    }

    // 辅助方法：将 null 值替换为空字符串，递归处理嵌套的对象或数组
    private static JsonNode replaceNullWithEmpty(JsonNode node) {
        if (node == null || node.isNull()) {
            return TextNode.valueOf(""); // 将 null 替换为 ""
        }
        if (node.isArray()) {
            ArrayNode arrayNode = (ArrayNode) node;

            // 检查是否是 [0, 0, 0, 0, 0]，如果是，则替换为 []
            if (arrayNode.size() == 5 && containsOnlyZeros(arrayNode)) {
                arrayNode.removeAll(); // 清空数组
            }
        }
        return node; // 如果不是 null，返回原值
    }

    public static String toUserData(String jsonString, Long dateTime) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            // 将 JSON 字符串转换为 Jackson 的 ObjectNode
            ObjectNode jsonObject = (ObjectNode) mapper.readTree(jsonString);

            // 创建一个新的有序 Map 来保存字段的顺序
            Map<String, JsonNode> orderedFields = new LinkedHashMap<>();

            // 按你希望的顺序定义字段
            if (jsonObject.has("userData")) {
                ObjectNode userData = (ObjectNode) jsonObject.get("userData");

                // 删除不需要的字段
                userData.remove("friendCode");
                userData.remove("nameplateId");
                userData.remove("trophyId");
                userData.remove("cmLastEmoneyCredit");
                userData.remove("cmLastEmoneyBrand");

                // 例如，先处理某些特定字段，再处理其他字段
                orderedFields.put("accessCode", replaceNullWithEmpty(userData.get("accessCode")));
                orderedFields.put("userName", replaceNullWithEmpty(userData.get("userName")));
                orderedFields.put("isNetMember", replaceNullWithEmpty(userData.get("isNetMember")));
                orderedFields.put("iconId", replaceNullWithEmpty(userData.get("iconId")));
                orderedFields.put("plateId", replaceNullWithEmpty(userData.get("plateId")));
                orderedFields.put("titleId", replaceNullWithEmpty(userData.get("titleId")));
                orderedFields.put("partnerId", replaceNullWithEmpty(userData.get("partnerId")));
                orderedFields.put("frameId", replaceNullWithEmpty(userData.get("frameId")));
                orderedFields.put("selectMapId", replaceNullWithEmpty(userData.get("selectMapId")));
                orderedFields.put("totalAwake", replaceNullWithEmpty(userData.get("totalAwake")));
                orderedFields.put("gradeRating", replaceNullWithEmpty(userData.get("gradeRating")));
                orderedFields.put("musicRating", replaceNullWithEmpty(userData.get("musicRating")));
                orderedFields.put("playerRating", replaceNullWithEmpty(userData.get("playerRating")));
                orderedFields.put("highestRating", replaceNullWithEmpty(userData.get("highestRating")));
                orderedFields.put("gradeRank", replaceNullWithEmpty(userData.get("gradeRank")));
                orderedFields.put("classRank", replaceNullWithEmpty(userData.get("classRank")));
                orderedFields.put("courseRank", replaceNullWithEmpty(userData.get("courseRank")));
                orderedFields.put("charaSlot", replaceNullWithEmpty(userData.get("charaSlot")));
                orderedFields.put("charaLockSlot", replaceNullWithEmpty(userData.get("charaLockSlot")));
                orderedFields.put("contentBit", replaceNullWithEmpty(userData.get("contentBit")));
                orderedFields.put("playCount", replaceNullWithEmpty(userData.get("playCount")));
                orderedFields.put("currentPlayCount", replaceNullWithEmpty(userData.get("currentPlayCount")));
                orderedFields.put("renameCredit", replaceNullWithEmpty(userData.get("renameCredit")));
                orderedFields.put("mapStock", replaceNullWithEmpty(userData.get("mapStock")));
                orderedFields.put("eventWatchedDate", replaceNullWithEmpty(userData.get("eventWatchedDate")));
                orderedFields.put("lastGameId", replaceNullWithEmpty(userData.get("lastGameId")));
                orderedFields.put("lastRomVersion", replaceNullWithEmpty(userData.get("lastRomVersion")));
                orderedFields.put("lastDataVersion", replaceNullWithEmpty(userData.get("lastDataVersion")));
                orderedFields.put("lastLoginDate", replaceNullWithEmpty(userData.get("lastLoginDate")));
                orderedFields.put("lastPlayDate", replaceNullWithEmpty(userData.get("lastPlayDate")));
                orderedFields.put("lastPlayCredit", replaceNullWithEmpty(userData.get("lastPlayCredit")));
                orderedFields.put("lastPlayMode", replaceNullWithEmpty(userData.get("lastPlayMode")));
                orderedFields.put("lastPlaceId", replaceNullWithEmpty(userData.get("lastPlaceId")));
                orderedFields.put("lastPlaceName", replaceNullWithEmpty(userData.get("lastPlaceName")));
                orderedFields.put("lastAllNetId", replaceNullWithEmpty(userData.get("lastAllNetId")));
                orderedFields.put("lastRegionId",replaceNullWithEmpty(userData.get("lastRegionId")));
                orderedFields.put("lastRegionName", replaceNullWithEmpty(userData.get("lastRegionName")));
                orderedFields.put("lastClientId", replaceNullWithEmpty(userData.get("lastPlaceName")));
                orderedFields.put("lastCountryCode", replaceNullWithEmpty(userData.get("lastCountryCode")));
                orderedFields.put("lastSelectEMoney", replaceNullWithEmpty(userData.get("lastSelectEMoney")));
                orderedFields.put("lastSelectTicket", replaceNullWithEmpty(userData.get("lastSelectTicket")));
                orderedFields.put("lastSelectCourse", replaceNullWithEmpty(userData.get("lastSelectCourse")));
                orderedFields.put("lastCountCourse", replaceNullWithEmpty(userData.get("lastCountCourse")));
                orderedFields.put("firstGameId", replaceNullWithEmpty(userData.get("firstGameId")));
                orderedFields.put("firstRomVersion", replaceNullWithEmpty(userData.get("firstRomVersion")));
                orderedFields.put("firstDataVersion", replaceNullWithEmpty(userData.get("firstDataVersion")));
                orderedFields.put("firstPlayDate", replaceNullWithEmpty(userData.get("firstPlayDate")));
                orderedFields.put("compatibleCmVersion", replaceNullWithEmpty(userData.get("compatibleCmVersion")));
                orderedFields.put("dailyBonusDate", replaceNullWithEmpty(userData.get("dailyBonusDate")));
                orderedFields.put("dailyCourseBonusDate", replaceNullWithEmpty(userData.get("dailyCourseBonusDate")));
                orderedFields.put("lastPairLoginDate", replaceNullWithEmpty(userData.get("lastPairLoginDate")));
                orderedFields.put("lastTrialPlayDate", replaceNullWithEmpty(userData.get("lastTrialPlayDate")));
                orderedFields.put("playVsCount", replaceNullWithEmpty(userData.get("playVsCount")));
                orderedFields.put("playSyncCount", replaceNullWithEmpty(userData.get("playSyncCount")));
                orderedFields.put("winCount", replaceNullWithEmpty(userData.get("winCount")));
                orderedFields.put("helpCount", replaceNullWithEmpty(userData.get("helpCount")));
                orderedFields.put("comboCount", replaceNullWithEmpty(userData.get("comboCount")));
                orderedFields.put("totalDeluxscore", replaceNullWithEmpty(userData.get("totalDeluxscore")));
                orderedFields.put("totalBasicDeluxscore", replaceNullWithEmpty(userData.get("totalBasicDeluxscore")));
                orderedFields.put("totalAdvancedDeluxscore", replaceNullWithEmpty(userData.get("totalAdvancedDeluxscore")));
                orderedFields.put("totalExpertDeluxscore", replaceNullWithEmpty(userData.get("totalExpertDeluxscore")));
                orderedFields.put("totalMasterDeluxscore", replaceNullWithEmpty(userData.get("totalMasterDeluxscore")));
                orderedFields.put("totalReMasterDeluxscore", replaceNullWithEmpty(userData.get("totalReMasterDeluxscore")));
                orderedFields.put("totalSync", replaceNullWithEmpty(userData.get("totalSync")));
                orderedFields.put("totalBasicSync", replaceNullWithEmpty(userData.get("totalBasicSync")));
                orderedFields.put("totalAdvancedSync", replaceNullWithEmpty(userData.get("totalAdvancedSync")));
                orderedFields.put("totalExpertSync", replaceNullWithEmpty(userData.get("totalExpertSync")));
                orderedFields.put("totalMasterSync", replaceNullWithEmpty(userData.get("totalMasterSync")));
                orderedFields.put("totalReMasterSync", replaceNullWithEmpty(userData.get("totalReMasterSync")));
                orderedFields.put("totalAchievement", replaceNullWithEmpty(userData.get("totalAchievement")));
                orderedFields.put("totalBasicAchievement", replaceNullWithEmpty(userData.get("totalBasicAchievement")));
                orderedFields.put("totalAdvancedAchievement", replaceNullWithEmpty(userData.get("totalAdvancedAchievement")));
                orderedFields.put("totalExpertAchievement", replaceNullWithEmpty(userData.get("totalExpertAchievement")));
                orderedFields.put("totalMasterAchievement", replaceNullWithEmpty(userData.get("totalMasterAchievement")));
                orderedFields.put("totalReMasterAchievement", replaceNullWithEmpty(userData.get("totalReMasterAchievement")));
                orderedFields.put("playerOldRating", replaceNullWithEmpty(userData.get("playerOldRating")));
                orderedFields.put("playerNewRating", replaceNullWithEmpty(userData.get("playerNewRating")));

                // 处理 datetime 字段
                if (userData.has("dateTime")) {
                    JsonNode dateTimeNode = userData.get("dateTime");
                    if (dateTimeNode.isNull() || dateTimeNode.asText().isEmpty()) {
                        orderedFields.put("dateTime", TextNode.valueOf(String.valueOf(dateTime)));
                    } else {
                        orderedFields.put("dateTime", replaceNullWithEmpty(dateTimeNode));
                    }
                } else {
                    // 如果没有 datetime 字段，添加时间戳
                    orderedFields.put("dateTime", TextNode.valueOf(String.valueOf(dateTime)));
                }
            }

            // 创建一个新的 ObjectNode 按照顺序填充字段
            ObjectNode orderedObjectNode = mapper.createObjectNode();
            orderedFields.forEach(orderedObjectNode::set); // 使用 'set' 方法来避免类型冲突

            // 将处理好的对象转换回 JSON 字符串
            System.out.println(mapper.writeValueAsString(orderedObjectNode));
            return mapper.writeValueAsString(orderedObjectNode);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String touserExtend(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // 将 JSON 字符串转换为 Jackson 的 ObjectNode
            ObjectNode jsonObject = (ObjectNode) mapper.readTree(jsonString);

            Map<String, JsonNode> orderedFields = new LinkedHashMap<>();

            if (jsonObject.has("userExtend")) {
                ObjectNode userData = (ObjectNode) jsonObject.get("userExtend");
                orderedFields.put("selectMusicId", replaceNullWithEmpty(userData.get("selectMusicId")));
                orderedFields.put("selectDifficultyId", replaceNullWithEmpty(userData.get("selectDifficultyId")));
                orderedFields.put("categoryIndex", replaceNullWithEmpty(userData.get("categoryIndex")));
                orderedFields.put("musicIndex", replaceNullWithEmpty(userData.get("musicIndex")));
                orderedFields.put("extraFlag", replaceNullWithEmpty(userData.get("")));
                orderedFields.put("selectScoreType", replaceNullWithEmpty(userData.get("selectScoreType")));
                orderedFields.put("extendContentBit", replaceNullWithEmpty(userData.get("extendContentBit")));
                orderedFields.put("isPhotoAgree", replaceNullWithEmpty(userData.get("isPhotoAgree")));
                orderedFields.put("isGotoCodeRead", replaceNullWithEmpty(userData.get("isGotoCodeRead")));
                orderedFields.put("selectResultDetails", replaceNullWithEmpty(userData.get("selectResultDetails")));
                orderedFields.put("selectResultScoreViewType", replaceNullWithEmpty(userData.get("selectResultScoreViewType")));
                orderedFields.put("sortCategorySetting", replaceNullWithEmpty(userData.get("sortCategorySetting")));
                orderedFields.put("sortMusicSetting", replaceNullWithEmpty(userData.get("sortMusicSetting")));
                orderedFields.put("playStatusSetting", replaceNullWithEmpty(userData.get("playStatusSetting")));
                orderedFields.put("selectedCardList", replaceNullWithEmpty(userData.get("selectedCardList")));
                orderedFields.put("encountMapNpcList", replaceNullWithEmpty(userData.get("encountMapNpcList")));
            }

            // 创建一个新的 ObjectNode 按照顺序填充字段
            ObjectNode orderedObjectNode = mapper.createObjectNode();
            orderedFields.forEach(orderedObjectNode::set); // 使用 'set' 方法来避免类型冲突

            // 将处理好的对象转换回 JSON 字符串
            System.out.println(mapper.writeValueAsString(orderedObjectNode));
            return mapper.writeValueAsString(orderedObjectNode);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String touserOption(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // 将 JSON 字符串转换为 Jackson 的 ObjectNode
            ObjectNode jsonObject = (ObjectNode) mapper.readTree(jsonString);

            // 获取 userOption 节点
            JsonNode userOptionNode = jsonObject.get("userOption");

            // 返回 userOption 节点的字符串
            return userOptionNode.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String touserMapList(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // 将 JSON 字符串转换为 Jackson 的 ObjectNode
            ObjectNode jsonObject = (ObjectNode) mapper.readTree(jsonString);

            // 获取 userOption 节点
            JsonNode userOptionNode = jsonObject.get("userMapList");

            // 返回 userOption 节点的字符串
            return userOptionNode.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String tologinIn(String jsonString) {
        try {
            // 创建 Jackson 的 ObjectMapper 实例
            ObjectMapper objectMapper = new ObjectMapper();

            // 解析 JSON 字符串为 JsonNode
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            // 检查 returnCode 是否存在
            if (jsonNode.has("returnCode")) {
                int returnCode = jsonNode.get("returnCode").asInt();
                // 如果 returnCode 为 1，返回 loginId
                if (returnCode == 1 && jsonNode.has("loginId")) {
                    return jsonNode.get("loginId").asText();
                } else {
                    // returnCode 不为 1 时返回 returnCode 的值
                    return String.valueOf(returnCode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 如果解析过程中出现异常，返回 null
        return null;
    }
}
