package org.aliuselly.blog_demo.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 文章分类传输对象
 * 说明：关联了 tbl_article_category 和 tbl_category_info 两张表的数据
 */
@Data
@Builder(toBuilder = true)  // 由于要反复赋值的，使用这种吧，ArticleWithPictureDto 无法使用了，是中途变换的
public class ArticleCategoryDto {

//    tbl_article_category 表基础字段
    private Long id;            // 主键
    private Long categoryId;    // 分类信息 ID
    private Long articleId;     // 文章 ID

//    tbl_category_info 表基础字段
    private String name;        // 分类信息显示名称
    private Byte number;        // 该分类下对应的文章数量
}
