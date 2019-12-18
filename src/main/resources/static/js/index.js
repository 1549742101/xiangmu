// JavaScript Document
(function () {
    let banner_img=$(".banner_ul>li");
    let banner_ol = $(".banner_ol>li");
    let banner=$(".banner_on>li");
    let index;
    let ban=setInterval(BannerF,6000);
    banner.click(function () {
        clearInterval(ban);
        index = banner.index(this);
        banner_ol.removeClass("active");
        banner_img.removeClass("active");
        banner.removeClass("active");
        $(this).addClass("active");
        banner_img[index].className='active';
        banner_ol[index].className='active';
        ban=setInterval(BannerF,6000);
    })
    function BannerF() {
        banner_ol.removeClass("active");
        banner_img.removeClass("active");
        banner.removeClass("active");
        if (index<3){
            index++;
            banner[index].className='active';
            banner_img[index].className='active';
            banner_ol[index].className='active';
        }else{
            index=0;
            banner[index].className='active';
            banner_img[index].className='active';
            banner_ol[index].className='active';
        }
    }

    function getBanner() {
        let src;
        let newSrc;
        let nullSrc = "api/img"
        $.ajax(
           {
               url:'getBanner',
               dataType : "json",//数据格式
               type : "post",//请求方式
               async : false,//是否异步请求
               success : function(data) {   //如果请求成功，返回数据。
                   for (let i=0;i<4;i++){
                       src=$(banner_img[i]).find("img")
                       newSrc ="api/img/"+data[i].img.filename
                       if (nullSrc!=newSrc){
                           src.attr("src",newSrc);
                           $(banner_ol[i]).find("p").html(data[i].text)
                       }
                   }
               }
           }
        )
    }
    getBanner()
    $(".flash").click(function () {
        getBanner();
    })
})();