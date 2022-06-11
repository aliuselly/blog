package org.aliuselly.blog_demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 文章评论信息
 * 说明：关联了 tbl_comment 和 tbl_article_comment 两张表的信息
 */
@Data
@Builder(toBuilder = true)
public class ArticleCommentDto {

//    tbl_comment 基础字段
    private Long id;                // 评论 id
    private String content;         // 评论内容
    private String name;            // 用户自定义的显示名称
    private String email;
    private String ip;
    private Date createBy;

//    tbl_article_comment 基础字段
    private Long articleCommentId;  // 主键 tbl_article_comment
    private Long articleId;         // 文章 id

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateBy() {
        return createBy;
    }
}
