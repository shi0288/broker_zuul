package com.xyauto.interact.broker.zuul.util.duiba.service;

import com.xyauto.interact.broker.zuul.util.duiba.CreditConsumeParams;
import com.xyauto.interact.broker.zuul.util.duiba.CreditConsumeResult;
import com.xyauto.interact.broker.zuul.util.duiba.CreditNotifyParams;
import com.xyauto.interact.broker.zuul.util.duiba.dao.CreditConsumeParamsDao;
import com.xyauto.interact.broker.zuul.util.duiba.dao.CreditConsumeResultDao;
import com.xyauto.interact.broker.zuul.util.duiba.dao.CreditNotifyParamsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shiqm on 2018-03-16.
 */

@Service
public class DuibaService {

    @Autowired
    private CreditConsumeResultDao creditConsumeResultDao;

    @Autowired
    private CreditConsumeParamsDao creditConsumeParamsDao;

    @Autowired
    private CreditNotifyParamsDao creditNotifyParamsDao;


    public void addCreditConsumeParams(CreditConsumeParams creditConsumeParams) {
        creditConsumeParamsDao.save(creditConsumeParams);
    }

    public void addCreditConsumeResult(CreditConsumeResult creditConsumeResult) {
        creditConsumeResultDao.save(creditConsumeResult);
    }

    public CreditConsumeResult getCreditConsumeResultByOrderNum(String orderNum) {
        CreditConsumeResult c = new CreditConsumeResult();
        c.setOrderNum(orderNum);
        return creditConsumeResultDao.findOne(c);
    }

    public void addCreditNotifyParams(CreditNotifyParams creditNotifyParams) {
        creditNotifyParamsDao.save(creditNotifyParams);
    }


}
