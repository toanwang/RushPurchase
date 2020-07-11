package org.hg.demo.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author: wzh
 * @time: 2020/7/11 11:37
 * @description:
 */
@Alias("productPo")
public class ProductPo implements Serializable {
    private static final long serialVersionUID = 3288311147760635602L;
    private Long id;
    private String product_name;
    private int stock;
    private double price;
    private int version;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
