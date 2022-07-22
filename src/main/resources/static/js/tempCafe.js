
let cindex = {
	
	init: function() {
		
		$("#btn-register").on("click", () => { // 람다식 쓰는 이유 : this 바인딩
			this.submitFiles();
			this.register(); 
		}); // on("1","2") : 파라미터 1번 이벤트 발생시 파라미터 2번을 수행하라는 의미
		
	},

	//==================================
	submitFiles: function() {
		alert('시작');

		let formData = new FormData();
			
		//var inputArr = document.getElementsByName("files");
		var inputArr = document.getElementsByClassName("drop-zone__input");
		for (let i = 0; i < inputArr.length; i++) {
			console.log(inputArr[i]);
			console.log(inputArr[i].files[0]);
			let fileArr = $("input[name=files]")[i].files;
			formData.append("files", fileArr[0]);
			console.log(fileArr[i]);
		}

		$.ajax({
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
		
		
		//유일한 파일명 만들 방법은? 현재시간 추가 / 카페 넘버 추가 / -> 카페 넘버는 현재로는 데이터 삽입이 끝나야 얻어올 수 있어.
		let data = {
			bid: $("#bid").val(),
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
			alert(resp);
			cno = Object.values(resp)[2];
			alert(cno); 
			
			alert("등록되었습니다. \n메뉴 등록을 호출합니다..");
			//location.href = "/";
//			"/bizMember/storeManagement";
			cindex.menuRegister(cno);

		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
		
	},
	
	menuRegister: function(cno){
		
		alert('메뉴 등록을 실행합니다.');
		alert('menuRegister cno:' + cno);
		/*
		//파일명 배열 생성
		var m_img = $(".m_img");
		var m_img_fname = [];
		
		m_img.each( function(i) { 
			var fname = $('.m_img').eq(i).val().replace(/.*(\/|\\)/, '');
			m_img_fname.push(fname);
			alert(m_img_fname[i]);
		} );*/
		
		//ajax를 List CafeVO를 넘길 거야.
		//일단 딴거 재지 말고 3번 모두 실행.
		var menuList = [];
		
		for (var i = 0; i < 3; i++) {
			let data = {
				cno: cno,
				m_name: $('.m_name').eq(i).val(),
				m_img: $('.m_img').eq(i).val().replace(/.*(\/|\\)/, ''),
				m_detail: $('.m_detail').eq(i).val(),
				m_size: "",
				m_price: $('.m_price').eq(i).val(),
				m_tag: ""

			};
			
			menuList.push(data);
		}
		
		$.ajax({
			type: "POST",
			url: "/cafe/regMenuProc",
			data: JSON.stringify(menuList), // 자바스크립트의 data 객체를 Java가 알아듣도록 변경
			contentType: "application/json; charset=utf-8",
			dataType: "json" // json이라면 => javascript 오브젝트로 변경하여 아래 함수의 파라미터로 전달
		}).done(function(resp) {
			// 성공한 경우 호출
			
			alert("메뉴도 등록되었습니다. \n등록하신 정보는 [사업장 관리]페이지에서 수정하실 수 있습니다.");
			location.href = "/";

		}).fail(function(error) {
			// 실패한 경우 호출
			alert(JSON.stringify(error));
		});
	}
}

cindex.init();




