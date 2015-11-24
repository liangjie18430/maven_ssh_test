/**login.jsp相关的js
 * 项目名称 ：hbaudit
 * @author ：angenimy
 * @date   ：2014-4-19
 * @company: WHU
 * @e-mail ：angenimy@whu.edu.cn
 */
// 登录框与注册框的 
var wrapperPos 	  	 = 1;
var left1 		  	 = 80;
var left2 		  	 = 0;
var left_start    	 = 0;
var animDone 	  	 = true;
var wrapperTop    	 = 0;
var issamepwflag  	 = false;
var usernotexistflag = false;
var answer           = false;
var tabIndex 		 = 1;		// 控制tab键，避免出现bug
// 修复Tab键bug
document.onkeydown=function(){
	if(event.keyCode==9){
		if(tabIndex==4){
			var cc = document.getElementById("username");
			cc.focus();
			event.keyCode=0;   
			event.returnValue=false;
		    return false;
		}
		else if(tabIndex==11){
			var cc = document.getElementById("register_username");
			cc.focus();
			event.keyCode=5;   
			event.returnValue=false;
		    return false;
		}
	}
};
$(document).ready(function(){
	var mHeight =	document.body.offsetHeight;						// 可见区域的高度
	var mWidth  =	document.body.offsetWidth ;						// 可见区域的宽度
	var IEVersion = getIEVersion();
	if(IEVersion==8){
		if(mHeight<=568){									// 768 = 95(浏览器工具条高度)+673 
			mHeight=673;
		}
		if(mWidth<=1000){
			mWidth=1000;
		}
		mHeight = mHeight - 4;
	}else if(IEVersion<8){
		layer.alert("您的IE版本过低,建议升级到IE8及以上版本，以便于更好的浏览！");
	}else{
		if(mHeight<=568){									// 768 = 95(浏览器工具条高度)+673 
			mHeight=673;
		}
		if(mWidth<=1000){
			mWidth=1000;
		}
	}
	// 页面自适应----start
	$(".Body_Content").height(mHeight);
	$(".Body_Content").width(mWidth);
	$(".background").width(mWidth);
	$(".background").height(mHeight-57);
	$(".left_content_bg").height(mHeight-57);
	$(".center_Div").height(mHeight-57);
	$(".left").height(mHeight-57);
	$(".left_content").height(mHeight-57);
	$(".left_mask").height(mHeight-57);
	$(".left_mask").width(mWidth/2-400);
	$(".left_div").css({top:(mHeight-57-350)/2+"px"});
	$(".right").height(mHeight-57);
	// 兼容不同浏览器
	if(IEVersion<=8){
		left1 = -500;
	}else{
		left1 = 200;
	}
	$(".button2to1").css({left:mWidth-150+"px"});
	$("#wrapper1").css({left:mWidth/2+"px",top:(mHeight-57-350)/2+"px"});
	$("#wrapper2").css({left:mWidth+"px",top:(mHeight-57-350)/2+"px"});
	$("#getPassword").css({left:(mWidth-880)/2+40+"px",top:(mHeight-500)/2});
	// 网页自适应----end
	//$('#register_password').passwordStrength();
	//checkIntensity("");
	left_start  = mWidth;
	left2 		= left1- mWidth/2;
	wrapperTop  = 0;	
	$('#place').css({left:left_start+"px",top:wrapperTop+"px"});
	animDone = false;
	$('#place').animate({left: left1},1000,'circEaseOut',function() {
		animDone = true;
		wrapperPos = 1;
	});
	$('.button2to1').hide();
});
window.onresize=function(){
	window.location.reload();
}
window.onload= function(){
	$(".Body_Content").show();
}
function buttonhover(){
	$(".getPassword_close").addClass("getPassword_close_hover");
}
function buttonout(){
	$(".getPassword_close").removeClass("getPassword_close_hover");
}
function hover_button(){
	$(".button2to1").addClass("button2to1_hover");
}
function out_button(){
	$(".button2to1").removeClass("button2to1_hover");
}
//密码输入相同验证
function issamepassword(flag,num){
	$("#issamepassword").hide();
	$("#notsamepassword").hide();
	issamepwflag = false;
	if(flag==1){
		var pw1 =  $("#register_password").val();
		var pw2 =  $("#register_password_ok").val();
		if(pw2!=""&&pw1!=""){
			if(pw2!=pw1){
				$("#notsamepassword").show();
			}else{
				$("#issamepassword").show();
				issamepwflag = true;
			}
		}else{
			return false;
		}	
	}else{
		tabIndex = num;
	}
}
//注册表单验证----用户注册
function register_validate(){
	if(issamepwflag&&usernotexistflag&&answer){
		var register_username = $("#register_username").val();
		var register_password = $("#register_password").val();
		$.ajax({
			url: "user/login!register_user.action",
			type : "post",
			dataType : "json",
			cache : false,
			async: true,
			data:{
				userName:register_username,
				passWord:register_password
				},
			beforeSend:function(){
				$("#loading").show();
			},
			success:function(json){
				$("#loading").hide();
				if(json=="success"){
					var index = $.layer({
					    shade: [0],
					    area: ['auto','auto'],
					    dialog: {
					        msg: '用户注册成功',
					        btns: 2,                    
					        type: 1,
					        btn: ['确定','取消'],
					        yes: function(){
								layer.close(index);
								anim2to1();
					        }, no: function(){
					            
					        }
					    }
					});
				}else{
					$("#loading").hide();
					layer.alert("用户注册失败,请检查注册信息!");	
				}
			},			
			error:function(){
				layer.alert("网络不畅，请稍后再试！");		
			}
		});
	}else{
		layer.alert("请检查注册信息!");	
		return false;
	}
}
// 获得IE版本
function getIEVersion(){
	var userAgent = window.navigator.userAgent.toLowerCase();
	var version   = (userAgent.match(/(?:rv|it|ra|ie)[\/: ]([\d.]+)/ ) || [0,'0'])[1];
	if(version.indexOf(".")>0){
		version = version.substring(0,version.indexOf("."));
	}
	var Int_IEVersion = parseInt(version);
	return version;
}
function anim1to2(){
	animDone = false;
	$('#place').animate({left: left2},1000,'circEaseOut',function() {
		animDone = true;
		wrapperPos = 2;
		var focusNode = document.getElementById("register_username");
		focusNode.focus();
	});
	$('.button2to1').show();
	/*register_reset();*/
};
function anim2to1(){
	animDone = false;
	$('#place').animate({left: left1},1000,'circEaseOut',function() {
		animDone = true;
		wrapperPos = 1;
		var focusNode = document.getElementById("username");
		focusNode.focus();
	});
	$("#username").val("");
	$("#password").val("");
};
// 捕获回车键
function isEnterkey(){
	var e = event?event:window.event;
	if(e.keyCode == 13){
		validate_form();
	}
}
// 前台验证
function validate_form(){
	loadOn();
	/*var username = $("#username").val();
	var password = $("#password").val();
	if(username!=null&&username!=""&&password!=null&&password!=""){
		validateUser(username,password);
	}
	else if(username==null||username==""){
		$("#login_result").show();
		$("#login_result").text("用户名为空!");
	}
	else if(password==null||password==""){
		$("#login_result").show();
		$("#login_result").text("密码为空!");
	}
	return false;*/
}
function settabIndex(num){
	tabIndex = num;
}