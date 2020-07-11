package org.hg.demo.service.impl;


import org.hg.demo.mapper.ProductMapper;
import org.hg.demo.mapper.PurchaseRecordMapper;
import org.hg.demo.pojo.ProductPo;
import org.hg.demo.pojo.PurchaseRecordPo;
import org.hg.demo.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: wzh
 * @time: 2020/7/11 13:45
 * @description:
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private PurchaseRecordMapper purchaseRecordMapper;

    @Override
    @Transactional
    public boolean purchase(Long userId, Long productId, int quantity) {
//        //得到产品
//        ProductPo product = productMapper.getProduct(productId);
//        //计算是否有剩余
//        if (product.getStock()<quantity){
//            return false;
//        }
//        //获取当前版本的版本号
//        int version = product.getVersion();
//        //扣减库存
//        int result = productMapper.decreaseProduct(productId, quantity, version);
//        if (result==0)
//            return false;
        //新建购买记录
//        PurchaseRecordPo pr = this.initPurchaseRecord(userId, product, quantity);
//        //插入购买记录
//        purchaseRecordMapper.insertPurchaseRecord(pr);
//        return true;

        //使用时间戳的可重入乐观锁
//        long start = System.currentTimeMillis();
//        while (true){
//            long end = System.currentTimeMillis();
//            if (end-start>100)
//                return false;
//            ProductPo product = productMapper.getProduct(productId);
//            //计算是否有剩余
//            if (product.getStock()<quantity){
//                return false;
//            }
//            //获取当前版本的版本号
//            int version = product.getVersion();
//            //扣减库存
//            int result = productMapper.decreaseProduct(productId, quantity, version);
//            if (result==0)
//               continue;
//            //新建购买记录
//            PurchaseRecordPo pr = this.initPurchaseRecord(userId, product, quantity);
//            //插入购买记录
//            purchaseRecordMapper.insertPurchaseRecord(pr);
//            return true;
//        }

        //使用限定次数重入的乐观锁，设置为三次
        for (int i=0;i<3;i++){
            ProductPo product = productMapper.getProduct(productId);
            //计算是否有剩余
            if (product.getStock()<quantity){
                return false;
            }
            //获取当前版本的版本号
            int version = product.getVersion();
            //扣减库存
            int result = productMapper.decreaseProduct(productId, quantity, version);
            if (result==0)
                continue;
            //新建购买记录
            PurchaseRecordPo pr = this.initPurchaseRecord(userId, product, quantity);
            //插入购买记录
            purchaseRecordMapper.insertPurchaseRecord(pr);
            return true;
        }
        return false;
    }
    private PurchaseRecordPo initPurchaseRecord(Long userId, ProductPo product, int quantity){
        PurchaseRecordPo pr = new PurchaseRecordPo();
        pr.setUser_id(userId);
        pr.setProduct_id(product.getId());
        pr.setPrice(product.getPrice());
        pr.setQuantity(quantity);
        double sum = product.getPrice()*quantity;
        pr.setSum(sum);
        return pr;
    }
}
