/**
<<<<<<< HEAD
 * 
=======
 * storeRegister 내의 항목들을 동적으로 제어한다.
>>>>>>> 56d9530dc598459f0cb9ba72e22f9a2e65cbb2e0
 */


//숫자 입력란(.input-number)에 ,로 숫자 구분
<<<<<<< HEAD
=======
/*
>>>>>>> 56d9530dc598459f0cb9ba72e22f9a2e65cbb2e0
function updateTextView(_obj) {
	var num = getNumber(_obj.val());
	if (num == 0) {
		_obj.val('');
	} else {
		_obj.val(num.toLocaleString());
	}
}
function getNumber(_str) {
	var arr = _str.split('');
	var out = new Array();
	for (var cnt = 0; cnt < arr.length; cnt++) {
		if (isNaN(arr[cnt]) == false) {
			out.push(arr[cnt]);
		}
	}
	return Number(out.join(''));
}
$(document).ready(function() {
	$('.input-number').on('keyup', function() {
		updateTextView($(this));
	});
});
<<<<<<< HEAD

//▼▼▼▼====입력란 추가 관련 메소드====▼▼▼▼
//초기설정 : 입력란의 복사본을 하나 만들고, 원본은 숨긴다(display = 'none')

function initItem(blk, itm) {
	var blk = document.getElementById(blk);
	var itm = document.getElementsByClassName(itm);
	blk.appendChild(itm[0].cloneNode(true));
	itm[0].style.display = 'none';
}

initItem('ctag-block', 'ctag-item');
initItem('menulist-block', 'menulist-item');
initItem('cimage-block', 'cimage-item');

//숨겨져 있는 원본을 복사하고, 화면에 표시한다(display = 'block')
function addItem(blk, itm, max) {
	var blk = document.getElementById(blk);
	var itmArr = document.getElementsByClassName(itm);

	//갯수 제한을 넘기면 더 이상 엘리먼트를 생성하지 않는다.
	//실제 엘리먼트의 갯수는 (화면에 표시된 갯수 + 숨겨진 원본 1개)이므로, 판별조건에 -1을 붙여준다.
	if (itmArr.length - 1 < max) {
		var clone = blk.appendChild(itmArr[0].cloneNode(true));
		clone.style.display = 'block';
	}
=======
*/
//int를 Stirng으로 바꿔 버려서 보류.



function modal(){
	$("#inputModal").modal('show');
>>>>>>> 56d9530dc598459f0cb9ba72e22f9a2e65cbb2e0
}

//안한거 : +버튼, x버튼이 눌렸을 때 +버튼의 display를 토글하라.

//해쉬태그 생성 관련
var ctagStr = "";

function makeHashtag() {
	var ctagArr = document.getElementsByClassName('ctag-item-value');
	ctagStr = "";

	for (var i = 1; i < ctagArr.length; i++) {
		var currCtag = ctagArr[i].value.replace(/(\s*)/g, ""); //공백 제거
		if (currCtag.length > 0) {
			ctagStr = ctagStr += '#' + currCtag;
		}
	}
}
<<<<<<< HEAD

=======
//cropper.js 모달 호출
>>>>>>> 56d9530dc598459f0cb9ba72e22f9a2e65cbb2e0
function test() {
	$("#imgModal").modal('show');
}

<<<<<<< HEAD
function previewImg(input) {
	alert('blank');
}


//미리보기 관련
//<!--document.getElementById('a').style.backgroundImage = "url(/img/check.png)";-->
=======

//=====###입력란 추가/삭제 관련 메소드###=========

//각 요소를 몇 개 만들고 싶은지 갯수를 정하자.
var menuNum = 3;



//변경-삭제되지 않고 숨김/표시를 하는 엘리멘트를 생성할 것이다.
function initMenu(blk, itm, num, opt) {
	var blk = document.getElementById(blk);
	var itm = document.getElementsByClassName(itm);
	
	if(opt==1){
		itm[0].style.display = 'none';
	}
	
	//총 갯수 num만큼 만들겠다 = num-1번 복제하겠다.
	for (var i=0; i<num-1; i++){
		blk.appendChild(itm[0].cloneNode(true));
	}
	itm[0].style.display = 'block';
}

initMenu('menulist-block', 'menulist-item', menuNum, 0);



function showItem(){
	//사전에 생성된 클래스 이름을 받아온다.
	//
}


function previewImg(input, name, opt, idx) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		
		if(opt=="id"){
			reader.onload = function(e) {
			$(name).css('background', 'transparent url(' + e.target.result + ') center center no-repeat').css('background-size', 'cover');
			}
			reader.readAsDataURL(input.files[0]);	
		}else if(opt=="class"){
			
			
			reader.onload = function(e) {
			$('.'+name).eq(idx).css('background', 'transparent url(' + e.target.result + ') center center no-repeat').css('background-size', 'cover');
			}
			reader.readAsDataURL(input.files[0]);
		}else{
			alert('put accurate parameter.')
		}
	}
}

//▼▼▼▼====입력란 추가 관련 메소드====▼▼▼▼
//초기설정 : 입력란의 복사본을 하나 만들고, 원본은 숨긴다(display = 'none')

function initItem(blk, itm) {
	var blk = document.getElementById(blk);
	var itm = document.getElementsByClassName(itm);
	blk.appendChild(itm[0].cloneNode(true));
	itm[0].style.display = 'none';
}

initItem('ctag-block', 'ctag-item');
//initItem('cimage-block', 'cimage-item');

//숨겨져 있는 원본을 복사하고, 화면에 표시한다(display = 'block')
function addItem(blk, itm, max) {
	var blk = document.getElementById(blk);
	var itmArr = document.getElementsByClassName(itm);

	//갯수 제한을 넘기면 더 이상 엘리먼트를 생성하지 않는다.
	//실제 엘리먼트의 갯수는 (화면에 표시된 갯수 + 숨겨진 원본 1개)이므로, 판별조건에 -1을 붙여준다.
	if (itmArr.length - 1 < max) {
		var clone = blk.appendChild(itmArr[0].cloneNode(true));
		clone.style.display = 'block';
	}
}

function removeItem(class_name, i){
	const element = document.getElementsByClassName(class_name);
	element[i].remove(); 
}

>>>>>>> 56d9530dc598459f0cb9ba72e22f9a2e65cbb2e0
