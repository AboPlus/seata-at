package com.abo.storage.mapper;

import com.abo.storage.entity.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author Abo
 */
public interface StorageMapper extends BaseMapper<Storage> {

    void decrease(Long productId, Integer count);

}
