
// cno -> cafe/cno (카페개별페이지) 보내기
function sendToInfo(variable) {
	location.href = `/cafe/info/${variable}`;
}

// lino -> cafe/list/{lino} (리스트 개별페이지) 보내기
function sendToListInfo(variable) {
	location.href = `/cafe/list/${variable}`;
}


// 문서 ready때 체크: 1.북마크 여부(cafeInfo) 2.sort&filter(cafeList)
$(document).ready(function() {
		
	let chk = document.getElementById('bmk_check').value
	const cno = $("#cno").val();
	const username = $("#username").val();
	const bmkImg = document.getElementById("bmkImg");
	console.log("[bmk check]username:"+username);
	console.log("[bmk check]cno:"+cno);
	console.log("[bmk check]chk:"+chk);

	if (chk <= 0 ) {
		bmkImg.src = "/img/bmk-empty.png";
		
	} else {
		bmkImg.src = "/img/bmk.png";
	}
		
	//필터링 변수 가져오기
	const fpark = $("#f_park").val();
	const fpet =  $("#f_pet").val();
	const fkids =  $("#f_kids").val();
	const fgroup =  $("#f_group").val();
	const sort =  $("#f_sort").val();
	
	console.log("fpark:"+fpark);
	console.log("fpet:"+fpet);
	console.log("fkids:"+fkids);
	console.log("fgroup:"+fgroup);
	console.log("sort:"+sort);
					

	var filter = { 'fpark' : fpark, 'fpet' : fpet, 'fkids' : fkids, 'fgroup' : fgroup, 'sort' : sort}
	
	var url="cafe/select";

	/* sort 선택 -> ajax 전송 */		
	//sort 선택시마다 바뀜
	$("#sort0").on("click", function() {
		if(this.checked) {
			filter.sort = 0;
			console.log("[checked]sort0"); 
		}
		window.location.href="/cafe/all?sort="+filter.sort+"&fpark="+filter.fpark+"&fpet="+filter.fpet+"&fkids="+filter.fkids+"&fgroup="+filter.fgroup;
			
/*		$.ajax({
		url: 'cafe/select',
		type: 'GET', 
		data: '' ,
		dataType: 'json', 
		success: function(data) {
				console.log("[ajax] sort radio success")
				console.log(data);	
				

				
			}, error: function(error) {
				console.log("[ajax] sort radio failed")
				console.log(error);

			}
		}); */
	});
	
	
	$("#sort1").on("click", function() {
		if(this.checked) {
			filter.sort = 1;
			console.log("[checked]sort1"); 
		}
		window.location.href="/cafe/all?sort="+filter.sort+"&fpark="+filter.fpark+"&fpet="+filter.fpet+"&fkids="+filter.fkids+"&fgroup="+filter.fgroup;

	});
	

	$("#sort2").on("click", function() {
		if(this.checked) {
			filter.sort = 2;
			console.log("[checked]sort2"); 
		}
		window.location.href="/cafe/all?sort="+filter.sort+"&fpark="+filter.fpark+"&fpet="+filter.fpet+"&fkids="+filter.fkids+"&fgroup="+filter.fgroup;			
	 
	});

	$("#sort3").on("click", function() {
		if(this.checked) {
			filter.sort = 3;
			console.log("[checked]sort3"); 
		}
		window.location.href="/cafe/all?sort="+filter.sort+"&fpark="+filter.fpark+"&fpet="+filter.fpet+"&fkids="+filter.fkids+"&fgroup="+filter.fgroup;			
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
		window.location.href="/cafe/all?sort="+filter.sort+"&fpark="+filter.fpark+"&fpet="+filter.fpet+"&fkids="+filter.fkids+"&fgroup="+filter.fgroup;		
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
		window.location.href="/cafe/all?sort="+filter.sort+"&fpark="+filter.fpark+"&fpet="+filter.fpet+"&fkids="+filter.fkids+"&fgroup="+filter.fgroup;		

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
		window.location.href="/cafe/all?sort="+filter.sort+"&fpark="+filter.fpark+"&fpet="+filter.fpet+"&fkids="+filter.fkids+"&fgroup="+filter.fgroup;	
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
		
		window.location.href="/cafe/all?sort="+filter.sort+"&fpark="+filter.fpark+"&fpet="+filter.fpet+"&fkids="+filter.fkids+"&fgroup="+filter.fgroup; 
	});
	
	
	// 북마크 버튼 클릭시 실행되는 코드 cafeInfo
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




