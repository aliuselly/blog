package org.aliuselly.blog_demo.service.impl;

import org.aliuselly.blog_demo.dao.*;
import org.aliuselly.blog_demo.dto.ArticleDto;
import org.aliuselly.blog_demo.dto.ArticleWithPictureDto;
import org.aliuselly.blog_demo.entity.*;
import org.aliuselly.blog_demo.service.ArticleService;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * 文章 service 实现类
 * 说明：ArticleInfo 里面封装了 picture/content/category 等信息
 */
@Service
public class ArticleServiceImpl implements ArticleService {

//    报红是因为没有识别到加进去了 ioc 容器，但是 mapper 注解已经做了，无法识别而已
    @Autowired
    private ArticleInfoMapper articleInfoMapper;
    @Autowired
    private ArticlePictureMapper articlePictureMapper;
    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;
    @Autowired
    private ArticleContentMapper articleContentMapper;
    @Autowired
    private CategoryInfoMapper categoryInfoMapper;

    private static final byte MAX_LAST_ARTICLE_COUNT = 5;

    /**
     * 增加一篇文章信息 tbl_article_info
     * 说明：需要对应的写入 tbl_article_picture/tbl_article_content/tbl_article_category 表
     * @param articleDto
     */
    @Override
    public void addArticle(ArticleDto articleDto) {
//        增加文章信息表 - title/summary
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setTitle(articleDto.getTitle());
        articleInfo.setSummary(articleDto.getSummary());
        articleInfo.setIsTop(articleDto.getIsTop());
//        这里不小心用了 insert 方法进行插入，结果报错 is_top cannot be null，明明有默认值，结果报错，不过换个方法就没有问题了，估计是生成的方法映射有问题吧，还是自己的问题，不知道了
//        不行，明明网页传递数据过来了，结果还是没有插入成功，这个 is_top 字段，换了一个方法还是不成功，虽然插入数据可以，但是 is_top 字段不行
//        sb 了，脑子转过来了，看来得休息会再打了
//        首先，insertSelective 无法插入 is_top 字段的原因是，上面根本就没有设置字段进去，对 articleInfo 这里
//        其次，使用 insert 方法为啥会报错啊 cannot xxx be null，这个是因为，插入的 sql 语句是
//        insert into tbl_article_info (title, summary, is_top, traffic, create_by, modified_by) values (?, ?, ?, ?, ?, ?)
//        看，是全部插入的，因此呢，无法使用默认值的，必须要有值
//        而 insertSelective 方法的插入语句是 insert into tbl_article_info (title, summary, is_top) values (?, ?, ?)，有的值，才是会写进去的
//        其次，其实 mybatis mysql jdbc 之间呢，会做转换的，在 mysql 中就算是 boolean 类型也会转成 tingyint 类型的
//        因为呢，mysql 根本就没有 boolean 类型的数据
//        因此呢，jdbc mybatis 这些呢，都是会进行插入 true 进去的时候，mysql 会转换起来的
//        同时呢
//        mybatis中用tinyint保存Boolean类型的时候，直接使用false和true就可以，mybatis会自动映射。
        articleInfoMapper.insertSelective(articleInfo);

//        获取刚才插入文章信息的 ID
        Long articleId = getArticleLastId();
//        增加文章题图信息 - pictureUrl/articleId
        ArticlePicture articlePicture = new ArticlePicture();
        articlePicture.setArticleId(articleId);
        articlePicture.setPictureUrl(articleDto.getPictureUrl());
//        insert 和 insertSelective 的区别是，insert 会插入 null 的，而，selective 会进行判断 null 的，不会进行插入
        articlePictureMapper.insertSelective(articlePicture);

//        增加文章内容信息表 - content/articleId
        ArticleContent articleContent = new ArticleContent();
        articleContent.setContent(articleDto.getContent());
        articleContent.setArticleId(articleId);
        articleContentMapper.insertSelective(articleContent);

//        增加文章分类信息表 articleId/categoryId
        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setArticleId(articleId);
        articleCategory.setCategoryId(articleDto.getCategoryId());
        articleCategoryMapper.insertSelective(articleCategory);

//        对应文章数量要加 1
        CategoryInfo categoryInfo = categoryInfoMapper.selectByPrimaryKey(articleCategory.getCategoryId()).get();
        categoryInfo.setNumber((byte) (categoryInfo.getNumber() + 1));
        categoryInfoMapper.updateByPrimaryKeySelective(categoryInfo);
    }

