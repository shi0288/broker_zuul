package com.xyauto.interact.broker.zuul.util.duiba.dao;

import com.xyauto.interact.broker.zuul.util.MongoRepository;
import com.xyauto.interact.broker.zuul.util.duiba.CreditNotifyParams;
import org.springframework.stereotype.Repository;

/**
 * Created by shiqm on 2018-03-16.
 */
@Repository
public class CreditNotifyParamsDao extends MongoRepository<CreditNotifyParams,Long> {
}
