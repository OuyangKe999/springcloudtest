package com.oyk.springcloud.alibaba.service.impl;

import com.oyk.springcloud.alibaba.dao.AccountDao;
import com.oyk.springcloud.alibaba.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author: Ouyang Ke
 * @create: 2020-08-08 21:35:13
 * @description:
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER= LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountDao accountDao;

    /**
     *扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {

        LOGGER.info("---->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        accountDao.decrease(userId,money);
        LOGGER.info("---->account-service中扣减账户余额结束");
    }
}
