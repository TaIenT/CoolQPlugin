package com.CQA.Listener.OnmyoijiListener;


import com.CQA.Utils.GetTime;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.anno.timetask.CronTask;
import com.forte.qqrobot.log.QQLog;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.timetask.TimeJob;
import com.forte.qqrobot.utils.CQCodeUtil;


@Beans
@CronTask(value = "0 0 19 ? * FRI-SUN")
public class Onmyojyinjiestart implements TimeJob {

    @Override
    public void execute(MsgSender sender, CQCodeUtil cqCodeUtil) {
        QQLog.info("每周阴界提醒");
        OnmyojSenderList.SenderList(sender,"阴界之门开咯\n大家别忘了打");

        QQLog.info("每周阴界提醒完成");
    }
}
