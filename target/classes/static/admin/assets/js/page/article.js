// 注意，别忘了，这个 component 的写法，是整个抽取的，是重复使用的，如果没有重复使用的就别了
// 同时，也要注意，component 使用的时候呢，是需要 div span 等标签包围的
// 使用其他的，template 标签的那种是，在 template 标签中定义好，然后在 new Vue 的那个标签中引用，然后整个 template 标签
// 替换进去到 new Vue 的那个标签当中
Vue.component('select-category', {
    template: '<select v-bind:id="selectId" v-on:change="selectArticleCategory($event)" v-model="nowSelect">' +
        '<option v-for="category in categories" v-bind:key="category.id" v-bind:categoryId="category.id" v-text="category.name"></option>' +
        '</select>',
    props: {
        categories: {
            type: Array,
            default: []
        },
        selectId: {
            type: String,
            default: ''
        }
    },
    data() {
        return {
            nowSelect: ''
        }
    },
    methods: {
        // 用于请求数据的方法
        getCategoryById(categoryId) {
            let url = 'http://localhost:8080/api/article/list/category/' + categoryId;
            if (categoryId == -1)
            {
                url = 'http://localhost:8080/api/article/list';
            }
            axios
                .get(url, {
                    headers: {
                        'Cache-Control': 'no-cache'
                    }
                })
                .then(response => {
                    store.dispatch('changeArticleCategory', {
                        amount: response.data
                    });
                    eventBus.$emit('changeArticleCategory');
                })
                .catch(err => {
                    console.log(err);
                    alert('获取 categoryId = ' + categoryId + ' 分类下的文章失败！');
                });
        },
        // 点击事件调用的方法
        selectArticleCategory(event) {
            // 额，这么获取是对象的，因此，要 value 获取值
            let categoryId = event.target.selectedOptions[0].attributes.getNamedItem('categoryId').value;
            // 避免添加文章那边进行调用
            if (this.selectId == 'queryCategory')
            {
                this.getCategoryById(categoryId);
            }
            else if (this.selectId == 'appendCategory')
            {
                // 不成功，是 vue 3 的么
                // this.$emit('transferSelectId', categoryId);
                // 首先，这个是很有必要的，因为呢，父组件那边没有定义怎么获取到选中的分类 ID，这里是通过子组件的
                // click 事件进行获取，然后再通知给父组件的
                eventBus.$emit('transferSelectId', categoryId);
            }
            else
            {
                // 传递要更新的组件给父组件
                eventBus.$emit('transferUpdateCategoryId', categoryId)
            }
        }
    },
    mounted() {
        // 这个方法是让父组件获取到数据之后，子组件默认选择到全部的那个数据项
        eventBus.$on('categoriesData', function(updateCategoryId) {
            // console.log(this.categories);
            // console.log(store.getters.getCategories);
            // 通过这里知道了原来 props 中的数据比 mounted 还要慢的，也就是说，组件准备好了之后呢，父组件还没开始传递数据
            // 同时呢，看了一下，貌似打印出来的数据呢，是执行了两遍的，不知道为啥，额，忘了，有两个子组件同时引用啊
            // 以后得写注释了，有点认不出来自己写的是啥了，哈哈
            if (this.selectId == 'updateCategory')
            {
                this.nowSelect = store.getters.getCategories.find((category, index) => category.id == updateCategoryId).name;
            }
            else
            {
                this.nowSelect = store.getters.getCategories[0].name;
            }
        }.bind(this));

        // 注意，此时是在子组件中写的，因此呢，如果不做区分会两个组件同时生效的
        eventBus.$on('addOverToChangeCategory', function(addOverToCategoryId) {
            // 自己本身添加那里就已经选择好了，因此呢，不用多此一举
            if ('appendCategory' == this.selectId || 'updateCategory' == this.selectId)
            {
                return;
            }
            // 此时查看文章那边的下拉框就和添加文章那边的就一致了
            // 同时呢，这里已经过了一开始的加载的时候了，因此呢，这个 categories 中肯定有数据了
            this.nowSelect = this.categories.find((category, index) => category.id == addOverToCategoryId).name;
            // 但是呢，终究这些是人为代码的，不会主动触发 event 事件，因此呢，我们需要手动触发一下
            this.getCategoryById(addOverToCategoryId);
        }.bind(this));
    }
});