    /**
     * 删除一篇文章
     * 说明：需要对应删除 tbl_article_picture/tbl_article_content/tbl_article_category 表中的内容
     * @param id
     */
    @Override
    public void deleteArticleById(Long id) {
//        获取对应文章信息
        ArticleDto articleDto = getOneById(id);
//        删除文章信息中的数据
        articleInfoMapper.deleteByPrimaryKey(articleDto.getId());
//        删除文章题图信息数据
        articlePictureMapper.deleteByPrimaryKey(articleDto.getArticlePictureId());
//        删除文章内容信息表
        articleContentMapper.deleteByPrimaryKey(articleDto.getArticleContentId());
//        删除文章分类信息表
        articleCategoryMapper.deleteByPrimaryKey(articleDto.getArticleCategoryId());

//        最后更新相应的分类数目
        CategoryInfo categoryInfo = new CategoryInfo();
        categoryInfo.setId(articleDto.getCategoryId());
//        注意啊，int 类型是默认类型，编译器不会进行判断的，就算超过了也就是溢出
//        但是呢，编译器会对这个 Byte 类型进行判断的，是否在 -128-127 之间的，常量可以
//        但是呢，如果是函数，变量之类的，编译器无法知道里面的数值是否在合理范围之间，因此呢，就会报红
        /*Byte categoryNumber = articleDto.getCategoryNumber();
        categoryNumber--;
        categoryInfo.setNumber(categoryNumber);
        额，小写的方式就没有那么严格的编译处理么*/
        categoryInfo.setNumber((byte) (articleDto.getCategoryNumber() - 1));
        categoryInfoMapper.updateByPrimaryKeySelective(categoryInfo);
    }

    /**
     * 更新文章信息
     * 说明：需要对应更改 tbl_article_picture/tbl_article_content/tbl_article_category 表的内容
     * 注意：我们使用的是封装好的 article 文章信息类
     * @param articleDto
     */
    @Override
    public void updateArticle(ArticleDto articleDto) {
//        更新文章信息中的数据
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setId(articleDto.getId());
        articleInfo.setTitle(articleDto.getTitle());
        articleInfo.setSummary(articleDto.getSummary());
        articleInfo.setIsTop(articleDto.getIsTop());
        articleInfo.setTraffic(articleDto.getTraffic());
        articleInfoMapper.updateByPrimaryKeySelective(articleInfo);

//        更新文章题图信息数据
        ArticlePicture articlePicture = articlePictureMapper.select(c -> c.where(ArticlePictureDynamicSqlSupport.articleId, SqlBuilder.isEqualTo(articleDto.getId()))).get(0);
        articlePicture.setPictureUrl(articleDto.getPictureUrl());
        articlePictureMapper.updateByPrimaryKeySelective(articlePicture);

//        更新文章内容信息数据
        ArticleContent articleContent = articleContentMapper.select(c -> c.where(ArticleContentDynamicSqlSupport.articleId, SqlBuilder.isEqualTo(articleDto.getId()))).get(0);
        articleContent.setContent(articleDto.getContent());
        articleContentMapper.updateByPrimaryKeySelective(articleContent);

//        更新文章分类信息表
        ArticleCategory articleCategory = articleCategoryMapper.select(c -> c.where(ArticleCategoryDynamicSqlSupport.articleId, SqlBuilder.isEqualTo(articleDto.getId()))).get(0);

        CategoryInfo oldCategory = categoryInfoMapper.selectByPrimaryKey(articleCategory.getCategoryId()).get();
        oldCategory.setNumber((byte) (oldCategory.getNumber() - 1));
        CategoryInfo newCategory = categoryInfoMapper.selectByPrimaryKey(articleDto.getCategoryId()).get();
        newCategory.setNumber((byte) (newCategory.getNumber() + 1));

//        更新 article_category 表
        articleCategory.setCategoryId(articleDto.getCategoryId());
        articleCategoryMapper.updateByPrimaryKeySelective(articleCategory);

//        看了一下，这里漏了一些东西，比如，上面就是将文章移动到了新的 articleCategory 关联表中，但是，这个时候就是有一个问题了
//        旧的分类数量还没有 -1，新的分类还没有 +1

//        修复问题
        categoryInfoMapper.updateByPrimaryKeySelective(oldCategory);
        categoryInfoMapper.updateByPrimaryKeySelective(newCategory);
    }

    /**
     * 更改文章的分类信息
     * @param articleId
     * @param categoryId
     */
    @Override
    public void updateArticleCategory(Long articleId, Long categoryId) {
//        首先这里可能会存在 bug
//        也有可能并没有，因为，这里他仅仅考虑一个文章只属于一个分类的，如果一个文章属于多个分类，那个就会有 bug 了
        ArticleCategory articleCategory = articleCategoryMapper.select(c -> c.where(ArticleCategoryDynamicSqlSupport.articleId, SqlBuilder.isEqualTo(articleId))).get(0);

//        对应改变分类下的文章数目
        CategoryInfo categoryInfo = categoryInfoMapper.selectByPrimaryKey(articleCategory.getCategoryId()).get();
        categoryInfo.setNumber((byte) (categoryInfo.getNumber() - 1));
        categoryInfoMapper.updateByPrimaryKeySelective(categoryInfo);

        categoryInfo = categoryInfoMapper.selectByPrimaryKey(categoryId).get();
        categoryInfo.setNumber((byte) (categoryInfo.getNumber() + 1));
        categoryInfoMapper.updateByPrimaryKeySelective(categoryInfo);

//        更新 tbl_article_category 表字段
        articleCategory.setCategoryId(categoryId);
        articleCategoryMapper.updateByPrimaryKeySelective(articleCategory);
    }

