(function () {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r!=null&&r.length >0) {
        alt = r[0]
        if(alt.equals(0)||alt===0){
            alert("验证码错误，请重新输入")
        }else if(alt.equals(1)||alt===1){
            alert("数据异常，请检查数据后再试");
        }
    }
    $(".sms").click(
        function () {
            $.post(
                "code",
                {
                    phone:this.form.phone.value
                },
                function (data) {
                    if (data==="true"){
                        var time = 60;
                        function timerdown() {
                            if (time!=0){
                                $(".sms").html(time+"s")
                                time--;
                                $(".phone").addClass("disabled")
                                $(".sms").addClass("disabled");
                            }else {
                                time = 60;
                                $(".sms").html("重新发送")
                                $(".remove").addClass("disabled")
                                $(".sms").removeClass("disabled");
                                return
                            }
                            setTimeout(function() {
                                timerdown();
                            },1000);
                        }
                        timerdown();
                    }else {
                        alert(data);
                    }
                }
            )
        }
    )

})();
