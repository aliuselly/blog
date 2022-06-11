Vue.component('about-comment', {
    template: '<div v-bind:class="{comment: currentIndex != (totalSize - 1)}">' +
        '   <label class="commentName" v-text="comment.name"></label>' +
        '   <label class="commentTime" v-text="comment.createBy"></label>' +
        '   <br>' +
        '   <label class="commentContent" v-text="comment.content"></label>' +
        '</div>',
    props: {
        comment: {
            type: Object,
            default: {}
        },
        totalSize: {
            type: Number,
            default: 0
        },
        currentIndex: {
            type: Number,
            default: 0
        }
    }
});
