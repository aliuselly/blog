// 血的教训，貌似咱们这里没有支持那些 ES6 啥的，支持，但不完全，比如 export 这些就不行，但 let const 可以
Vue.component('custom-header', {
    template: "<nav id='top'>" +
        "            <span id='logo' style='float: left; margin-left: 10px' v-on:click='switchShow'>" +
        // "                <img src='img/blog-logo.jpg'>" +
                        "{{ shehuizhuyiwoaini }}" +
        "            </span>" +
        "            <a href='/index.html'>首页</a>" +
        "            <a href='/blog.html'>博客</a>" +
        "            <a href='/about.html'>关于</a>" +
        "            <span id='time' style='float: right; margin-right: 10px'>{{ currentDate }} </span>" +
        "        </nav>",
    data: function ()
    {
        return {
            currentDate: '',
            index: 0,
            jiazhiguan: [
                "富强 | 民主 | 文明 | 和谐",
                "自由 | 平等 | 公平 | 法治",
                "爱国 | 敬业 | 诚信 | 友善"
            ]
        }
    },
    computed: {
        shehuizhuyiwoaini() {
            return this.jiazhiguan[this.index];
        }
    },
    methods: {
        switchShow() {
            this.index = (this.index + 1 == this.jiazhiguan.length ? 0 : this.index + 1);
        },
        getCurrentDate: function () {
            let d = new Date();
            let week;
            switch(d.getDay())
            {
                case 1:
                    week = '星期一';
                    break;
                case 2:
                    week = '星期二';
                    break;
                case 3:
                    week = '星期三';
                    break;
                case 4:
                    week = '星期四';
                    break;
                case 5:
                    week = '星期五';
                    break;
                case 6:
                    week = '星期六';
                    break;
                default :
                    week = '星期天';
            }
            let year = d.getFullYear();
            let month = this.add_zero(d.getMonth() + 1);
            let day = this.add_zero(d.getDate());
            let hour = this.add_zero(d.getHours());
            let minute = this.add_zero(d.getMinutes());
            let second = this.add_zero(d.getSeconds());

            this.currentDate = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + " " + week;
        },
        add_zero: function (temp) {
            return temp < 10 ? ('0' + temp) : temp;
        },
        showDate: function() {
            setInterval(this.getCurrentDate, 1000);
            this.clearDate()
        },
        clearDate: function() {
            clearInterval(this.getCurrentDate);
            this.getCurrentDate = null;
        }
    },
    created() {
        // 解决要等待一秒后才响应的方式
        this.getCurrentDate();
        this.showDate();
    }
});
