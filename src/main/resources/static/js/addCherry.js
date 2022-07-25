
let cindex = {

	init: function() {

		$("#btn-addCherry").on("click", () => { // 람다식 쓰는 이유 : this 바인딩
			this.addCherry();
		}); // on("1","2") : 파라미터 1번 이벤트 발생시 파라미터 2번을 수행하라는 의미
		
	},
	
	addCherry: function() {
		//!======""데이터 유효성 검증을 구현하지 않았다.""==========//
		
		alert('리스트 등록을 실행합니다.');
		
		//liname 받아오기
		
		//cno 받아서 숫자로 바꾸기
		
		alert($(".cno").eq(0).val());
		alert($(".cno").eq(1).val());
		alert($(".cno").eq(2).val());
		
		
		let data = {
			username: $("#username").val(),
			liname: $("#liname").val(),
			li_cafe1: parseInt($(".cno").eq(0).val(), 10),
			li_cafe2: parseInt($(".cno").eq(1).val(), 10),
			li_cafe3: parseInt($(".cno").eq(2).val(), 10),
			li_cafe4: parseInt($(".cno").eq(3).val(), 10),
			li_cafe5: parseInt($(".cno").eq(4).val(), 10),
		};
		
		$.ajax({
			type: "POST",
			url: "/member/regListProc",
			data: JSON.stringify(data), // 자바스크립트의 data 객체를 Java가 알아듣도록 변경
			contentType: "application/json; charset=utf-8",
			dataType: "json" // json이라면 => javascript 오브젝트로 변경하여 아래 함수의 파라미터로 전달
		}).done(function(resp) {
			// 성공한 경우 호출
			
			alert("리스트가 등록되었습니다.");
			//location.href = "/";
//			"/bizMember/storeManagement";


		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
		
	},
}

cindex.init();




