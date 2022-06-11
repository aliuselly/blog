// 血的教训，template 不能有两个父标签，只能有一个父标签，另外一个是渲染不出来的，因此，得包含
Vue.component('custom-footer', {
    template: '<div style="clear: both">' +
        '<nav id="foot">' +
        '   <div id="leftContent">' +
        '       <span>Email: aliuselly@gmail.com</span>' +
        '       <span>明日复明日，</span>' +
        '       <span>明日何其多。</span>' +
        '   </div>' +
        '   <div id="rightContent">' +
        '       <div id="footIcon">' +
        '           <img id="footLogo" src="../img/blog-logo.jpg">' +
        '       </div>' +
        '       <div id="copyright">' +
        '           CopyRight@aliuselly,DesignBy@_Nic,2022' +
        '       </div>' +
        '   </div>' +
        '</nav>' +
        '</div>'
});
