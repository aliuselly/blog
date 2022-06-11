package org.aliuselly.blog_demo.service;

import org.aliuselly.blog_demo.dto.ArticleCategoryDto;
import org.aliuselly.blog_demo.entity.ArticleCategory;
import org.aliuselly.blog_demo.entity.CategoryInfo;

import java.util.List;

/**
 * 分类 service
 */
public interface CategoryService {

    void addCategory(CategoryInfo categoryInfo);

    void deleteCategoryById(Long id);

    void updateCategory(CategoryInfo categoryInfo);

    void updateArticleCategory(ArticleCategory articleCategory);

    CategoryInfo getOneById(Long id);

    List<CategoryInfo> listAllCategory();

    ArticleCategoryDto getCategoryByArticleId(Long id);
}
