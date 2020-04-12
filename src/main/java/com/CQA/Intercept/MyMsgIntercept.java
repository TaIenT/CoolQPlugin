package com.CQA.Intercept;

import com.CQA.Bean.Groupable;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.anno.depend.Depend;
import com.forte.qqrobot.beans.messages.msgget.GroupMsg;
import com.forte.qqrobot.listener.MsgGetContext;
import com.forte.qqrobot.listener.MsgIntercept;


@Beans
public class MyMsgIntercept implements MsgIntercept {

    @Depend
    private Groupable groupable;


    @Override
    public boolean intercept(MsgGetContext context) {
        if (context.getMsgGet() instanceof GroupMsg){
            return groupable.isEnable();
        }


        return true;
    }
}
