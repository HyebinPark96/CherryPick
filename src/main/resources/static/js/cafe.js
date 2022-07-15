
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
	location.href = `/cafe/${variable}`;
}

// lino -> cafe/list/{lino} (리스트 개별페이지) 보내기
function sendToListInfo(variable) {
	location.href = `/cafe/list/${variable}`;
}