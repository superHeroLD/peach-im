package cn.ld.peach.protocol;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.msgpack.annotation.Message;

/**
 * IM自定义消息实体类
 *
 * @author lidong
 * @date 2020/12/23
 */
@Message
@Data
@NoArgsConstructor
public class IMMessage {

    /**
     * ip地址和端口
     */
    private String addr;
    /**
     * 消息类型
     */
    private String cmd;
    /**
     * 消息发送时间
     */
    private long time;
    /**
     * 当前在线人数
     */
    private int online;
    /**
     * 发送人
     */
    private String sender;
    /**
     * 接收人
     */
    private String receiver;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 终端
     */
    private String terminal;
}
