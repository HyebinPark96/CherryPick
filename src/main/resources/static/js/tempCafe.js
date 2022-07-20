

let cindex = {
	init: function() {

		$("#btn-register").on("click", () => { // 람다식 쓰는 이유 : this 바인딩
			//this.fileupload(); - 구 파일업로드 테스트
			this.submitFiles();
			this.register(); 
			this.menuRegister(); 
		}); // on("1","2") : 파라미터 1번 이벤트 발생시 파라미터 2번을 수행하라는 의미
		
		$("#uploadTest").on("click", () => { // 람다식 쓰는 이유 : this 바인딩
			//this.fileupload();
			this.submitFiles();
		}); // on("1","2") : 파라미터 1번 이벤트 발생시 파라미터 2번을 수행하라는 의미

	},

	//==================================
	submitFiles: function() {
		alert('시작');

		let formData = new FormData();
			
		//let files = $("input[name=files]")[0].files;
	//		let i = 0;
		var inputArr = document.getElementsByName("files");
		for (let i = 0; i < inputArr.length; i++) {
			//console.log(inputArr[i]);
			//console.log(inputArr[i].files[0]);
			let fileArr = $("input[name=files]")[i].files;
			formData.append("files", fileArr[0]);
			//console.log(files[i]);
		}

		$.ajax({
			//url: 'http://localhost/test', //추후 적절한 이름으로 수정요망.
			url: '/cafe/uploadProc',
			data: formData,
			cache: false,
			contentType: false,
			processData: false,
			type: 'POST',
			success: function(data) {
				console.log(data);
				if (data) {
					alert("완료");
					//아무 파일도 안 올려도 이게 뜬다.
				} else {
					alert("전송된 값 없음");
				}
			},
			error: function(e) {
				console.log(e);
			}
		});
	},

	//카페 등록 메소드=====================

	register: function() {
		
		alert('카페 등록을 실행합니다.');
		
		//파일명 받아오기
		var cimage = $("#cimage").val().replace(/.*(\/|\\)/, '');
		var cmenu_image = $("#cmenu_image").val().replace(/.*(\/|\\)/, '');
		
		//storeRegister.html의 hashtag 함수
		makeHashtag(); 
		
		/*
		let cname = $("#cname").val();
		if (cname.length == 0) {
			alert("카페 이름을 입력해주세요.");
			return false;
		}
		*/
		
		//파일명. 어떻게 받아올거야.
		//1) 뷰에서 생성해서, 메소드 두개에다 각각 전달한다.
		//2) submitfiles에서 생성해서, 전달한다.
		//파일명은? 현재시간 추가 / 카페 넘버 추가 /
		let data = {
			bid: "bizTemp", 
			cname: $("#cname").val(),
			c_lat: 0,
			c_long: 0,
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
//			alert(resp);
			alert("등록되었습니다. \n등록하신 정보는 [사업장 관리]페이지에서 수정하실 수 있습니다.");
			location.href = "/";
//			"/bizMember/storeManagement";

		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
		
	},
	
	menuRegister: function(){
		
	}


}

cindex.init();




