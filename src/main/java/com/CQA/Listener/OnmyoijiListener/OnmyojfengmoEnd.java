package com.CQA.Listener.OnmyoijiListener;

import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.anno.timetask.CronTask;
import com.forte.qqrobot.log.QQLog;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.timetask.TimeJob;
import com.forte.qqrobot.utils.CQCodeUtil;

@Beans
@CronTask(value = "0 30 21 ? * *")
public class OnmyojfengmoEnd implements TimeJob {
    @Override
    public void execute(MsgSender sender, CQCodeUtil cqCodeUtil) {
        QQLog.info("每日逢魔结束提醒");
        OnmyojSenderList.SenderList(sender,"逢魔之时还有半个小时就要结束咯\n还没有打的小姐姐小哥哥快点打哟");
        QQLog.info("每周逢魔结束提醒完成");
    }
}
