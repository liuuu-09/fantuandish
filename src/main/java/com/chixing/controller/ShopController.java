package com.chixing.controller;

import com.chixing.entity.Shop;
import com.chixing.service.IShopService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

// Shop getById(Integer shopId);
//    int save(Shop shop);
//    int update(Shop shop);
//    int remove(Integer shopId);
// 查 get  增 save  改 update   删 remove
@RestController
public class ShopController {
    @Resource
    private IShopService shopService;

    @GetMapping("/shop/{id}")
    public Shop getById(@PathVariable("id") Integer shopId, HttpServletRequest request){
        return shopService.getById(shopId);
    }

    @PostMapping("/shop")
    public int save(Shop shop){
        return shopService.save(shop);
    }

    @PostMapping("/shop/update")
    public int update(Shop shop){
        return shopService.update(shop);
    }

    @DeleteMapping("/shop")
    public int remove(@RequestParam("id") Integer shopId){
        return shopService.remove(shopId);
    }

    /**
     * 条件筛选（食品类型）
     * @param foodType  食品类型
     * @return  店铺集合
     */
    @GetMapping("/shop/foodType")
    public List<Shop> getByFoodType(@RequestParam("foodType")String foodType){
        List<Shop> shopList = shopService.getByFoodType(foodType);
        shopList.forEach(System.out::println);
        return shopList;
    }

    @GetMapping("/shop/getIndex/{pageNum}")
    public ModelAndView getByPage(@PathVariable("pageNum")Integer pageNum){
        ModelAndView mav = new ModelAndView();
        mav.addObject("shop",shopService.getByPage(pageNum));
        mav.setViewName("shop_list");
        return mav;
    }

    /**
     * 条件筛选（人均消费）
     * @param shopMinCost   最低人均消费
     * @param shopMaxCost   最高人均消费
     * @return  店铺集合
     */
    @GetMapping("/shop/shopAvgCost")
    public List<Shop> getByShopAvgCost(@RequestParam("shopMinCost")Float shopMinCost,@RequestParam("shopMaxCost")Float shopMaxCost){
        List<Shop> shopList = shopService.getByShopAvgCost(shopMinCost,shopMaxCost);
        return shopList;
    }

    /**
     * 多条件筛选（食品类型，人均消费）
     * @param foodType      食品类型
     * @param shopMinCost   最低人均消费
     * @param shopMaxCost   最高人均消费
     * @return  店铺集合
     */
    @GetMapping("/shop/sift")
    public List<Shop> getBySift(@RequestParam("foodType")String foodType,@RequestParam("shopMinCost")Float shopMinCost,@RequestParam("shopMaxCost")Float shopMaxCost){
        List<Shop> shopList = shopService.getBySift(foodType,shopMinCost,shopMaxCost);
        return shopList;
    }

    /**
     * 排序（价格降序）
     * @return  店铺集合
     */
    @GetMapping("/shop/getByPrice")
    public List<Shop> getByPrice(){
        return shopService.getByPrice();
    }

    /**
     * 排序（评分降序）
     * @return  店铺集合
     */
    @GetMapping("/shop/getByScore")
    public ModelAndView getByScore(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("shop",shopService.getByScore());
        mav.setViewName("shop_list");
        return mav;
    }
}
