package org.aliuselly.blog_demo;

import org.aliuselly.blog_demo.controller.BackstageController;
import org.aliuselly.blog_demo.controller.ForeController;
import org.aliuselly.blog_demo.entity.CategoryInfo;
import org.aliuselly.blog_demo.service.ArticleService;
import org.aliuselly.blog_demo.service.CategoryService;
import org.aliuselly.blog_demo.service.impl.ArticleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.util.List;

@SpringBootTest
class BlogDemoApplicationTests {

    @Resource
    ArticleServiceImpl articleService;

    @Resource
    CategoryService categoryService;

    @Autowired
    BackstageController controller;

    @Autowired
    ForeController foreController;

    @Test
    void contextLoads() {
//        System.out.println(articleService.getArticleLastId());
//        categoryService.listAllCategory().forEach(System.out::println);
    }

    @Test
    void testInsert()
    {
        foreController.listNoArticleComment();
    }

}
