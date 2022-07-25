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
		
		$('#withdrawalBtnForMem').on("click", () => {
			this.withdrawalForMem();
		});
				
		$('#withdrawalBtnForAuthBiz').on("click", () => {
			this.withdrawalForAuthBiz();
		});
		
		
		let cancleApprovalBtn = $('button[name=cancleApprovalBtn]').on('click', function() {
			let idx = cancleApprovalBtn.index(this); // <- 변경된 코드
			// console.log(idx);
			// console.log($('button[name=cancleApprovalBtn]')[idx].value);
			index.cancleApproval($('button[name=cancleApprovalBtn]')[idx].value);
		});
		
		let approvalBtn = $('button[name=approvalBtn]').on('click', function() {
			let idx = approvalBtn.index(this); // <- 변경된 코드
			// console.log(idx);
			// console.log($('button[name=cancleApprovalBtn]')[idx].value);
			index.approval($('button[name=approvalBtn]')[idx].value);
		});
		
		
		$('#checkApprovalBtn').on("click", () => {
			this.checkApproval();
		});
		
		$('#adminReviewDeleteBtn').on("click", () => {
			this.checkAdminReviewDelete();
		});
		
		
		let cafeDeleteBtn = $('button[name=cafeDeleteBtn]').on('click', function() {
			let idx = cafeDeleteBtn.index(this); // <- 변경된 코드
			// console.log(idx);
			// console.log($('button[name=cancleApprovalBtn]')[idx].value);
			index.cafeDelete($('button[name=cafeDeleteBtn]')[idx].value);
		});
		
		$('#checkCafeDeleteBtn').on("click", () => {
			this.checkCafeDelete();
		});
		
		/*
		$('button[name=cancleApprovalBtn]').on("click", () => {
			this.cancleApproval(idx);
		});
		*/
		

		

			
		/* 이미지 클릭 이벤트
		$(document).on('click', 'img', () => {
			this.cancleApproval();
		});
		*/
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
		
		let page = {
			num: $("#num").val(),
			searchType: $("#searchType").val(),
			keyword: $("#keyword").val()
		}
		
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

	
	
	withdrawalForMem: function() {

		//빈 배열 선언 후 담아준다.
		let checkedMemChkArr = [];
		$("input[name=memChk]:checked").each(function(){
			let checkedMemChk = $(this).val();
		    checkedMemChkArr.push(checkedMemChk);
		    // console.log(checkedMemChk);
		})
		
		let page = {
			num: $("#num").val(),
			searchType: $("#searchType").val(),
			keyword: $("#keyword").val(),
			orderBy: $("#orderBy").val()
		}

		$.ajax({
			type: "DELETE",
			url: "/admin/withdrawalForMem",
			data: JSON.stringify(checkedMemChkArr), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			location.href = "/admin/adminMain?num=" + page.num + "&sort=member&searchType=" + page.searchType + "&keyword=" + page.keyword + "&orderBy=" + page.orderBy;
		}).fail(function(error) {
			// 실패한 경우 호출
			console.log(JSON.stringify(error));
		});
	},




	withdrawalForAuthBiz: function() {
	
		//빈 배열 선언 후 담아준다.
		let checkedAuthBizChkArr = [];
		$("input[name=memChk]:checked").each(function(){
			let checkedAuthBizChk = $(this).val();
		    checkedAuthBizChkArr.push(checkedAuthBizChk);
		    
		    // console.log(checkedAuthBizChk);
		})
		
		let page = {
			num: $("#num").val(),
			searchType: $("#searchType").val(),
			keyword: $("#keyword").val(),
			orderBy: $("#orderBy").val()
		}
		
		$.ajax({
			type: "DELETE",
			url: "/admin/withdrawalForAuthBiz",
			data: JSON.stringify(checkedAuthBizChkArr), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			location.href = "/admin/adminMain?num=" + page.num +"&sort=authBizMember&searchType=" + page.searchType + "&keyword=" + page.keyword + "&orderBy=" + page.orderBy;
		}).fail(function(error) {
			// 실패한 경우 호출
			console.log(JSON.stringify(error));
		});
	},
	
	
	
	cancleApproval: function(bid) {
		// console.log(bid);
		
		let data = {
			bid: bid
		}
		
		let page = {
			num: $("#num").val(),
			searchType: $("#searchType").val(),
			keyword: $("#keyword").val(),
			orderBy: $("#orderBy").val()
		}

		$.ajax({
			type: "PUT",
			url: "/admin/cancleApproval",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			location.href = "/admin/adminMain?num=" + page.num + "&sort=authBizMember&searchType=" + page.searchType + "&keyword=" + page.keyword + "&orderBy=" + page.orderBy;
		}).fail(function(error) {
			// 실패한 경우 호출
			console.log(JSON.stringify(error));
		});
	},
	
	
	
	
	approval: function(bid) {
		// console.log(bid);
		
		let data = {
			bid: bid
		}
		
		let page = {
			num: $("#num").val(),
			searchType: $("#searchType").val(),
			keyword: $("#keyword").val(),
			orderBy: $("#orderBy").val()
		}

		$.ajax({
			type: "PUT",
			url: "/admin/approval",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			location.href = "/admin/adminMain?num=" + page.num + "&sort=unauthBizMember&searchType=" + page.searchType + "&keyword=" + page.keyword + "&orderBy=" + page.orderBy;
		}).fail(function(error) {
			// 실패한 경우 호출
			console.log(JSON.stringify(error));
		});
	},
	
	
	
	checkApproval: function() {

		//빈 배열 선언 후 담아준다.
		let checkedApprovalArr= [];
		$("input[name=memChk]:checked").each(function(){
			let checkedApproval = $(this).val();
		    checkedApprovalArr.push(checkedApproval);
		   	// console.log(checkedApproval);
		})
		
		let page = {
			num: $("#num").val(),
			searchType: $("#searchType").val(),
			keyword: $("#keyword").val(),
			orderBy: $("#orderBy").val()
		}

		$.ajax({
			type: "PUT", // PUT 변경
			url: "/admin/checkApproval", // 컨트롤러도 PutMapping 변경
			data: JSON.stringify(checkedApprovalArr), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			location.href = "/admin/adminMain?num=" + page.num + "&sort=unauthBizMember&searchType=" + page.searchType + "&keyword=" + page.keyword + "&orderBy=" + page.orderBy;
		}).fail(function(error) {
			// 실패한 경우 호출
			console.log(JSON.stringify(error));
		});
	},
	
	
	
	checkAdminReviewDelete: function() {

		//빈 배열 선언 후 담아준다.
		let checkedAdminReviewDeleteArr= [];
		$("input[name=memChk]:checked").each(function(){
			let checkedAdminReviewDelete = $(this).val();
		    checkedAdminReviewDeleteArr.push(checkedAdminReviewDelete);
		   	// console.log(checkedAdminReviewDelete);
		})
		
		let data = {
			cno: $("#cno").val()
		};
		
		let page = {
			num: $("#num").val(),
			searchType: $("#searchType").val(),
			keyword: $("#keyword").val()
		}

		$.ajax({
			type: "DELETE", // delete로 변경 
			url: "/admin/adminReviewDelete", // 컨트롤러도 DeleteMapping 변경
			data: JSON.stringify(checkedAdminReviewDeleteArr), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			location.href = "/admin/adminReview/" + data.cno + "?num=" + page.num + "&searchType=" + page.searchType + "&keyword=" + page.keyword;
		}).fail(function(error) {
			// 실패한 경우 호출
			console.log(JSON.stringify(error));
		});
	},
	
	
	
	
	
	cafeDelete: function(cno) {
		// console.log(bid);
		
		let data = {
			cno: cno
		}
		
		let page = {
			num: $("#num").val(),
			searchType: $("#searchType").val(),
			keyword: $("#keyword").val()
		}

		$.ajax({
			type: "DELETE",
			url: "/admin/cafeDelete",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			location.href = "/admin/adminMain?num=" + page.num + "&sort=cafe&searchType=" + page.searchType + "&keyword=" + page.keyword;
		}).fail(function(error) {
			// 실패한 경우 호출
			console.log(JSON.stringify(error));
		});
	},
	
	
	
	
	
	
	checkCafeDelete: function() {

		//빈 배열 선언 후 담아준다.
		let checkedCafeDeleteArr= [];
		$("input[name=cafeChk]:checked").each(function(){
			let checkCafeDelete = $(this).val();
		    checkedCafeDeleteArr.push(checkCafeDelete);
		   	// console.log(checkedApproval);
		})
		
		let page = {
			num: $("#num").val(),
			searchType: $("#searchType").val(),
			keyword: $("#keyword").val()
		}

		$.ajax({
			type: "DELETE", // PUT 변경
			url: "/admin/checkCafeDelete", // 컨트롤러도 PutMapping 변경
			data: JSON.stringify(checkedCafeDeleteArr), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			location.href = "/admin/adminMain?num=" + page.num + "&sort=cafe&searchType=" + page.searchType + "&keyword=" + page.keyword;
		}).fail(function(error) {
			// 실패한 경우 호출
			console.log(JSON.stringify(error));
		});
	},
	
}

index.init();









