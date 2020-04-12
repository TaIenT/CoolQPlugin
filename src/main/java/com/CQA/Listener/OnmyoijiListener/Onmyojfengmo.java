package com.CQA.Listener.OnmyoijiListener;


import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.anno.timetask.CronTask;
import com.forte.qqrobot.log.QQLog;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.timetask.TimeJob;
import com.forte.qqrobot.utils.CQCodeUtil;

@Beans
@CronTask(value = "0 0 17 ? * *")
public class Onmyojfengmo implements TimeJob {

    @Override
    public void execute(MsgSender sender, CQCodeUtil cqCodeUtil) {
        QQLog.info("每日逢魔提醒");
        OnmyojSenderList.SenderList(sender,"逢魔之时开始咯 大家别忘了哟");
        QQLog.info("每周逢魔提醒完成");
    }

}
