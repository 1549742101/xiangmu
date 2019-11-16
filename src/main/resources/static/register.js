(function () {
    $(".reg").click(
        function () {
            var username=this.form.username.value;
            var password1=this.form.password1.value;
            var pPattern = /^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)(?!([^(0-9a-zA-Z)])+$).{6,20}$/;
            var password2=this.form.password2.value;
            var sno=this.form.sno.value;
            var posPattern = /^\d+$/;
            var code=this.form.code.value;
            var phone=this.form.phone.value;
            var college=this.form.college.value;
            function f1(){
                $(".sno").click(function () {
                    $(".snomsg").addClass("hide");
                });
                if (!(posPattern.test(sno))||sno.length!=9){
                    $(".snomsg").removeClass("hide");
                    return;
                }
            }
            function f2(){
                $(".username").click(function () {
                    $(".unamemsg").addClass("hide");
                });
                if (username.length<6||username.length>20){
                    $(".unamemsg").removeClass("hide");
                    return;
                }
            }
            function f3(){
                $(".password1").click(function () {
                    $(".pwd1msg").addClass("hide");
                });
                if (!(pPattern.test(password1))){
                    $(".pwd1msg").removeClass("hide");
                    return;
                }
            }
            function f4(){
                $(".password2").click(function () {
                    $(".pwd2msg").addClass("hide");
                });
                if (password1!=password2){
                    $(".pwd2msg").removeClass("hide");
                    return;
                }
            }
            function f5(){
                $(".college").click(function () {
                    $(".colmsg").addClass("hide");
                });
                if (college==null||college==""){
                    $(".colmsg").removeClass("hide");
                    return;
                }
            }
            function f6(){
                $(".phone").click(function () {
                    $(".phomsg").addClass("hide");
                });
                if (phone.length!=11){
                    $(".phomsg").removeClass("hide")
                    return;
                }
            }
            function f7(){
                $(".code").click(function () {
                    $(".codemsg").addClass("hide");
                });
                if (code.length!=6){
                    $(".codemsg").removeClass("hide")
                    return;
                }
            }
            f1();f2();f3();f5();f5();f6();f7();
            $.post(
                this.form.action,
                {
                    username:username,
                    password1:password1,
                    password2:password2,
                    sno:sno,
                    code:code,
                    phone:phone,
                    college:college
                },
                function (data) {
                    if (data!="f0")
                        alert("数据不合法，请检查后重试")
                    else {
                        $(location).attr('href', '/index');
                    }
                }
            )
        }
    )
    $(".sms").click(
        function () {
            $(".phone").click(function () {
                $(".phomsg").addClass("hide");
            });
            if (this.form.phone.value.length!=11){
                $(".phomsg").removeClass("hide")
                return;
            }
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
                                $(".sms").addClass("disabled");
                            }else {
                                time = 60;
                                $(".sms").html("重新发送")
                                $(".sms").removeClass("disabled");
                                return
                            }
                            setTimeout(function() {
                                timerdown();
                            },1000);
                        }
                        timerdown();
                    }
                }
            )
        }
    )

})();
