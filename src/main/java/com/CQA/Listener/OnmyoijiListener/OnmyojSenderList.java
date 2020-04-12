package com.CQA.Listener.OnmyoijiListener;


import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.beans.cqcode.CQCode;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.utils.CQCodeUtil;

@Beans
public class OnmyojSenderList {
    public static final CQCodeUtil util=CQCodeUtil.build();

    public static void SenderList(MsgSender sender,String msg){
        final CQCode atAll = util.getCQCode_AtAll();
        sender.SENDER.sendPrivateMsg("1054001563",msg);
        sender.SENDER.sendPrivateMsg("2712090164",msg);
        sender.SENDER.sendGroupMsg("1054944001",msg);
        //sender.SENDER.sendGroupMsg("1077047975",msg);
    }


}
