<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<script src="${base}/resource/js/banner.js"></script>
<script src="${base}/resource/js/plupload/plupload.full.min.js"></script>
<script type="text/javascript" src="${base}/resource/js/plupload/i18n/zh_CN.js"></script>
<style>
.progress{ height: 4px; font-size: 0; line-height: 4px; background: orange; width: 0;}
.bar {background-color: green; display:block; width:0%; height:15px; }
.percent{position:absolute; height:15px; top:-18px; text-align:center; display:inline-block; left:0px; width:80px; color:#666; line-height:15px; font-size:12px; }
#file-list{ }
#file-list li{ margin-bottom: 10px;}
.file-name{ line-height: 30px;}
.error{
color:red;
}
</style>

<div class="page-header userList">
	<h1>
		<c:choose>
			<c:when test="${topic.id == null || topic.id =='' }">
				新增图片
			</c:when>
			<c:otherwise>
				修改图片
			</c:otherwise>
		</c:choose>
	</h1>

</div>
<div class="row">
	<div class="col-xs-12">
		<form class="form-horizontal">
		
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-2">图片名称
				</label>
				<div class="col-sm-9">
					<input type="text" value="${topic.name}" id="name" name="name"
						placeholder="请输入名称"
						class="col-xs-10 col-sm-5"> <span
						class="help-inline col-xs-12 col-sm-7"> <span
						class="middle"></span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					   for="form-field-2">上传： </label>
				<div class="col-sm-9">
					<!--    <input id="fileToUpload" style="display: none" type="file" name="upfile" /><br />
                        <img id="upload" alt="点击此处上传图片" height=200 width=347 src="" />
                        <input  type="hidden" value="" name="image" /> -->
					<span id="browsebtn">
                 <input type="button" value="选择图片" class="btn btn-success" id="browse" /></span>
					<ul id="file-list" style="list-style-type:none;margin-top: 10px;"></ul>
					<input type="hidden" id="image" value="">
				</div>
			</div>

			<input id="id" name="id" type="hidden" value="${topic.id}" />
			<input id="type" name="type" value="${type}" type="hidden"/>
			<div class="col-md-offset-3 col-md-9">
				<button class="btn btn-info" type="button" id="saveTopic" name="saveTopic">
					<i class="icon-ok bigger-110"></i>
					保存
				</button>
				&nbsp; &nbsp; &nbsp;
				<button class="btn" type="button" name="cancel">
					<i class="icon-undo bigger-110"></i>
					取消
				</button>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">
	$(function() {
		var uploader = new plupload.Uploader({ //实例化一个plupload上传对象
			browse_button : 'browse',
			url : '../file/web/upload.do',
			multi_selection:false,
			chunk_size : '1mb',
			flash_swf_url : '../js/plupload/Moxie.swf',
			silverlight_xap_url : '../js/plupload/Moxie.xap',
			filters : {
				// Maximum file size
				max_file_size : '30mb',
				// Specify what files to browse for
				mime_types: [
					{title : "图片", extensions : "jpg,jpeg,png,gif,bmp"},
				],
			},
		});
		uploader.init(); //初始化
		var max_files = 1;
		//绑定文件添加进队列事件
		uploader.bind('FilesAdded',function(uploader,files){
			$("#file-list").empty();
			for(var i = 0, len = files.length; i<len; i++){
				var file_name = files[i].name; //文件名
				//构造html来更新UI
				var html = '<li id="file-' + files[i].id +'"><p class="file-name">' + file_name + '<span id="procount" style=" color: #1ABC9C; "></span></p><p class="progress"></p></li>';
				$(html).appendTo('#file-list');
				if (uploader.files.length >= 1) {
					uploader.start();
				}
			}
		});


		//绑定文件上传进度事件
		uploader.bind('UploadProgress',function(uploader,file){
			$('#procount').html("("+file.percent + '%)');
			$('#file-'+file.id+' .progress').css('width',file.percent + '%');//控制进度条
		});

		uploader.bind('FileUploaded',function(uploader,file,responseObject){
			var re = JSON.parse(responseObject.response);
			$("#image").val(re.filename);
		});
		su.Banner.addTopic.init();
	});
</script>