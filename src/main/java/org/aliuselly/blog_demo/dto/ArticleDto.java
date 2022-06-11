package org.aliuselly.blog_demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 文章信息类
 * 说明：关联了 tbl_article_info  |  tbl_article_content  | tbl_article_category  | tbl_category_info  |  tbl_article_picture
 * 五张表的基础字段
 */
@Data
public class ArticleDto {

//    tbl_article_info 基础字段
    private Long id;                // 主键
    private String title;           // 文章标题
    private String summary;         // 文章简介
    private Boolean isTop;          // 文章是否置顶
    private Integer traffic;        // 文章浏览量
    private Date createBy;          // 文章创建时间

//    tbl_article_content 基础字段
    private Long articleContentId;  // ArticleContetn 表主键
    private String content;         // 文章内容

//    tbl_category_info 基础字段
    private Long categoryId;        // 分类 ID
    private String categoryName;    // 分类名称
    private Byte categoryNumber;    // 分类对应数量

//    tbl_article_category 基础字段
    private Long articleCategoryId; // ArticleCategory 表主键

//    tbl_article_picture 基础字段
    private Long articlePictureId;  // ArticlePicture 表主键
    private String pictureUrl;      // 文章题图 url

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateBy() {
        return createBy;
    }
}
