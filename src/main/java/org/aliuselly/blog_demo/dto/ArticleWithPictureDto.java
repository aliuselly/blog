package org.aliuselly.blog_demo.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 带题图信息的文章基础信息分装类
 */
@Data
public class ArticleWithPictureDto {

//    tbl_article_info 基础字段
    private Long id;                // ArticleInfo 主键
    private String title;           // 文章标题
    private String summary;         // 文章简介
    private Boolean isTop;          // 文章是否置顶
    private Integer traffic;        // 文章阅读量

//    tbl_article_picture 基础字段
    private Long articlePictureId;  // ArticlePicture 主键
    private String pictureUrl;      // 文章题图 Url
}
