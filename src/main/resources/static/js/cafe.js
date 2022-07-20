
// 정렬값 보내기
/* function sort() {
	
	// selected sort 값 가져오기
	var sort = $("#sort").val();
	
	
	}
	
	$.ajax( {
		url: "all",
		data: {"sort" : sort},
		type: "GET",
		success : function(data) {
			alert("성공")
		},
		error : function() {
			alert("에러")
		}
	}) */



// cno -> cafe/cno (카페개별페이지) 보내기
function sendToInfo(variable) {
	location.href = `/cafe/info/${variable}`;
}

// lino -> cafe/list/{lino} (리스트 개별페이지) 보내기
function sendToListInfo(variable) {
	location.href = `/cafe/list/${variable}`;
}


// 카페 북마크 여부 확인
$(document).ready(function() {
	
	
//chk 1=있음 0=없음
	let chk = document.getElementById('bmkli_check').value	
	const cno = $("#cno").val();
	const username = $("#username").val();
	console.log("cno:"+cno);
//	console.log("username:"+username);
	const bmkImg = document.getElementById("bmkImg")
	console.log("chk:"+chk);

	if (chk = 1 ) {
		bmkImg.src = "/img/bmk.png";
		
	} else {
		bmkImg.src = "/img/bmk-empty.png";
	}

	// 북마크 버튼 클릭시 실행되는 코드
	$("#bmkImg").on("click", function() {
		$.ajax({
			url: '/cafe/bmk/',
			type: 'GET',
			data: { 'cno': cno, 'username': username },
			success: function(data) {
				console.log(data);
				if (data == 1) {
					$("#bmkImg").attr("src", "/img/bmk.png");
				} else {
					$("#bmkImg").attr("src", "/img/bmk-empty.png");
				}
			}, error: function() {
				$("#bmkImg").attr("src", "/img/bmk-empty.png");
				console.log('오타')
				
			}

		});

	});
	
});


// 북마크 여부 확인 (리스트)
$(document).ready(function() {
	
	
//chk 1=있음 0=없음
	let chk = document.getElementById('bmkli_check').value
	const lino = $("#lino").val();
	const username = $("#username").val();
	console.log("lino:"+lino);
	console.log("username:"+username);
	const bmkImg = document.getElementById("bmkliImg")
	console.log("chk:"+chk);

	if (chk == 1 ) {
		bmkImg.src = "/img/bmk.png";
		
	} else {
		bmkImg.src = "/img/bmk-empty.png";
	}

	// 북마크 버튼 클릭시 실행되는 코드
	$("#bmkliImg").on("click", function() {
		$.ajax({
			url: '/cafe/bmkli/',
			type: 'GET',
			data: { 'lino': lino, 'username': username },
			success: function(data) {
				console.log(data);
				if (data == 1) {
					$("#bmkliImg").attr("src", "/img/bmk.png");
				} else {
					$("#bmkliImg").attr("src", "/img/bmk-empty.png");
				}
			}, error: function() {
				$("#bmkliImg").attr("src", "/img/bmk-empty.png");
				console.log('오타')
				
			}

		});

	});
	
});




