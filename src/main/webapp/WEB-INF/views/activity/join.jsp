<!-- 左侧组件 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<div class="page-header userList">
	<h1>
		活动参与
		</h1>

</div>

<div class="table-responsive topicList" id="Activity_table">

<table id="sample-table-2"
	class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>参与人</th>
			<th>参与人单位</th>
			<th>手机号</th>
			<th>参与时间</th>
			<th>邮箱</th>
			<th>报名人数</th>
			<th>是否已联系</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
	 <c:when test="${pages.dataList.size()>0}">
		<c:forEach items="${pages.dataList }" var="topic" varStatus="status">
			<tr>
			    <td  class="center">${status.count+(pages.currentIndex-1)*10}</td>
				<td>${topic.username}</td>
				<td>${topic.company}</td>
				<td>${topic.phone}</td>
				<td>${topic.jointime}</td>
				<td>${topic.email}</td>
				<td>${topic.number}人</td>
				<td>
					<c:if test="${empty topic.status }">
						<div
								class="visible-md visible-lg hidden-sm hidden-xs action-buttons stustus">
							<a name ="updateTopic" class="blue" href="#" data-id="${topic.id}" data-status="1">是</a>
						</div>

					</c:if>
					<c:if test="${not empty topic.status}">
						<div
								class="visible-md visible-lg hidden-sm hidden-xs action-buttons stustus">
							<a name ="updateTopics" class="red" href="#" data-id="${topic.id}" data-status=" ">否</a>
						</div>


					</c:if>

				</td>
			</tr>
		</c:forEach>
		</c:when>
			<c:otherwise>
				<tr>
					<td
						colspan="14"
						style="text-align: cente">未查到任何信息</td>
				</tr>

			</c:otherwise>
		</c:choose>
	</tbody>
</table>

	</div>
<script>
		$(function () {
//            $("[name=updateTopic]").click(function() {
			$(document).on("click","[name=updateTopic]",function(){
                var ActivityId = $(this).attr("data-id");
				var status=$(this).attr("data-status");
				console.log(status);
				console.log(ActivityId);
				var data={
				    id:ActivityId,
					status:status
				};
                console.log(JSON.stringify(data));
				var stustus  = $(this).parent();
                $.post("updateActivityJoin.do",data,function(dataObj){
						if(dataObj=="true"){
						    alert("操作成功");
							if(status == 1){
								stustus.empty();
								stustus.append('<a name ="updateTopics" class="red" href="#" data-id="'+ActivityId+'" data-status=" ">否</a>');

							}
						}
				});
            });
			$(document).on("click","[name=updateTopics]",function(){
//            $("[name=updateTopics]").click(function() {
                var ActivityId = $(this).attr("data-id");
				console.log(ActivityId);
                var status="";
                var data={
                    id:ActivityId,
                    status:status
                };
				var stustus  = $(this).parent();
                $.post("updateActivityJoin.do",data,function(dataObj){
                    if(dataObj=="true"){
                        alert("操作成功");
						if(status == ""){
							stustus.empty();
							stustus.append('<a name ="updateTopic" class="blue" href="#" data-id="'+ActivityId+'" data-status="1">是</a>');
						}
                    }
                });
            });

        });

</script>
