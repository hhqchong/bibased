/**
 * Created by ljc on 2018/1/3.
 */
layui.config({
    base: Bm["path"] + '/static/js/'
});
layui.use(['paging', 'form'], function() {
    var $ = layui.jquery,
        paging = layui.paging(),
        layerTips = parent.layer === undefined ? layui.layer : parent.layer, //获取父窗口的layer对象
        layer = layui.layer, //获取当前窗口的layer对象
        form = layui.form();
    paging.init({
        openWait: true,
        url: Bm["path"] + '/static/datas/laytpl_laypage_data.json?v=' + new Date().getTime(), //地址
        elem: '#content', //内容容器
        params: { //发送到服务端的参数
        },
        type: 'GET',
        tempElem: '#tpl', //模块容器
        pageConfig: { //分页参数配置
            elem: '#paged', //分页容器
            pageSize: 5 //分页大小
        },
        success: function() { //渲染成功的回调
        },
        fail: function(msg) { //获取数据失败的回调
        },
        complate: function() { //完成的回调
            //重新渲染复选框
            form.render('checkbox');
            form.on('checkbox(allselector)', function(data) {
                var elem = data.elem;

                $('#content').children('tr').each(function() {
                    var $that = $(this);
                    //全选或反选
                    $that.children('td').eq(0).children('input[type=checkbox]')[0].checked = elem.checked;
                    form.render('checkbox');
                });
            });
        },
    });
});

