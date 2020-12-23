package cn.ld.peach.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义IMP
 *
 * @author lidong
 * @date 2020/12/23
 */
@Getter
@AllArgsConstructor
public enum IMP {

    /**
     * 系统消息
     */
    SYSTEM("system"),
    /**
     * 登录指令
     */
    LOGIN("login"),
    /**
     * 退出指令
     */
    LOGOUT("logout"),
    /**
     * 聊天消息
     */
    CHAT("chat"),
    /**
     * 礼物消息
     */
    GIFT("gift");

    private static final List<String> IMP_LIST = Arrays.stream(IMP.values())
            .map(IMP::getName).collect(Collectors.toList());

    private final String name;

    /**
     * 判断是否是IMP消息类型
     *
     * @param content 消息
     * @return boolean
     */
    public static boolean isIMP(String content) {
        return IMP_LIST.contains(content);
    }
}
