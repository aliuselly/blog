package org.aliuselly.blog_demo.service;

import org.aliuselly.blog_demo.dto.ArticleDto;
import org.aliuselly.blog_demo.dto.ArticleWithPictureDto;
import org.aliuselly.blog_demo.entity.ArticlePicture;

import java.util.List;

/**
 * 文章 service
 * 说明：ArticleInfo 里面封装了 picture/content/category 等信息
 */
public interface ArticleService {

    void addArticle(ArticleDto articleDto);

    void deleteArticleById(Long id);

    void updateArticle(ArticleDto articleDto);

    void updateArticleCategory(Long articleId, Long categoryId);

    ArticleDto getOneById(Long id);

    ArticlePicture getPictureByArticleId(Long id);

    List<ArticleWithPictureDto> listAll();

    List<ArticleWithPictureDto> listByCategoryId(Long id);

    List<ArticleWithPictureDto> listLast();
}
