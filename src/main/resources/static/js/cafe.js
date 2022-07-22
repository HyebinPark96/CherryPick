
// cno -> cafe/cno (카페개별페이지) 보내기
function sendToInfo(variable) {
	location.href = `/cafe/info/${variable}`;
}

// lino -> cafe/list/{lino} (리스트 개별페이지) 보내기
function sendToListInfo(variable) {
	location.href = `/cafe/list/${variable}`;
}


// 카페 북마크 여부 확인, sort 폰트변경
$(document).ready(function() {
		
	let chk = document.getElementById('bmk_check').value	
	const cno = $("#cno").val();
	const username = $("#username").val();
	const bmkImg = document.getElementById("bmkImg");
	console.log("[bmk check]username:"+username);
	console.log("[bmk check]cno:"+cno);
	console.log("[bmk check]chk:"+chk);

	if (chk = 1 ) {
		bmkImg.src = "/img/bmk.png";
		
	} else {
		bmkImg.src = "/img/bmk-empty.png";
	}


	// 정렬방식 고르기
	const sort0 = document.getElementById('sort0');
	const sort1 = document.getElementById('sort1');
	const sort2 = document.getElementById('sort2');
	const sort3 = document.getElementById('sort3');
	
	var sort = 0;

	var sortUrl = window.location.search;
	console.log(sortUrl);
	
	if(sortUrl=='?sort=0') {
		
		sort = 0;
		sort0.style.fontWeight = 'bold';
		sort0.style.color= '#a6434b';
		console.log(sortUrl);
				
		
	}else if (sortUrl=='?sort=1') {
		sort = 1;
		sort1.style.fontWeight = 'bold';
		sort1.style.color= '#a6434b';
	

	}else if (sortUrl=='?sort=2') {
		sort = 2;
		sort2.style.fontWeight = 'bold';
		sort2.style.color= '#a6434b';
			
		
	}else if (sortUrl=='?sort=3') {
		sort = 3;
		sort3.style.fontWeight = 'bold';
		sort3.style.color= '#a6434b';	
		
			
	}

	
	
	//필터링 변수 초기화

	var fpark = 0
	var fpet = 0
	var fkids = 0
	var fgroup = 0

	var filter = { 'fpark' : fpark, 'fpet' : fpet, 'fkids' : fkids, 'fgroup' : fgroup}
	
	let url="/cafe/all/";
	
	$.ajax({
	url: url,
	type: 'POST', //get으로 보내면 에러남 ㅋㅋ
	data: JSON.stringify(filter) ,
	contentType: 'application/json',
	dataType: 'text', 
	
	success: function(data) {
	console.log("[필터링 ready 전송완료]")
	
	}, error: function(jqXHR, textStatus, errorThrown) {
		console.log("[필터링 ready 전송 error]:" + textStatus + errorThrown);			

	}
}); 

	
		
	const parking = document.getElementById('filter_park')
	const pet = document.getElementById('filter_pet')
	const kids = document.getElementById('filter_kids')
	const group = document.getElementById('filter_group')
	

	// 주차 체크박스 바뀔때마다 전송
	$("#filter_park",).on("change", function() {
		if(this.checked) {
			filter.fpark = 1;
			console.log("[checked]parking"); 
		}else {
			filter.fpark = 0;
			console.log("[unchecked]parking:"); 
		}
			
		$.ajax({
		url: url,
		type: 'POST', //get으로 보내면 에러남 ㅋㅋ
		data: JSON.stringify(filter) ,
		contentType: 'application/json',
		dataType: 'text', 
		success: function(data) {
				console.log("[ajax] park checkbox success")
				
			}, error: function() {
				console.log("[ajax] park checkbox failed")

			}
		}); 
	});
	

	
	// 펫 체크박스 바뀔때마다 전송
	$("#filter_pet",).on("change", function() {
		if(this.checked) {
			filter.fpet = 1;
			console.log("[checked]pet"); 
		}else {
			filter.fpet = 0;
			console.log("[unchecked]pet");  
		}
		
		$.ajax({
		url: url,
		type: 'POST', //get으로 보내면 에러남 ㅋㅋ
		data: JSON.stringify(filter) ,
		contentType: 'application/json',
		dataType: 'text', 
		success: function(data) {
				console.log("[ajax] pet checkbox success")
				
			}, error: function() {
				console.log("[ajax] pet checkbox failed")

			}
		}); 
	});
	
	// 키즈 체크박스 바뀔때마다 전송
	$("#filter_kids",).on("change", function() {
		if(this.checked) {
			filter.fkids = 1;
			console.log("[checked]kids"); 
		}else {
			filter.fkids = 0;
			console.log("[unchecked]kids"); 
		}
		
		$.ajax({
		url: url,
		type: 'POST', //get으로 보내면 에러남 ㅋㅋ
		data: JSON.stringify(filter) ,
		contentType: 'application/json',
		dataType: 'text', 
		success: function(data) {
				console.log("[ajax] kids checkbox success")
				
			}, error: function() {
				console.log("[ajax] kids checkbox failed")

			}
		}); 
	});
	
	// 그룹 체크박스 바뀔때마다 전송
	$("#filter_group",).on("change", function() {
		if(this.checked) {
			filter.fgroup = 1;
			console.log("[checked]group"); 
		}else {
			filter.fgroup = 0;
			console.log("[unchecked]group"); 
		}
		
		$.ajax({
		url: url,
		type: 'POST', //get으로 보내면 에러남 ㅋㅋ
		data: JSON.stringify(filter) ,
		contentType: 'application/json',
		dataType: 'text', 
		success: function(data) {
				console.log("[ajax] group checkbox success")
				
			}, error: function() {
				console.log("[ajax] group checkbox failed")

			}
		}); 
	});
	

	// sort 바꿀때마다 실행되는 코드
	$("#sort0").on("click", function() {
		
		sort = 0;
		
		$.ajax({
			url: '/cafe/all/',
			type: 'GET',
			data: {'sort': sort},
			success: function(data) {
				console.log("sort전달 성공 sort:"+sort)
				window.location.href='/cafe/all/?sort='+sort;
			}, error: function() {
				alert("sort 전달 실패");
			}
			
		})
	});

	// sort 바꿀때마다 실행되는 코드
	$("#sort1").on("click", function() {
		
		sort = 1;
		
		$.ajax({
			url: '/cafe/all/',
			type: 'GET',
			data: {'sort': sort},
			success: function(data) {
				console.log("sort전달 성공 sort:"+sort)
				window.location.href='/cafe/all/?sort='+sort;
			}, error: function() {
				alert("sort 전달 실패");
			}
			
		})
	});	
	
	// sort 바꿀때마다 실행되는 코드
	$("#sort2").on("click", function() {
		
		sort = 2;
		
		$.ajax({
			url: '/cafe/all/',
			type: 'GET',
			data: {'sort': sort},
			success: function(data) {
				console.log("sort전달 성공 sort:"+sort)
				window.location.href='/cafe/all/?sort='+sort;
				sort2.style.fontWeight = 'bold';
				sort2.style.color='#a6434b';
			}, error: function() {
				alert("sort 전달 실패");
			}
			
		})
	});
	
	// sort 바꿀때마다 실행되는 코드
	$("#sort3").on("click", function() {
		sort = 3;
		$.ajax({
			url: '/cafe/all/',
			type: 'GET',
			data: {'sort': sort},
			success: function(data) {
				console.log("sort전달 성공 sort:"+sort)
				window.location.href='/cafe/all/?sort='+sort;
				sort3.style.fontWeight = 'bold';
				sort3.style.color='#a6434b';
			}, error: function() {
				alert("sort 전달 실패");
			}
			
		})
	});	
	
	// 북마크 버튼 클릭시 실행되는 코드
	$("#bmkImg").on("click", function() {
		$.ajax({
			url: '/cafe/bmk/',
			type: 'POST',
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




