/**
 * 
 */


//숫자 입력란(.input-number)에 ,로 숫자 구분
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
}

function removeItem(class_name, i){
	const element = document.getElementsByClassName(class_name);
	element[i].remove(); 
}

function modal(){
	$("#inputModal").modal('show');
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

function test() {
	$("#imgModal").modal('show');
}


function previewImg(input, name, opt) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		
		if(opt=="id"){
			reader.onload = function(e) {
			$(name).css('background', 'transparent url(' + e.target.result + ') center center no-repeat').css('background-size', 'cover');
			}
			reader.readAsDataURL(input.files[0]);	
		}else if(opt=="class"){
			alert('optic blast beam-')
		}else{
			alert('put accurate parameter.')
		}
	}
}

function dynamicInput(){
	//새 인풋을 생성해.
	
	//새로 생성한(마지막)인풋만 표시해서 모달을 띄워.
}

function dynamicPreview(blk, itm, max, classname){
	addItem(blk, itm, max);
	previewImg(this, classname, "class")
}