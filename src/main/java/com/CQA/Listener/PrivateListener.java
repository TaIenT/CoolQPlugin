package com.CQA.Listener;

import com.CQA.Bean.Groupable;
import com.forte.qqrobot.anno.Filter;
import com.forte.qqrobot.anno.Listen;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.anno.depend.Depend;

import com.forte.qqrobot.beans.messages.msgget.PrivateMsg;
import com.forte.qqrobot.beans.messages.types.MsgGetTypes;
import com.forte.qqrobot.log.QQLog;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.utils.CQCodeUtil;



//私发消息
@Beans
public class PrivateListener {

    private final CQCodeUtil util=CQCodeUtil.build();



    @Depend
    private Groupable groupable;

    @Listen(MsgGetTypes.privateMsg)
    @Filter("-")
    public void testListen1(PrivateMsg msg, MsgSender sender) {
//        System.out.println(msg);
//        logger.onLog(msg.getQQ(),INFO);
        // 以下三种方法均可，效果相同
        QQLog.info(msg.toString());
        sender.SENDER.sendPrivateMsg(msg, msg.getMsg());
//        sender.SENDER.sendPrivateMsg(msg.getQQ(), msg.getMsg());
//        sender.SENDER.sendPrivateMsg(msg.getQQCode(), msg.getMsg());
    }




    @Listen(MsgGetTypes.privateMsg)
    @Filter(value = ".关")
    public void groupclose(PrivateMsg msg, MsgSender sender){
        if (msg.getQQ().equals("1054001563") ) {
            groupable.close();
            sender.SENDER.sendPrivateMsg(msg,"群功能关闭");
        }else{
            sender.SENDER.sendPrivateMsg(msg,"你不是我的管理员 不能设置此功能哦~");
        }

    }

    @Listen(MsgGetTypes.privateMsg)
    @Filter(value = ".开")
    public void groupopen(PrivateMsg msg, MsgSender sender){
        if (msg.getQQ().equals("1054001563") ) {
            groupable.open();
            sender.SENDER.sendPrivateMsg(msg,"群功能开启");
        } else{
            sender.SENDER.sendPrivateMsg(msg,"你不是我的管理员 不能设置此功能哦~");
        }

    }

    @Listen(MsgGetTypes.privateMsg)
    @Filter(value = ".状态")
    public void groupstatus(PrivateMsg msg, MsgSender sender){
        String status;

        if (groupable.isEnable()==true){
            status="开";
        }else {
            status= "关";
        }
        QQLog.info(status);
        sender.SENDER.sendPrivateMsg(msg,"群功能状态:"+status);
    }





}
