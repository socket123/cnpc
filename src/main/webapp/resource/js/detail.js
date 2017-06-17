/**
 * Created by James on 2016/10/30.
 */

var su =su||{};
su.detail={
    init:function(){
        this.btn.init();
    },
    btn:{
      init:function(){

      },
        changeFont:function(str){

            if(str==''||str==null||str==undefined){
                return;
            }else if(str=='zhong'){
                $(".xqeydiv2_pw>span").css("font-size","14px");

            }else if(str=="da"){
                $(".xqeydiv2_pw>span").css("font-size","20px");

            }else if(str=='xiao'){
                $(".xqeydiv2_pw>span").css("font-size","12px");

            }



        }

    }
};
