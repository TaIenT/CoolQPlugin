package com.CQA.Listener.OnmyoijiListener;


import com.CQA.Utils.GetTime;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.anno.timetask.CronTask;
import com.forte.qqrobot.log.QQLog;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.timetask.TimeJob;
import com.forte.qqrobot.utils.CQCodeUtil;


@Beans
@CronTask(value = "0 58 18 ? * MON-THU")
public class Onmyojguiwang implements TimeJob {

    //private final CQCodeUtil util=CQCodeUtil.build();


    @Override
    public void execute(MsgSender sender, CQCodeUtil cqCodeUtil) {
        QQLog.info("每周一到周四麒麟和道馆提醒");
        OnmyojSenderList.SenderList(sender,"还有2分钟麒麟就要开始咯 大家快别忘啦");
        String week = GetTime.week();
        if (week=="Wednesday"){
            OnmyojSenderList.SenderList(sender,"今天是星期三\n别忘了 打完麒麟和道馆以后别忘了宴会哟\n吃饭不积极,脑子有问题(笑");
        }
        QQLog.info("每周一到周四麒麟和道馆提醒完成");
    }
}
