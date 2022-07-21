
function sort(variable) {
	
	location.href = `/cafe/all/${variable}`;
	// selected sort 값 가져오기
/*	var sort = $("#sort").val();
	console.log("#sort: " + sort);

	$.ajax({
		url: '/cafe/sort/'+sort,
		data: { 'sort': sort },
		type: "GET",
		success: function(data) {
			console.log(data);
			alert("성공")
			window.location = sort;
		
	}, error: function() {
		console.log('오타')
	}
}); */
}



	



// cno -> cafe/cno (카페개별페이지) 보내기
function sendToInfo(variable) {
	location.href = `/cafe/info/${variable}`;
}

// lino -> cafe/list/{lino} (리스트 개별페이지) 보내기
function sendToListInfo(variable) {
	location.href = `/cafe/list/${variable}`;
}


<<<<<<< HEAD
// 카페 북마크 여부 확인
=======
// 카페 북마크 여부 확인 and sort 폰트변경
>>>>>>> 56d9530dc598459f0cb9ba72e22f9a2e65cbb2e0
$(document).ready(function() {
	
	
//chk 1=있음 0=없음
<<<<<<< HEAD
	let chk = document.getElementById('bmkli_check').value	
=======
	let chk = document.getElementById('bmk_check').value	
>>>>>>> 56d9530dc598459f0cb9ba72e22f9a2e65cbb2e0
	const cno = $("#cno").val();
	const username = $("#username").val();
	console.log("cno:"+cno);
//	console.log("username:"+username);
<<<<<<< HEAD
	const bmkImg = document.getElementById("bmkImg")
=======
	const bmkImg = document.getElementById("bmkImg");
>>>>>>> 56d9530dc598459f0cb9ba72e22f9a2e65cbb2e0
	console.log("chk:"+chk);

	if (chk = 1 ) {
		bmkImg.src = "/img/bmk.png";
		
	} else {
		bmkImg.src = "/img/bmk-empty.png";
	}


//sort style

	var sortType = document.location.pathname;
	console.log("sortType:"+sortType);
	
	const sort0 = document.getElementById('sort0');
	const sort1 = document.getElementById('sort1');
	const sort2 = document.getElementById('sort2');
	const sort3 = document.getElementById('sort3');
	
	if (sortType=='/cafe/all/0') {
		sort0.style.fontWeight = 'bold';
		sort0.style.color='#a6434b';
	}else if (sortType=='/cafe/all/1') {
		sort1.style.fontWeight = 'bold';
		sort1.style.color='#a6434b';		
	}else if (sortType=='/cafe/all/2') {
		sort2.style.fontWeight = 'bold';
		sort2.style.color='#a6434b';
	}else if (sortType=='/cafe/all/3') {
		sort3.style.fontWeight = 'bold';
		sort3.style.color='#a6434b';
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

/*
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


<<<<<<< HEAD
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



=======
*/
>>>>>>> 56d9530dc598459f0cb9ba72e22f9a2e65cbb2e0

