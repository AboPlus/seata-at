package com.abo.account.mapper;

import com.abo.account.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.math.BigDecimal;

/**
 * @author Abo
 */
public interface AccountMapper extends BaseMapper<Account> {
    void decrease(Long userId, BigDecimal money);
}
