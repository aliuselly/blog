package org.aliuselly.blog_demo.service.impl;

import org.aliuselly.blog_demo.dao.ArticleCategoryDynamicSqlSupport;
import org.aliuselly.blog_demo.dao.ArticleCategoryMapper;
import org.aliuselly.blog_demo.dao.CategoryInfoDynamicSqlSupport;
import org.aliuselly.blog_demo.dao.CategoryInfoMapper;
import org.aliuselly.blog_demo.dto.ArticleCategoryDto;
import org.aliuselly.blog_demo.entity.ArticleCategory;
import org.aliuselly.blog_demo.entity.CategoryInfo;
import org.aliuselly.blog_demo.service.CategoryService;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类 service 实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryInfoMapper categoryInfoMapper;
    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    /**
     * 增加一条分类数据
     * @param categoryInfo
     */
    @Override
    public void addCategory(CategoryInfo categoryInfo) {
        categoryInfoMapper.insertSelective(categoryInfo);
    }

    /**
     * 通过分类 id 删除分类信息，要删除对应两个表的内容
     * @param id
     */
    @Override
    public void deleteCategoryById(Long id) {
//        先删除 articleCategory 表中的相关内容
        List<ArticleCategory> articleCategories = articleCategoryMapper.select(c -> c.where(ArticleCategoryDynamicSqlSupport.categoryId, SqlBuilder.isEqualTo(id)));
        for (ArticleCategory articleCategory : articleCategories)
        {
//            注意，人家的设计是一个文章只有一个分类，因此，一个分类中有很多的文章，不然逻辑上就会有问题
            articleCategoryMapper.deleteByPrimaryKey(articleCategory.getId());
        }
//        再删除 categoryInfo 表中的内容
        categoryInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新分类信息
     * @param categoryInfo
     */
    @Override
    public void updateCategory(CategoryInfo categoryInfo) {
        categoryInfoMapper.updateByPrimaryKeySelective(categoryInfo);
    }

    /**
     * 更新文章对应的分类
     * @param articleCategory
     */
    @Override
    public void updateArticleCategory(ArticleCategory articleCategory) {
        articleCategoryMapper.updateByPrimaryKeySelective(articleCategory);
    }

    /**
     * 获取一条分类信息数据
     * @param id
     * @return
     */
    @Override
    public CategoryInfo getOneById(Long id) {
        return categoryInfoMapper.select(c -> c.where(CategoryInfoDynamicSqlSupport.id, SqlBuilder.isEqualTo(id))).get(0);
    }

    /**
     * 列举返回所有的分类信息
     * @return
     */
    @Override
    public List<CategoryInfo> listAllCategory() {
//        无条件查询即返回所有
        return categoryInfoMapper.select(c -> c.where());
    }

    /**
     * 通过文章 ID 获取某一篇文章对应的分类
     * @param id
     * @return
     */
    @Override
    public ArticleCategoryDto getCategoryByArticleId(Long id) {
//        填充 tbl_article_category 中的基础数据
//        果然，人家一个文章只有一个分类的
        ArticleCategory articleCategory = articleCategoryMapper.select(c -> c.where(ArticleCategoryDynamicSqlSupport.articleId, SqlBuilder.isEqualTo(id))).get(0);

//        填充对应的分类信息
        CategoryInfo categoryInfo = getOneById(articleCategory.getCategoryId());

        ArticleCategoryDto articleCategoryDto = ArticleCategoryDto.builder()
                .articleId(articleCategory.getArticleId())
                .id(articleCategory.getId())
                .categoryId(articleCategory.getCategoryId())
                .name(categoryInfo.getName())
                .number(categoryInfo.getNumber())
                .build();
        return articleCategoryDto;
    }
}
