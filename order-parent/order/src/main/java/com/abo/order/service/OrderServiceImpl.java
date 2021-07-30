package com.abo.order.service;

import com.abo.order.entity.Order;
import com.abo.order.feign.AccountClient;
import com.abo.order.feign.EasyIdClient;
import com.abo.order.feign.StorageClient;
import com.abo.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author Abo
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private EasyIdClient easyIdClient;
    @Autowired
    private AccountClient accountClient;
    @Autowired
    private StorageClient storageClient;


    @Override
    public void create(Order order) {
        // 调用发号器获取订单id
        String order_business = easyIdClient.nextId("order_business");
        Long orderId = Long.valueOf(order_business);
        order.setId(orderId);

        /*// 临时产生订单id，调用发号器后这里的代码删除
        long orderId = Math.abs(new Random().nextLong());
        order.setId(orderId);*/

        orderMapper.create(order);

        // 减少库存
        storageClient.decrease(order.getProductId(), order.getCount());

        // 扣减账户
        accountClient.decrease(order.getUserId(), order.getMoney());

    }
}
