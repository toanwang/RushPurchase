package org.hg.demo.service;

/**
 * @author: wzh
 * @time: 2020/7/11 12:33
 * @description:
 */
public interface PurchaseService {
    public boolean purchase(Long userId, Long productId, int quantity);
}
