// JavaScript Document
(function () {
    var banner_img=$(".banner_ul>li");
    var banner_ol=$(".banner_ol>li");
    var banner=$(".banner_on>li");
    var index;
    banner.click(function () {
        index = banner.index(this);
        banner_ol.removeClass("active");
        banner_img.removeClass("active");
        banner.removeClass("active");
        $(this).addClass("active");
        banner_img[index].className='active';
        banner_ol[index].className='active';
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
    setInterval(BannerF,3000)
})();