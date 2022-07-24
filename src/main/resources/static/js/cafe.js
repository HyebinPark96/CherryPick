
// cno -> cafe/cno (카페개별페이지) 보내기
function sendToInfo(variable) {
	location.href = `/cafe/info/${variable}`;
}

// lino -> cafe/list/{lino} (리스트 개별페이지) 보내기
function sendToListInfo(variable) {
	location.href = `/cafe/list/${variable}`;
}


// 문서 ready때 체크: 북마크 여부, sort&filter setting
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
		
	//필터링 변수 가져오기
	var fpark = $("#f_park").val();
	var fpet =  $("#f_pet").val();
	var fkids =  $("#f_kids").val();
	var fgroup =  $("#f_group").val();
	var sort =  $("#f_sort").val(); 
	
/*	var fpark = 0;
	var fpet = 0;
	var fkids = 0;
	var fgroup = 0;
	var sort = 0; */
	
	console.log(fpark);
	console.log(fpet);
	console.log(fkids);
	console.log(fgroup);
	console.log(sort);
					
/*
	for (i = 0; i < 4; i++) {
	if (sort == i ){
		$('#sort'+sort).attr('checked', true);
	}
}
	
	var checklist = [fpark, fpet, fkids, fgroup];
	

/*	 if(fkids == 1) {
		$('#fkids').attr('checked', true);
	}
*/
	


	var filter = { 'fpark' : fpark, 'fpet' : fpet, 'fkids' : fkids, 'fgroup' : fgroup, 'sort' : sort}
	
	var url="cafe";
	
/*	$.ajax({
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
*/
	
		
	//sort 선택시마다 바뀜
	$("#sort0").on("click", function() {
		if(this.checked) {
			filter.sort = 0;
			console.log("[checked]sort0"); 
		}
			
		$.ajax({
		url: url,
		type: 'POST', //get으로 보내면 에러남 ㅋㅋ
		data: JSON.stringify(filter) ,
		contentType: 'application/json',
		dataType: 'html', 
		success: function(data) {
				console.log("[ajax] sort radio success")
				
			}, error: function() {
				console.log("[ajax] sort radio failed")

			}
		}); 
	});
	
	
	$("#sort1").on("click", function() {
		if(this.checked) {
			filter.sort = 1;
			console.log("[checked]sort1"); 
		}
			
		$.ajax({
		url: url,
		type: 'POST', //get으로 보내면 에러남 ㅋㅋ
		data: JSON.stringify(filter) ,
		contentType: 'application/json',
		dataType: 'json', 
		success: function(data) {
				console.log("[ajax] sort radio success")
				
			}, error: function() {
				console.log("[ajax] sort radio failed")

			}
		}); 
	});

	$("#sort2").on("click", function() {
		if(this.checked) {
			filter.sort = 2;
			console.log("[checked]sort2"); 
		}
			
		$.ajax({
		url: url,
		type: 'POST', //get으로 보내면 에러남 ㅋㅋ
		data: JSON.stringify(filter) ,
		contentType: 'application/json',
		dataType: 'text', 
		success: function(data) {
				console.log("[ajax] sort radio success")
				$("html").html(data);
				
			}, error: function() {
				console.log("[ajax] sort radio failed")

			}
		}); 
	});

	$("#sort3").on("click", function() {
		if(this.checked) {
			filter.sort = 3;
			console.log("[checked]sort1"); 
		}
			
		$.ajax({
		url: url,
		type: 'POST', //get으로 보내면 에러남 ㅋㅋ
		data: JSON.stringify(filter) ,
		contentType: 'application/json',
		dataType: 'text', 
		success: function(data) {
				console.log("[ajax] sort radio success")
				$("html").html(data);
				
			}, error: function() {
				console.log("[ajax] sort radio failed")

			}
		}); 
	});


	// 주차 체크박스 바뀔때마다 전송
	$("#fpark").on("change", function() {
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
				$("html").html(data);
				
			}, error: function() {
				console.log("[ajax] park checkbox failed")

			}
		}); 
	});
	

	
	// 펫 체크박스 바뀔때마다 전송
	$("#fpet").on("change", function() {
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
				$("html").html(data);
				
			}, error: function() {
				console.log("[ajax] pet checkbox failed")

			}
		}); 
	});
	
	// 키즈 체크박스 바뀔때마다 전송
	$("#fkids").on("change", function() {
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
				console.log(data);
				$("html").html(data);

				

				
			}, error: function() {
				console.log("[ajax] kids checkbox failed")

			}
		}); 
	});
	
	// 그룹 체크박스 바뀔때마다 전송
	$("#fgroup").on("change", function() {
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
				console.log("[ajax] group checkbox success");
	
			}, error: function(error) {
				console.log("[ajax] group checkbox failed");
				console.log(error);

			}
		}); 
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