    /**
     * 获取一篇文章内容
     * 说明：需要对应从 tbl_article_picture/tbl_article_content/tbl_article_category 表中获取内容
     * @param id
     * @return
     */
    @Override
    public ArticleDto getOneById(Long id) {
        ArticleDto articleDto = new ArticleDto();
//        填充文章基础信息
        ArticleInfo articleInfo = articleInfoMapper.selectByPrimaryKey(id).get();
        articleDto.setId(articleInfo.getId());
        articleDto.setTitle(articleInfo.getTitle());
        articleDto.setSummary(articleInfo.getSummary());
        articleDto.setIsTop(articleInfo.getIsTop());
        articleDto.setCreateBy(articleInfo.getCreateBy());
//        文章访问量要加 1
//        这个是上面查询出来的，然后要用于 update 的
        articleInfo.setTraffic(articleInfo.getTraffic() + 1);
//        这个是整个方法的返回的，两个不同的对象
        articleDto.setTraffic(articleInfo.getTraffic() + 1);
        articleInfoMapper.updateByPrimaryKey(articleInfo);

//        填充文章内容信息
        ArticleContent articleContent = articleContentMapper.select(c -> c.where(ArticleContentDynamicSqlSupport.articleId, SqlBuilder.isEqualTo(id))).get(0);
        articleDto.setContent(articleContent.getContent());
        articleDto.setArticleContentId(articleContent.getId());

//        填充文章题图信息
        ArticlePicture articlePicture = articlePictureMapper.select(c -> c.where(ArticlePictureDynamicSqlSupport.articleId, SqlBuilder.isEqualTo(id))).get(0);
        articleDto.setPictureUrl(articlePicture.getPictureUrl());
        articleDto.setArticlePictureId(articlePicture.getId());

//        填充文章分类信息
        ArticleCategory articleCategory = articleCategoryMapper.select(c -> c.where(ArticleCategoryDynamicSqlSupport.articleId, SqlBuilder.isEqualTo(id))).get(0);
        articleDto.setArticleCategoryId(articleCategory.getId());

//        填充分类基础信息
        CategoryInfo categoryInfo = categoryInfoMapper.select(c -> c.where(CategoryInfoDynamicSqlSupport.id, SqlBuilder.isEqualTo(articleCategory.getCategoryId()))).get(0);
        articleDto.setCategoryId(categoryInfo.getId());
        articleDto.setCategoryName(categoryInfo.getName());
        articleDto.setCategoryNumber(categoryInfo.getNumber());

        return articleDto;
    }

    /**
     * 通过文章 ID 获取对应的文章题图信息
     * @param id
     * @return
     */
    @Override
    public ArticlePicture getPictureByArticleId(Long id) {
        return articlePictureMapper.select(c -> c.where(ArticlePictureDynamicSqlSupport.articleId, SqlBuilder.isEqualTo(id))).get(0);
    }

    /**
     * 获取所有的文章内容
     * @return
     */
    @Override
    public List<ArticleWithPictureDto> listAll() {
//        1. 先获取所有的数据
        List<ArticleWithPictureDto> articleWithPictureDtos = listAllArticleWithPicture();
//        2. 然后再对集合进行重排，置顶的文章在前
        LinkedList<ArticleWithPictureDto> linkedList = new LinkedList<>();
        for (int i = 0; i < articleWithPictureDtos.size(); i++)
        {
            if (true == articleWithPictureDtos.get(i).getIsTop())
            {
                linkedList.addFirst(articleWithPictureDtos.get(i));
            }
            else
            {
                linkedList.addLast(articleWithPictureDtos.get(i));
            }
        }
        return new ArrayList<>(linkedList);
    }

