// JavaScript Document


function sign_in() {
		alert("已点击按钮");
		let Username = $.trim($("#Username").val());
		let Password = $.trim($("#Password").val());
		var curPageUrl = window.document.location.href;
		var rootPath = curPageUrl.split("//")[0] + curPageUrl.split("//")[1].split("/")[0] + "/" + curPageUrl.split("//")[1].split("/")[1];




	$.ajax({
		type:"POST", // 使用post方式

		// 志愿者报名
		url:"/login",
		contentType:"application/json",


		data:JSON.stringify({
			"status": "0",
			"message": "volunteerSend",
				"content": [
					{
						"id": "UserName",
						"value":Username
					},
					{
						"id": "Password",
						"value":Password
					},

				]

		}),


		dataType:"json",
		async:false,
		success: function(result){
			// 请求成功后的操作
			if (result.successvalue == "1"){
				alert("登录成功");
				window.location.href = "index.html";
			}
			else{
				alert("用户名或密码错误");
				//location.href = "pages-login.html";
			}
		},

		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert("插入数据失败,请检查数据库链接");
			//alert(textStatus);
		}
	});
}
