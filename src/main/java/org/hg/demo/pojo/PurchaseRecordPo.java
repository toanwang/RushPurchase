package org.hg.demo.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author: wzh
 * @time: 2020/7/11 11:47
 * @description:
 */
@Alias("purchaseRecord")
public class PurchaseRecordPo implements Serializable {
    private static final Long serialVersionUID = -360816189433370174L;
    private Long id;
    private Long user_id;
    private Long product_id;
    private double price;
    private int quantity;
    private double sum;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
