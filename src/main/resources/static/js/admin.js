let index = {
	init: function() {
	
		/* 관리자 
		
		$('#member').attr("checked", () => {
			this.member();
		});
		
		$('#member').on("click", () => {
			this.member();
		});
		
		$('#biz').on("click", () => {
			this.biz();
		});
		*/
	
	},

	member: function() {
		
		let data = {
			sort: $("#member").val() 
		};
		
		$.ajax({
			type: "POST",
			url: "/admin/memberManagement",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			let htmls;
			
			if(JSON.stringify(resp).length>0){
				 $(resp).each(function(index){
						htmls += "<tr>";
						htmls += "<td><input class='form-check-input mt-0' name='memChk' type='checkbox' value=''></td>";
						htmls += "<td>"+(index+1)+"</td>";
						htmls += "<td>"+this.username+"</td>";
						htmls += "<td>"+this.name+"</td>";
						htmls += "<td>"+this.phone+"</td>";
						htmls += "<td>"+this.email+"</td>";
						htmls += "<td>"+this.role+"</td>";
						htmls += "</tr>"
				});
				
			};
			$("#htmls").html(htmls);
			
		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
	},
	
	biz: function() {
				
		let data = {
			sort: $("#biz").val() 
		};
		
		$.ajax({
			type: "POST",
			url: "/admin/bizMemberManagement",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			let htmls;
			
			if(JSON.stringify(resp).length>0){
				 $(resp).each(function(index){
						htmls += "<tr>"
						htmls += "<td><input class='form-check-input mt-0' name='memChk' type='checkbox' value=''></td>";
						htmls += "<td>"+(index+1)+"</td>";
						htmls += "<td>"+this.bid+"</td>";
						htmls += "<td>"+this.bname+"</td>";
						htmls += "<td>"+this.bphone+"</td>";
						htmls += "<td>"+this.bemail+"</td>";
						htmls += "<td>사업자</td>";
						htmls += "</tr>"
				});
				
			};
			$("#htmls").html(htmls);
			
		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
	},

}

index.init();









