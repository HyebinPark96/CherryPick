let index = {
	init: function() {
	
		/* 관리자 
		
		$('#member').attr("checked", () => {
			this.member();
		});
		
		*/
		
		$('#member').on("click", () => {
			this.member();
		});
		
		$('#bizMember').on("click", () => {
			this.bizMember();
		});
		
	
	},

	member: function() {
		
		let data = {
			sort: $("#member").val(),
			num: $("#num").val()
		};

		$.ajax({
			type: "POST",
			url: "/admin/memberManagement",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			/*
			// 성공한 경우 호출
			let htmls;
			
			if(JSON.stringify(resp).length>0){ // resp : HashMap(String, Object) 타입의 lists(list, page, select)반환
				 $(resp.list).each(function(){
						// htmls += "<tr th:each='list : ${list}'>";
						htmls += "<td><input class='form-check-input mt-0' name='memChk' type='checkbox' value=''></td>";
						// htmls += "<td th:text='${listStat.count + (page.num*10) - 10}'></td>";
						htmls += "<td th:text='${list.username}'></td>";
						htmls += "<td th:text='${list.name}'>random</td>";
						htmls += "<td th:text='${list.phone}'>data</td>";
						htmls += "<td th:text='${list.email}'>placeholder</td>";
						htmls += "<td th:if='${list.role}==0'>회원</td>";
						htmls += "<td th:if='${list.role}==1'>관리자</td>";
						// htmls += "</tr>";	
				});
			};
			$("#htmls").html(htmls);
			*/
			$('#member').prop("checked", true);
			location.href = "/admin/adminMain?num=1&sort=member";
		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
	},
	
	bizMember: function() {
				
		let data = {
			sort: $("#bizMember").val(),
			num: $("#num").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/admin/bizMemberManagement",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			/*
			// 성공한 경우 호출
			let htmls;
			
			if(JSON.stringify(resp).length>0){
				 $(resp).each(function(index){ // resp : bizMemberList
						htmls += "<tr th:each='list : ${list}'>";
						htmls += "<td><input class='form-check-input mt-0' name='memChk' type='checkbox' value=''></td>";
						htmls += "<td th:text='${listStat.count + (page.num*10) - 10}'></td>";
						htmls += "<td th:text='${list.bid}'></td>";
						htmls += "<td th:text='${list.bname}'>random</td>";
						htmls += "<td th:text='${list.bphone}'>data</td>";
						htmls += "<td th:text='${list.bemail}'>placeholder</td>";
						htmls += "<td>사업자</td>";
						htmls += "</tr>";	
				});
				
			};
			$("#htmls").html(htmls);
			*/
			$('#bizMember').prop("checked", true);
			location.href = "/admin/adminMain?num=1&sort=bizMember";
		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
	},

}

index.init();









