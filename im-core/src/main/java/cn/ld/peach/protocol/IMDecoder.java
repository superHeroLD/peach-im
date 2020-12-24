package cn.ld.peach.protocol;

import cn.hutool.core.util.StrUtil;
import cn.ld.peach.constant.IMP;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;
import org.msgpack.MessagePack;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自顶替IMP的编码器
 *
 * @author lidong
 * @date 2020/12/24
 */
@Slf4j
public class IMDecoder extends ByteToMessageDecoder {

    private Pattern pattern = Pattern.compile("^\\[(.*)\\](\\s\\-\\s(.*))?");

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        try {
            final int length = in.readableBytes();
            final byte[] array = new byte[length];

            String content = new String(array, in.readerIndex(), length);

            if (!StrUtil.isBlankIfStr(content)) {
                if (!IMP.isIMP(content)) {
                    ctx.channel().pipeline().remove(this);
                    return;
                }
            }

            in.getBytes(in.readerIndex(), array, 0, length);
            out.add(new MessagePack().read(array, IMMessage.class));
            in.clear();
        } catch (Exception ex) {
            log.error("decode occur error", ex);
            ctx.channel().pipeline().remove(this);
        }
    }

    public IMMessage decode(String msg) {
        if (StrUtil.isBlankIfStr(msg)) {
            return null;
        }

        try {
            Matcher m = pattern.matcher(msg);
            String header = "";
            String content = "";

            if (m.matches()) {
                header = m.group(1);
                content = m.group(3);
            }

            String[] heads = header.split("\\]\\[");
            long time = 0;


            return null;
        } catch (Exception ex) {
            log.error("");
            return null;
        }
    }
}
