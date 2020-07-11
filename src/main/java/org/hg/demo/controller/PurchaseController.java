package org.hg.demo.controller;

import org.hg.demo.service.impl.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Result;

/**
 * @author: wzh
 * @time: 2020/7/11 13:57
 * @description:
 */
@RestController
public class PurchaseController {
    @Autowired
    PurchaseServiceImpl purchaseService;

    @GetMapping("/test")
    public ModelAndView testPage(){
        System.out.println("1");
        ModelAndView mv = new ModelAndView("test");
        System.out.println(mv);
        return mv;
    }

    @GetMapping("/purchase")
    //Long userId, Long productId, Integer quantity
    //因为高并发测试不会设置参数
    //使用ab做高并发测试，post请求不会设置，所以只能做get请求
    public Result purchase(){
        Long userId = 1L;
        Long productId = 1L;
        Integer quantity = 10;
//        System.out.println(userId+" "+productId+" "+quantity);
        boolean success = purchaseService.purchase(userId, productId, quantity);
        String message = success ? "抢购成功":"抢购失败";
        Result result = new Result(success, message);
        return result;
    }

    class Result{
        private boolean success = false;
        private String message = null;
        public Result(){}
        public Result(boolean success, String message){
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
