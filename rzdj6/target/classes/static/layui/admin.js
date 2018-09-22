$(function(){
    // layer.msg('hello');
    // layer.open({
    //     type: 1,
    //     content: '传入任意的文本或html' //这里content是一个普通的String
    // });
    // layer.open({
    //     type: 2,
    //     content: 'http://www.baidu.com' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
    // });
    // layer.alert('酷毙了', {icon: 1});
    // // layer.open({
    // //     type: 4,
    // //     content: ['5215145155', '#box1'] //数组第二项即吸附元素选择器或者DOM
    // // });
    // layer.confirm('纳尼？', {
    //     closeBtn:1,
    //     btn: ['按钮一', '按钮二', '按钮三'] //可以无限个按钮
    //     ,btn3: function(index, layero){
    //         layer.alert('酷毙了1', {icon: 1});
    //     }
    // }, function(index, layero){
    //      layer.alert('酷毙了2', {icon: 2});
    // }, function(index){
    //      layer.alert('酷毙了3', {icon: 3});
    // });
    //
    // //例子2输入框
    // layer.prompt({
    //     formType: 2,
    //     value: '初始值',
    //     title: '请输入值',
    //     area: ['800px', '350px'] //自定义文本域宽高
    // }, function(value, index, elem){
    //     alert(value); //得到value
    //     layer.close(index);
    // });
    // //tab
    // layer.tab({
    //     area: ['600px', '300px'],
    //     tab: [{
    //         title: 'TAB1',
    //         content: '内容1'
    //     }, {
    //         title: 'TAB2',
    //         content: '内容2'
    //     }, {
    //         title: 'TAB3',
    //         content: '内容3'
    //     }]
    // });
    //
    // //通过这种方式弹出的层，每当它被选择，就会置顶。
    // layer.open({
    //     type: 2,
    //     shade: false,
    //     area: '500px',
    //     maxmin: true,
    //     content: 'http://www.layui.com',
    //     zIndex: layer.zIndex, //重点1
    //     success: function(layero){
    //         layer.setTop(layero); //重点2
    //     }
    // });

    // layer.open({
    //     type: 2,
    //     content: 'http://www.layui.com',
    //     success: function(layero, index){
    //         var body = layer.getChildFrame('body', index);
    //         var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
    //         console.log(body.html()) //得到iframe页的body内容
    //         body.find('input').val('Hi，我是从父页来的')
    //     }
    // });

    //eg1
//     layer.tips('只想提示地精准些', '#box1');
// //eg 2
//     $('#box1').on('click', function(){
//         var that = this;
//         layer.tips('只想提示地精准些', that); //在元素的事件回调体中，follow直接赋予this即可
//     });
// //eg 3
//     layer.tips('在上面', '#box1', {
//         tips: 1
//     });
//
//     //eg1
//     layer.confirm('is not?', {icon: 3, title:'提示'}, function(index){
//         //do something
//
//         layer.close(index);
//     });


})