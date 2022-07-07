let index = {
	init: function(){
		$("#btn-save").on("click", ()=>{ // 람다식 쓰는 이유 : this 바인딩
			this.save(); // save 함수 호출
		}); // on("1","2") : 파라미터 1번 이벤트 발생시 파라미터 2번을 수행하라는 의미
		
	},
	
	save: function(){
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			name: $("#name").val(),
			phone: $("#phone").val(),
			email: $("#email").val()
		};
		
		console.log(data);
		
		// ajax는 디폴트가 비동기 호출
		// ajax 통신 성공 => 서버가 json 리턴 => 자동으로 자바스크립트 오브젝트로 변환
		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data), // 자바스크립트의 data 객체를 Java가 알아듣도록 변경
			contentType: "application/json; charset=utf-8",
			dataType: "json" // json이라면 => javascript 오브젝트로 변경하여 아래 함수의 파라미터로 전달
		}).done(function(resp){
			// 성공한 경우 호출
			alert("회원가입이 완료되었습니다.");
			location.href="/demo1";
		}).fail(function(error){
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		}); 
	}, 
}

index.init();