    /**
     * 通过分类 id 返回该分类下的所有文章
     * @param id
     * @return
     */
    @Override
    public List<ArticleWithPictureDto> listByCategoryId(Long id) {
        List<ArticleCategory> articleCategories = articleCategoryMapper.select(c -> c.where(ArticleCategoryDynamicSqlSupport.categoryId, SqlBuilder.isEqualTo(id)));
        List<ArticleWithPictureDto> articleWithPictureDtos = new ArrayList<>();

        for (int i = 0; i < articleCategories.size(); i++)
        {
            Long articleId = articleCategories.get(i).getArticleId();
            ArticleWithPictureDto articleWithPictureDto = new ArticleWithPictureDto();
//            填充文章基础信息
            ArticleInfo articleInfo = articleInfoMapper.select(c -> c.where(ArticleInfoDynamicSqlSupport.id, SqlBuilder.isEqualTo(articleId))).get(0);
            articleWithPictureDto.setId(articleInfo.getId());
            articleWithPictureDto.setTitle(articleInfo.getTitle());
            articleWithPictureDto.setSummary(articleInfo.getSummary());
            articleWithPictureDto.setIsTop(articleInfo.getIsTop());
            articleWithPictureDto.setTraffic(articleInfo.getTraffic());

//            填充文章图片信息
            ArticlePicture articlePicture = articlePictureMapper.select(c -> c.where(ArticlePictureDynamicSqlSupport.articleId, SqlBuilder.isEqualTo(articleId))).get(0);
            articleWithPictureDto.setArticlePictureId(articlePicture.getId());
            articleWithPictureDto.setPictureUrl(articlePicture.getPictureUrl());

            articleWithPictureDtos.add(articleWithPictureDto);
        }

//        对集合进行重排，置顶的文章在前
        LinkedList<ArticleWithPictureDto> linkedList = new LinkedList<>();
        for (int i = 0; i < articleWithPictureDtos.size(); i++)
        {
            if (true == articleWithPictureDtos.get(i).getIsTop())
            {
                linkedList.addFirst(articleWithPictureDtos.get(i));
            }
            else
            {
                linkedList.addLast(articleWithPictureDtos.get(i));
            }
        }
        return new ArrayList<>(linkedList);
    }

    /**
     * 获取最新的文章信息，默认为 5 篇
     * 说明：listAll 默认已经按照 id 排序了(倒序查询，但是，后面又将置顶的给弄到前面了)，所以，我们只需要返回前 5 篇就可以了
     * 注意，需压判断当前的文章是否大于 5 篇
     * @return
     */
    @Override
    public List<ArticleWithPictureDto> listLast() {
//        1. 先获取所有的数据
        List<ArticleWithPictureDto> articleWithPictureDtos = listAllArticleWithPicture();
//        2. 判断是否满足 5 个的条件
        if (articleWithPictureDtos.size() > MAX_LAST_ARTICLE_COUNT)
        {
//            3. 大于 5 个则返回前 5 个数据
            List<ArticleWithPictureDto> temp = new ArrayList<>();
            for (int i = 0; i < MAX_LAST_ARTICLE_COUNT; i++)
            {
                temp.add(articleWithPictureDtos.get(i));
            }
            return temp;
        }
//        4. 不大于 5 个则直接返回
        return articleWithPictureDtos;
    }

    /**
     * 返回最新插入一条数据的 ID
     * @return
     */
    private Long getArticleLastId()
    {
//        函数试写法
//        SelectDSLCompleter completer = c -> c.orderBy(ArticleInfoDynamicSqlSupport.id.descending());
//        List<ArticleInfo> select = articleInfoMapper.select(completer);
        List<ArticleInfo> select = articleInfoMapper.select(c -> c.orderBy(ArticleInfoDynamicSqlSupport.id.descending()));
        return select.get(0).getId();
    }

    /**
     * 获取所有的文章信息（带题图）
     * @return
     */
    private List<ArticleWithPictureDto> listAllArticleWithPicture()
    {
        List<ArticleInfo> articleInfos = articleInfoMapper.select(c -> c.orderBy(ArticleInfoDynamicSqlSupport.id.descending()));
        List<ArticleWithPictureDto> articleWithPictureDtos = new ArrayList<>();

        for (ArticleInfo articleInfo : articleInfos)
        {
            ArticleWithPictureDto articleWithPictureDto = new ArticleWithPictureDto();
//            填充文章基础信息
            articleWithPictureDto.setId(articleInfo.getId());
            articleWithPictureDto.setTitle(articleInfo.getTitle());
            articleWithPictureDto.setSummary(articleInfo.getSummary());
            articleWithPictureDto.setIsTop(articleInfo.getIsTop());
            articleWithPictureDto.setTraffic(articleInfo.getTraffic());

//            填充文章题图信息
            ArticlePicture articlePicture = articlePictureMapper.select(c -> c.where(ArticlePictureDynamicSqlSupport.articleId, SqlBuilder.isEqualTo(articleInfo.getId()))).get(0);
            articleWithPictureDto.setArticlePictureId(articlePicture.getId());
            articleWithPictureDto.setPictureUrl(articlePicture.getPictureUrl());

            articleWithPictureDtos.add(articleWithPictureDto);
        }
        return articleWithPictureDtos;
    }
}
