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
		
		$('#authBizMember').on("click", () => {
			this.authBizMember();
		});
		
		$('#unauthBizMember').on("click", () => {
			this.unauthBizMember();
		});
		
		$('#cafeBtn').on("click", () => {
			this.cafeListPage();
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
			// 성공한 경우 호출
			$('#member').prop("checked", true);
			location.href = "/admin/adminMain?num=1&sort=member";
		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
	},
	
	authBizMember: function() {
				
		let data = {
			sort: $("#authBizMember").val(),
			num: $("#num").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/admin/authBizMemberManagement",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			$('#authBizMember').prop("checked", true);
			location.href = "/admin/adminMain?num=1&sort=authBizMember";
		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
	},
	
	unauthBizMember: function() {
				
		let data = {
			sort: $("#unauthBizMember").val(),
			num: $("#num").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/admin/unauthBizMemberManagement",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			$('#unauthBizMember').prop("checked", true);
			location.href = "/admin/adminMain?num=1&sort=unauthBizMember";
		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
	},

	cafeListPage: function() {
				
		let data = {
			sort: $("#cafe").val(),
			num: $("#num").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/admin/cafeManagement",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			location.href = "/admin/adminMain?num=1&sort=cafe";
		}).fail(function(error) {
			// 실패한 경우 호출
			console.log(JSON.stringify(error));
		});
	},
	

}

index.init();









