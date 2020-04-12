package com.CQA.Listener.OnmyoijiListener;

import com.CQA.Utils.GetTime;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.anno.timetask.CronTask;
import com.forte.qqrobot.log.QQLog;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.timetask.TimeJob;
import com.forte.qqrobot.utils.CQCodeUtil;


@Beans
@CronTask(value = "0 30 20 ? * FRI-SUN")
public class OnmyojyinjieEnd implements TimeJob {

    @Override
    public void execute(MsgSender sender, CQCodeUtil cqCodeUtil) {
        QQLog.info("每周阴界结束提醒");
        OnmyojSenderList.SenderList(sender,"阴界之门还有半个小时就要关咯\n大家别忘了打");
        QQLog.info("每周阴界结束提醒完成");
    }
}
