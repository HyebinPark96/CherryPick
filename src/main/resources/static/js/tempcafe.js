

let cindex = {
	init: function() {

		$("#btn-register").on("click", () => { // 람다식 쓰는 이유 : this 바인딩
			alert('2kooong2');
			//this.fileupload(); - 구 파일업로드 테스트
			this.submitFiles();
			//this.register(); 
		}); // on("1","2") : 파라미터 1번 이벤트 발생시 파라미터 2번을 수행하라는 의미

		$("#uploadTest").on("click", () => { // 람다식 쓰는 이유 : this 바인딩
			//this.fileupload();
			this.submitFiles();
		}); // on("1","2") : 파라미터 1번 이벤트 발생시 파라미터 2번을 수행하라는 의미

	},

	//==================================
	submitFiles: function() {
		let formData = new FormData();
			
		//let files = $("input[name=files]")[0].files;
	//		let i = 0;
		var inputArr = document.getElementsByName("files");
		for (let i = 0; i < inputArr.length; i++) {
			console.log(inputArr[i]);
			console.log(inputArr[i].files);
			let files = $("input[name=files]")[i].files;
			formData.append("files", files[0]);
		}

		$.ajax({
			url: 'http://localhost/test', //수정요망.
			data: formData,
			cache: false,
			contentType: false,
			processData: false,
			type: 'POST',
			success: function(data) {
				console.log(data);
			},
			error: function(e) {
				console.log(e);
			}
		});
	},

	//카페 등록 메소드=====================

	register: function() {
		
		alert('카페 등록을 실행합니다.');
		
		makeHashtag(); //storeRegister.html의 hashtag 함수
		
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
			cimage: "ready.png",
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
			cmenu_img: ""
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


}

cindex.init();



	/*
	fileupload: function(){

		alert('파일 첨부를 실행합니다.');
		
		var data = new FormData();
		data.append("file", $('#upload-file-input').prop('files')[0]);

		$.ajax({
			url: "/uploadFile",
			type: "POST",
			data: data,
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			cache: false,
			success: function() {
				// Handle upload success
				// ...
			},
			error: function() {
				alert('파일 첨부 중 에러가 발생했습니다.');
				// Handle upload error
				// ...
			}
		});
	},

*/





