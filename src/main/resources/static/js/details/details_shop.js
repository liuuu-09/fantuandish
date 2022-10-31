// 点击地址显示地图div
document.querySelector(".dingwei").onclick=function(){
    document.querySelector(".map").style.display = "block";
    document.querySelector(".cover").style.display = "block";
    document.querySelector(".cover").style.height = document.body.scrollHeight +'px';
}
document.querySelector(".closemap").onclick=function(){
    document.querySelector(".map").style.display = "";
    document.querySelector(".cover").style.display = "";
}
var onclicktime = 0;
document.querySelector(".collect").onclick=function(){
    if(onclicktime % 2 == 0){
        document.querySelector(".collect").firstChild.style.backgroundImage = "url(https://zhangxu-1023.oss-cn-nanjing.aliyuncs.com/images/details_shop/2022-10-20/82a76dec10f94b98846b487e8e766b26shop-collect-after.svg)";
        document.querySelector(".collect-info").innerText = "已收藏";
    }
    if(onclicktime % 2 == 1){
        document.querySelector(".collect").firstChild.style.backgroundImage = "url(images/details_shop/2022-10-20/0c33e04baf2d42a88d794b423fa6fab5shop-collect-before.svg)";
        document.querySelector(".collect-info").innerText = "收藏";
    }
    onclicktime++;
}
// 店铺轮播图
layui.use(['carousel', 'form'], function () {
    var carousel = layui.carousel
        , form = layui.form;

    var ins3 = carousel.render({
        elem: '#test3'
        , width: '336.4px'
        , height: '260px'
    });
})
// 店铺地图定位
var longitude = document.querySelector(".longitude").value;
var latitude = document.querySelector(".latitude").value;
console.log(longitude)
console.log(latitude)
var map = new AMap.Map('container', {
    zoom:20, //初始化地图层级
    center: [longitude,latitude] //初始化地图中心点
});
// 定位图标
var marker = new AMap.Marker({ 
    map: map,
    position: [longitude,latitude],
    icon: '../images/map-location-icon.png' ,
    offset: new AMap.Pixel(-13, -30)
});
