Vue.component('select-articles', {
    template: '<select v-model="defaultSelect" v-on:change="changArticle($event)">' +
        '<option v-for="article in articles" v-bind:key="article.id" v-bind:articleId="article.id" v-text="article.title"></option>' +
        '</select>',
    props: {
        articles: {
            type: Array,
            default: []
        }
    },
    data() {
        return {
            // 注意，这个不能用 computed 方式，除非你有方式能动态获取
            defaultSelect: ''
        }
    },
    methods: {
        getCommentsByArticleId() {
            let articleId = store.getters.getArticleComment.find((article, index) => article.title == this.defaultSelect).id;
            axios
                .get('http://localhost:8080/api/comment/article/' + articleId, {
                    headers: {
                        'Cache-Control': 'no-cache'
                    }
                })
                .then(response => {
                    store.dispatch('addDataByComments', {
                        amount: response.data
                    });
                    // 告知 tbody 那边可以进行获取数据了
                    eventBus.$emit('commentDataReady');
                })
                .catch(err => {
                    console.log(err);
                    alert('获取 articleId = ' + articleId + ' 文章下的评论失败！');
                });
        },
        changArticle(event) {
            this.getCommentsByArticleId();
        }
    },
    mounted() {
        // 接收父组件传递过来的消息
        eventBus.$on('articleDataReady', function() {
            this.defaultSelect = store.getters.getArticleComment[0].title;
            this.getCommentsByArticleId();
        }.bind(this));
    }
});
