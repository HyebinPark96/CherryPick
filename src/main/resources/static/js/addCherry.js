
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
		
		
		
		let data = {
			username: 
			liname: $("#liname").val(),
			licafe1: parseInt($(".liname").eq(0).val(), 10),
			cimage: cimage,
			caddress: $("#caddress").val(),
			cphone: $("#cphone").val(),
			copen: $("#copen").val(),
			cclose: $("#cclose").val(),
			parking: $("input[name=parking]").filter(":checked").val(),
			pet: $("input[name=pet]").filter(":checked").val(),
			kids: $("input[name=kids]").filter(":checked").val(),
			seats: $("#seats").val(),
			group: $("input[name=group]").filter(":checked").val(),
			ctag: ctagStr,
			cmenu_img: cmenu_image
		};
		
		
		// ajax는 디폴트가 비동기 호출
		// ajax 통신 성공 => 서버가 json 리턴 => 자동으로 자바스크립트 오브젝트로 변환
		
		$.ajax({
			type: "POST",
			url: "/cafe/regCafeProc",
			data: JSON.stringify(data), // 자바스크립트의 data 객체를 Java가 알아듣도록 변경
			contentType: "application/json; charset=utf-8",
			dataType: "json" // json이라면 => javascript 오브젝트로 변경하여 아래 함수의 파라미터로 전달
		}).done(function(resp) {
			// 성공한 경우 호출
			//alert(resp);
			cno = Object.values(resp)[2];
			//alert(cno); 
			
			//alert("등록되었습니다. \n메뉴 등록을 호출합니다..");
			//location.href = "/";
//			"/bizMember/storeManagement";
			cindex.menuRegister(cno);

		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
		
	},
}

cindex.init();




