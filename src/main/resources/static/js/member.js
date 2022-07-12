let index = {
	init: function() {
		$("#saveBtn").on("click", () => { // 람다식 쓰는 이유 : this 바인딩
			this.save(); // save 함수 호출
		}); // on("1","2") : 파라미터 1번 이벤트 발생시 파라미터 2번을 수행하라는 의미
		
		$("#mUsernameCheckBtn").on("click", () => { 
			this.mUsernameCheck();
		});
		
		$("#updateMemberBtn").on("click", () => {
			this.updateMember();
		});
		
		
	},


	save: function() {
		let agreement = $("#agreement");

		if(!agreement.is(":checked")){
			alert("하단 체크박스에 동의해주세요.");
			return false;
		}
		
		let data = {
			username: $("#username").val(), // Form 의 input값 들고오기
			password: $("#password").val(),
			name: $("#name").val(),
			phone: $("#phone").val(),
			email: $("#email").val()
		};
		
		if(data.username.length < 8 || data.username.length > 15){
			alert("아이디는 8~15자를 입력해주세요.");
			return false;
		}

		if(data.password.trim().length==0 || data.name.trim().length==0 || 
			data.phone.trim().length==0 || data.email.trim().length==0){
			alert("항목을 제대로 기입하였는지 확인해주세요.");
			return false;
		}
		
		// ajax는 디폴트가 비동기 호출
		// ajax 통신 성공 => 서버가 json 리턴 => 자동으로 자바스크립트 오브젝트로 변환
		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data), // 자바스크립트의 data 객체를 Java가 알아듣도록 변경
			contentType: "application/json; charset=utf-8",
			dataType: "json" // json이라면 => javascript 오브젝트로 변경하여 아래 함수의 파라미터로 전달
		}).done(function(resp) {
			// 성공한 경우 호출
			alert("회원가입이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
	},
	
	
	
	
	
		mUsernameCheck: function() {
		let data = {
			username: $("#username").val()
		};

		$.ajax({
			type: "POST",
			url: "/auth/mUsernameCheck",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			alert(data.username + ": 사용 가능한 아이디입니다.");
		}).fail(function(error) {
			// 실패한 경우 호출
			alert(data.username + ": 이미 사용중이거나 탈퇴한 아이디입니다.");
			// alert(JSON.stringify(error));
		});
	},
	
	
	
	
		updateMember: function() {
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			pwdChk: $("#pwdChk").val(),
			name: $("#name").val(),
			phone: $("#phone").val(),
			email: $("#email").val(),
			dbPassword: $("#dbPassword").val()
		};
		
		if(data.password != data.pwdChk){
			alert("비밀번호가 동일하지 않습니다.");
			return false;
		}
		

		$.ajax({
			type: "PUT",
			url: "/member/updateMemberProc",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			// 성공한 경우 호출
			alert("수정 되었습니다.");
			location.href="/";
		}).fail(function(error) {
			// 실패한 경우 호출
			alert("수정에 실패하였습니다.");
		});
	},
	
	

}

index.init();









