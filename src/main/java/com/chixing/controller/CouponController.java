package com.chixing.controller;

import com.chixing.commons.R;
import com.chixing.entity.Coupon;
import com.chixing.service.ICouponService;
import com.chixing.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ZhangJiuJiu
 */
@RestController
@RequestMapping("/coupon")
public class  CouponController {

    @Autowired
    private ICouponService couponService;

    @PostMapping("/save")
    public R<Object> save(@RequestParam("couponId") Integer couponId){
//        Integer cusId = JwtUtil.getCusIdBySession(request);
        if(couponService.saveByCusId(couponId,1)){
            return R.ok();
        }
        return R.fail();
    }

    @DeleteMapping("/remove/{id}")
    public String remove(@PathVariable("id")int couponId){
        int row = couponService.remove(couponId);
        return "删除优惠券"+couponId;
    }

    @PutMapping("/update")
    public String update(Coupon coupon){
        coupon.setCouponUpdateTime(LocalDateTime.now());
        int row = couponService.update(coupon);
        return coupon.toString();
    }

    @GetMapping("/getById/{id}")
    public Coupon getById(@PathVariable("id")int couponId){
        return couponService.getById(couponId);
    }



}
