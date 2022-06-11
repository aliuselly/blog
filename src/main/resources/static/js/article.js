Vue.component('div-comment', {
    template: '<div class="comment">' +
        '   <label class="commentName" v-text="comment.name"></label>' +
        '   <label class="commentTime" v-text="comment.createBy"></label>' +
        '   <br>' +
        '   <label class="commentContent" v-text="comment.content"></label>' +
        '</div>',
    props: {
        comment: {
            type: Object,
            default: {}
        }
    }
});
