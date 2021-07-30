package com.abo.order.mapper;

import com.abo.order.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author Abo
 */
public interface OrderMapper extends BaseMapper<Order> {
    void create(Order order);
}
