package com.chixing;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class GeomagicStudio {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:p6spy:mysql://192.168.186.85:3306/fuantuanfood?characterEncoding=utf8&serverTimezone=Asia/Shanghai", "root", "20001023")
                .globalConfig(builder -> {
                    builder.author("baomidou") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://fantuandish"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.chixing") // 设置父包名
                            .moduleName("") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://fantuandish")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("coupon") // 设置需要生成的表名
                            .addInclude("customer")
                            .addInclude("eva_img")
                            .addInclude("evaluation")
                            .addInclude("flow")
                            .addInclude("food")
                            .addInclude("food_collection")
                            .addInclude("food_img")
                            .addInclude("my_coupon")
                            .addInclude("order")
                            .addInclude("praise")
                            .addInclude("second_kill")
                            .addInclude("shop")
                            .addInclude("shop_collection")
                            .addInclude("shop_img")
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}