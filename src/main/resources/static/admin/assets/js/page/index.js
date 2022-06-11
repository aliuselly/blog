Vue.component('div-h3', {
    // 给自己定义一个名字，用于给别的 vue 引用，如果不写，默认为标签名
    // name: 'templateH3',
    template: '<h3> {{ vcount }} </h3>',
    data() {
        return {
            vcount: 0
        }
    },
    props: {
        getPath: {
            type: String,
            default: ''
        }
    },
    mounted() {
        axios
            .get('http://localhost:8080' + this.getPath, {
                headers: {
                    // 禁用缓存
                    'Cache-Control': 'no-cache'
                }
            })
            .then(response => (this.vcount = response.data.length))
            .catch(err => console.log(err));
        // this.testV();
    }
    /*
    // 用于测试
    methods: {
        testV: function ()
        {
            let x = this.getPath;
            console.log(x + '--' + this.props);
        }
    }
     */
});

Vue.component('visit-data', {
    // 同时呢，对于 v-for 标签来说，他写在哪就是循环哪个标签的，比如 <li v-for> 就是循环 v-for
    // 但是呢，貌似对于 v-for 与 tbody 的结合不同，在 tbody 里写是没有作用的，而写在 <tr> 上的时候，里边写 <td> 即可
    // 但是呢，当 v-for 再与 子组建 结合那么，从上面得知不能够写 tbody 上，所以写在 <tr> 上，因此，子组件写 <td>，你以为显示正常
    // 结果不是的，因为呢，<tr> id=1 id=2 </tr> 这么来显示的，他不会给你加上 <tr> 这个换行的，也就是说，
    // 当与子组件结合的时候，那么写 v-for 是他要开始的位置，你子组件要连带这个开始的位置也要一起写，
    // 但是，如果没有子组件那么 v-for 就是循环这个东西
    template: '<tr>' +
        '<td>{{ getVisit.id }}</td>' +
        '<td>{{ getVisit.ip }}</td>' +
        '<td>{{ getVisit.createBy }}</td>' +
        '</tr>',
    props: {
        getVisit: {
            type: Object,
            default: {}
        }
    }
});

Vue.component('log-data', {
    template: '<tr>' +
        '<td>{{ getLog.id }}</td>' +
        '<td>{{ getLog.ip }}</td>' +
        '<td>{{ getLog.createBy }}</td>' +
        '<td>{{ getLog.remark }}</td>' +
        '<td>{{ getLog.operateUrl }}</td>' +
        '<td>{{ getLog.operateBy }}</td>' +
        '</tr>',
    props: {
        getLog: {
            type: Object,
            default: {}
        }
    }
});
