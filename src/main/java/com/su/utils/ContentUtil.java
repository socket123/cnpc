package com.su.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/6/10.
 */
public class ContentUtil {

    private static String PATTERN = "\\@[^\\@^\\s]*(\\s|[^\\@])";
    @SuppressWarnings("serial")
	private static Map<String, String> emotions = new HashMap<String, String>() {
        {
        	put("[抱抱]","face_1 face_a icon_00");
        	put("[蹭蹭]","face_1 face_a icon_11");
        	put("[吃饭]","face_1 face_a icon_22");
        	put("[大哭]","face_1 face_a icon_33");
        	put("[哼]","face_1 face_a icon_44");
        	put("[加油]","face_1 face_a icon_55");
        	put("[抠鼻子]","face_1 face_a icon_66");
        	put("[雷劈]","face_1 face_a icon_77");
        	put("[么么]","face_2 face_a icon_00");
        	put("[数钱]","face_2 face_a icon_11");
        	put("[睡觉]","face_2 face_a icon_22");
        	put("[无聊]","face_2 face_a icon_33");
        	put("[谢谢老板]","face_2 face_a icon_44");
        	put("[再会]","face_2 face_a icon_55");
        	put("[抓狂了]","face_2 face_a icon_66");
        	put("[自拍]","face_2 face_a icon_77");
        	put("[微笑]","face_3 face icon_0");
        	put("[色]","face_3 face icon_1");
        	put("[得意]","face_3 face icon_2");
        	put("[流泪]","face_3 face icon_3");
        	put("[害羞]","face_3 face icon_4");
        	put("[闭嘴]","face_3 face icon_5");
        	put("[睡]","face_3 face icon_6");
        	put("[尴尬]","face_3 face icon_7");
        	put("[发怒]","face_3 face icon_8");
        	put("[调皮]","face_3 face icon_9");
        	put("[龇牙]","face_3 face icon_10");
        	put("[惊讶]","face_3 face icon_11");
        	put("[抓狂]","face_3 face icon_12");
        	put("[偷笑]","face_3 face icon_13");
        	put("[白眼]","face_3 face icon_14");
        	put("[左哼哼]","face_3 face icon_15");
        	put("[流汗]","face_3 face icon_16");
        	put("[疑问]","face_3 face icon_17");
        	put("[不高兴]","face_3 face icon_18");
        	put("[晕]","face_3 face icon_19");
        	put("[疯了]","face_3 face icon_20");
        	put("[敲打]","face_3 face icon_21");
        	put("[衰]","face_3 face icon_22");
        	put("[再见]","face_3 face icon_23");
        	put("[抠鼻]","face_3 face icon_24");
        	put("[鼓掌]","face_3 face icon_25");
        	put("[右哼哼]","face_3 face icon_26");
        	put("[鄙视]","face_3 face icon_27");              
        	put("[委屈]","face_4 face icon_0");
        	put("[阴险]","face_4 face icon_1");
        	put("[亲亲]","face_4 face icon_2");
        	put("[可怜]","face_4 face icon_3");
        }
    };

    public static String parserEmotion(String share) {
        if (StringUtil.isNotEmpty(share)) {
            Pattern r = Pattern.compile("\\[[^\\[^\\]]*\\]");
            Matcher m = r.matcher(share);
            while (m.find()) {
                String emotion = m.group(0);
                if (emotions.containsKey(emotion)) {
                    share = share.replace(emotion, "<i class=\"" + emotions.get(emotion) + "\" />");
                }
            }
        }
        return share;
    }

    public static String parserAt(String share) {
        StringBuilder sb = new StringBuilder();
        if (StringUtil.isNotEmpty(share)) {
            share += " ";
            Pattern r = Pattern.compile(PATTERN);
            Matcher m = r.matcher(share);
            List<String> list = new ArrayList<String>();
            while (m.find()) {
                String friend = m.group(0);
                list.add(friend);
                int index = share.indexOf(friend);
                //String name = friend.trim().substring(1);
                // try {
                // name = URLEncoder.encode(name, "UTF-8");
                // } catch (UnsupportedEncodingException e) {
                // e.printStackTrace();
                // }
                sb.append(share.substring(0, index)).append("<a class=\"goUserInfo\" href=\"javascript:void(0);\">")
                        .append(friend.trim()).append("</a> ");
                share = share.substring(index + friend.length());
            }
            sb.append(share);
        }
        return sb.toString();
    }

    public static List<String> getAtUsers(String share) {
        share += " ";
        Pattern r = Pattern.compile(PATTERN);
        Matcher m = r.matcher(share);
        List<String> list = new ArrayList<String>();
        while (m.find()) {
            String friend = m.group(0);
            list.add(friend.trim().substring(1));
        }
        return list;
    }

    public static String parserContent(String content) {
        // 表情
        content = parserEmotion(content);
        // @的好友
        content = parserAt(content);
        return content;
    }

    public static void main(String[] args) {
        System.out.println(parserEmotion("相信[心][心[阴险]][猪头]"));
        String content = "test@hy3112 @d@yy d @d@ayd";
        content += " ";
        Pattern r = Pattern.compile("\\@[^\\@^\\s]*(\\s|[^\\@])");
        Matcher m = r.matcher(content);
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            String friend = m.group(0);
            System.out.println(friend);
            list.add(friend);
            int index = content.indexOf(friend);
            sb.append(content.substring(0, index)).append("<a href=\"ShareNew/n/").append(friend.trim().substring(1))
                    .append(".do\">").append(friend.trim()).append("</a>");
            content = content.substring(index + friend.length());
        }
        System.out.println(sb.toString());

        System.out.println(parserAt("test@hy3112 @d@yy d @d@ayd"));
        System.out.println(parserAt("@用户2 @用户3 [→_→][呵呵]测试测试"));
    }
}
