var websocket;
if ('WebSocket' in window) {
    websocket = new WebSocket('ws://127.0.0.1:9988/sell/websocket');
} else {
    alert("你的浏览器暂不支持websocket,请更换其他浏览器再试");
}

websocket.onopen = function (event) {
    console.log("建立连接");
};
websocket.onclose = function (event) {
    console.log("关闭连接");
};
websocket.onmessage = function (event) {
    console.log("收到消息," + event.data);
    // 弹窗提示与播放提示音乐
    setTimeout(function () {
        document.getElementById('notice').play();
    },1000);
    $("#orderModal").modal('show');
};
websocket.onerror = function (event) {
    console.log("websocket异常");
};
/**
 * readyState状态如下:
 * CONNECTING：值为0，表示正在连接；
 OPEN：值为1，表示连接成功，可以通信了；
 CLOSING：值为2，表示连接正在关闭；
 CLOSED：值为3，表示连接已经关闭，或者打开连接失败。
 */

// 向服务端发送消息(必须为open状态时可发送)
if (websocket.readyState === 1) {
    websocket.send("服务端你好");
}