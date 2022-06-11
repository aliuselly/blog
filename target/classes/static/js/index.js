// 页面初始化：填充数据
window.onload = function() {
    new Vue({
        el: '#smallPictures',
        data: {
            articlePictureDto: {
                pictureUrl: '',
                articleId: '',
                title: '',
                summary: ''
            }
        }
    });
}

new Vue({
    el: '#showArticle',
    data: {
        articleId: '',
        url: ''
    }
});
