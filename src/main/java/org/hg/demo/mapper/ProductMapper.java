package org.hg.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.hg.demo.pojo.ProductPo;

/**
 * @author: wzh
 * @time: 2020/7/11 11:56
 * @description:
 */

public interface ProductMapper {
    public ProductPo getProduct(Long id);
//    public int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);
    //乐观锁需要传递版本号
    public int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity, @Param("version") int version);
}
