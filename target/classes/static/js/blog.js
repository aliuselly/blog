// 原来如此，加上 ? 的话，就是表示在当前页面加上参数再次请求
Vue.component('div-category', {
    template: '<div class="categoryInfo">' +
        '   <a v-text="category.name" href="javascript:void(0)" v-on:click="doLoadCategoryArticle(category.id)"></a>' +
        '</div>',
    props: {
        category: {
            type: Object,
            default: {}
        }
    },
    methods: {
        // 点击分类切换分类下的文章
        doLoadCategoryArticle(categoryId)
        {
            // 这么写是不行的，因为呢 axios 是异步的，会获取不到数据的，因此呢，改个写法
            if (categoryId != -1)
            {
                axios
                    .get('http://localhost:8080/api/article/list/category/' + categoryId, {
                        headers: {
                            'Cache-Control': 'no-cache'
                        }
                    })
                    .then(response => blogBus.$emit('categoryArticlesDataReady', response.data))
                    .catch(err => {
                        console.log(err);
                        alert('获取 categoryId = ' + categoryId + ' 的分类下的文章失败！');
                    });
            }
            else
            {
                blogBus.$emit('allCategoryArticles');
            }
        }
    }
});

Vue.component('div-article', {
    template: '<div class="articleInfo" v-on:click="showArticleDetail(article.id)">' +
        '   <div class="articlePicture">' +
        '       <img v-bind:src="article.pictureUrl">' +
        '   </div> ' +
        '   <div class="articleTitle">' +
        '       <h5 v-text="article.isTop ? (\'[置顶] \' + article.title) : article.title"></h5>' +
        '   </div>' +
        '</div>',
    props: {
        article: {
            type: Object,
            default: {}
        }
    },
    methods: {
        // 点击文章页面进行跳转
        showArticleDetail(articleId)
        {
            window.location.href = '/article.html?articleId=' + articleId;
        }
    }
});
