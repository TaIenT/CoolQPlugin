package com.CQA.Listener;


import com.CQA.Listener.OnmyoijiListener.OnmyojSenderList;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.anno.timetask.CronTask;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.timetask.TimeJob;
import com.forte.qqrobot.utils.CQCodeUtil;


//早上7:30根据设定好的qq号以及qq群发送定时消息
@Beans
@CronTask(value = "0 30 7 ? * *")
public class morningSender implements TimeJob {


    @Override
    public void execute(MsgSender msgSender, CQCodeUtil cqCodeUtil) {
        OnmyojSenderList.SenderList(msgSender,"早上好\n新的一天又是新的开始\n今天也要努力奋斗哦(指肝阴阳师\n加油 fighting");
    }
}
