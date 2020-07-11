package org.hg.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hg.demo.pojo.PurchaseRecordPo;

/**
 * @author: wzh
 * @time: 2020/7/11 12:11
 * @description:
 */
public interface PurchaseRecordMapper {
    public int insertPurchaseRecord(@Param("pr") PurchaseRecordPo pr);
}
