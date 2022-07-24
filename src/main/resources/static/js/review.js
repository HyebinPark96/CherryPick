let review = {
	init: function() {
		
		$('#reviewWriteBtn').on("click", () => {
			this.reviewWrite();
		});
		
		$('#reviewUpdateBtn').on("click", () => {
			this.reviewUpdate();
		});
	
	
	},

	reviewWrite: function() {
		
		var waitingValue = parseInt($("#waiting").val());
		
		let data = {
			username: $("#username").val(),
			title: $("#title").val(),
			content: $('#content').summernote('code'), // 태그나 문자열 따질 것 없이 전부 가져온다.
			score: $("#score").val(),
			waiting: waitingValue,
			cno: $("#cno").val()
		};
	
		$.ajax({
			type: "POST",
			url: "/review/writeReviewProc",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("리뷰가 작성되었습니다.");
			location.href="/cafe/info/" + data.cno; // 차후 리뷰 남긴 카페 상세페이지 경로로 수정 필요! 
		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
	},




	reviewUpdate: function() {
		
		var waitingValue = parseInt($("#waiting").val());
		
		let data = {
			rno: $("#rno").val(),
			username: $("#username").val(),
			title: $("#title").val(),
			content: $('#content').summernote('code'), // 태그나 문자열 따질 것 없이 전부 가져온다.
			score: $("#score").val(),
			waiting: waitingValue,
			cno: $("#cno").val()
		};
		
		let page = {
			num: $("#num").val()
		}
		
		$.ajax({
			type: "PUT",
			url: "/review/updateReviewProc",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("리뷰가 수정되었습니다.");
			location.href="/member/myReview?num=" + page.num;
		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
	},


}

review.init();









