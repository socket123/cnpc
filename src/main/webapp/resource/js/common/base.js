/**
 * 公共组件js
 * 为每个组件页面提供公共js方法
 * @author 003598
 */

/**
 * 添加String的format方法 替换对应位置的字符串
 * 
 * @param array[] 数组
 */
String.prototype.format = function(array) {
	return this.replace(/\{(\d+)\}/g, function(s, i) {
		return array[i];
	});
};

/** 页面通用方法接口*/
var base ={
	/** form表单提交 */
	setAction : function(action, method, formId, target) {
		var actionHref = '';
		if(basePath==null||basePath==''){
			if(action.indexOf('/')==0){
				actionHref = action;
			}else{
				actionHref = "/" + action;
			}
		}else{
			actionHref = basePath + "/" +action;
		}
		method = method || "post";
		formId = "#" + (formId || "mainForm");
		target = target || "_self";
		$(formId).attr("action", actionHref).attr("method", method).attr("target",
				target).submit();
	},
	
	
	/** get提交*/
	getAction:function(action){
		if(basePath==null||basePath==''){
			if(action.indexOf('/')==0){
				window.location.href = action;
			}else{
				window.location.href = "/" + action;
			}
		}else{
			window.location.href= basePath + "/" +action;
		}
	},
	
	/** 验证input是否为空*/
	validInputNull: function($erroreDom){
		var flag = false;
		$('input:visible').each(function() {
			var _val = $(this).val();
			var _tip = $(this).attr('tip');
			if (!_val || '' === _val){
				$erroreDom.empty().append('<span>*</span><span>'+_tip+'</span>').show();
				flag = true;
				return false;
			}
		});
		return flag;
	},
	
	/** ajax公共方法 */
	AJAX_POST : function(action, data,type,callback,async) {
		var actionHref = '';
		if(basePath==null||basePath==''){
			if(action.indexOf('/')==0){
				actionHref = action;
			}else{
				actionHref = "/" + action;
			}
		}else{
			actionHref = basePath + "/" +action;
		}
		var dataObj = {};
		if (data){
			dataObj = data;
		}
		if(!type){
			type = 'json';
		}
		var as = async || true;
		if(async&&async=='false'){
			as = false;
		}else if(async&&async=='true'){
			as = true;
		}
		$.ajax({
			url : actionHref,
			data : dataObj,
			type : 'post',
			dataType : type,
			async : as,      // 取消异步请求
			beforeSend : function() {

			},
			success : function(o) {
				if (callback && $.isFunction(callback)) {

					callback(o);
				}
			},
			complete : function(XMLHttpRequest, textStatus) {

			},
			error : function() {

			}
			
		});
	},
	/**验证空值*/
	validateNull:function isNull(data){ 
		return (data == "" || data == undefined || data == null) ? true : false;
	},


	/** 验证手机号码*/
	vailNum:function(value){
		/** 手机号 */
		var strArray = [// 移动
		                '139', '138', '137', '136', '135', '134', '147', '150', '151', '152', '157', '158', '159', '182', '183', '184', '187', '188',
		                // 联通
		                '130', '131', '132', '155', '156', '185', '186', '145',
		                // 电信
		                '133', '153', '180', '181', '189', '177'];
		
		var mobile = new RegExp( '^(' + strArray.join('|') + ')\\d{8}$' ); 
		
		return mobile.test($.trim(value)); 
		
	},
	
};

var su = su || {};

su.leftMenu = {
	init: function(){
		this.page.init();
		this.btn.init();
	},
	
	page: {
		init: function(){
			this.menuActive();
		},
		
		menuActive: function(){
			var menuId = $('#menuId').val();
			
			$('.leftMenu li').each(function(){
			     var _this = $(this);
			     
			     var _menuId = _this.attr('menuId');
			     
			     if (menuId == _menuId){
			    	 _this.addClass('active');
			    	 var parentLi = _this.parents('li');
			    	 if (parentLi.size() > 0){
			    		 parentLi.addClass('active open');
			    	 }
			     }
			     
			});
		}
	},
	
	btn: {
		init: function(){
			this.exitLoginBtn();
			this.updatePwBtn();
		},
		
		exitLoginBtn: function(){
			$("#exitLogin").click(function(){
				var action = "eixtLogin.do";
				base.getAction(action);
			});
		},
		updatePwBtn:function(){
			$("#updatapw").click(function(){
				var action ="updatePwd.do";
				base.getAction(action);
			});
		}
	}
		
};




