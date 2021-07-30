package com.abo.account.service;

import com.abo.account.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author Abo
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Transactional
    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountMapper.decrease(userId, money);

        if (Math.random() < 0.5) {
            throw new RuntimeException("模拟异常");
        }


    }
}
