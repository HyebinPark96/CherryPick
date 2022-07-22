/**
 * storeRegister 내의 항목들을 동적으로 제어한다.
 */


//숫자 입력란(.input-number)에 ,로 숫자 구분
/*
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
*/
//int를 Stirng으로 바꿔 버려서 보류.

$('#cimage_Preview').hide();
$('#cmenu_preview').hide();
//$('.m_img_preview').hide();




//모달 호출 기능 부여 (메뉴 이미지 3개)
/*
var mBtns = document.getElementsByClassName("m_img_btn");

for (var i = 0; i < mBtns.length; i++) {
	var id = 'mImgModal' + (i+1);
	alert(id);
   	mBtns[i].addEventListener('click', $(id).modal('show'), false);
}*/

function modal(modalId){
	//모달 표시.
	$(modalId).modal('show');
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


function previewImg(input, btn, img, opt, idx) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		
		if(opt=="id"){
			reader.onload = function(e) {
				$(btn).hide();
				$(img).show();
				$(img).css('background', 'transparent url(' + e.target.result + ') center center no-repeat').css('background-size', 'cover');
			}
			reader.readAsDataURL(input.files[0]);	
		}else if(opt=="class"){
			
			
			reader.onload = function(e) {
				$('.'+img).eq(idx).css('display', 'block');
				$('.'+img).eq(idx).css('background', 'transparent url(' + e.target.result + ') center center no-repeat').css('background-size', 'cover');
			}
			reader.readAsDataURL(input.files[0]);
		}else{
			alert('put accurate parameter.')
		}
	}
}

function deleteImg(input, btn, img, opt, idx){
	$(input).val("");
	$(btn).show();
	$(img).hide();
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



//드래그&드롭 파일첨부 관련 메소드
document.querySelectorAll(".drop-zone__input").forEach((inputElement) => {
  const dropZoneElement = inputElement.closest(".drop-zone");

  dropZoneElement.addEventListener("click", (e) => {
    inputElement.click();
  });

  inputElement.addEventListener("change", (e) => {
    if (inputElement.files.length) {
      //updateThumbnail(dropZoneElement, inputElement.files[0]);
      console.log(e.target);
      //$('#modalwindow').modal('hide');  parent('.modal')
      
      console.log(e.target.closest(`.modal`));
      console.log($('#cmenuImgModal'));
      //e.target.closest(`.modal`).modal('hide');
      //$('#cmenuImgModal').modal('hide');
      $(e.target).closest(`.modal`).modal('hide');
    }
  });

  dropZoneElement.addEventListener("dragover", (e) => {
    e.preventDefault();
    dropZoneElement.classList.add("drop-zone--over");
  });

  ["dragleave", "dragend"].forEach((type) => {
    dropZoneElement.addEventListener(type, (e) => {
      dropZoneElement.classList.remove("drop-zone--over");
      
    });
  });

  dropZoneElement.addEventListener("drop", (e) => {
    e.preventDefault();

    if (e.dataTransfer.files.length) {
      inputElement.files = e.dataTransfer.files;
      updateThumbnail(dropZoneElement, e.dataTransfer.files[0]);
    }

    dropZoneElement.classList.remove("drop-zone--over");
  });
});

/**
 * Updates the thumbnail on a drop zone element.
 *
 * @param {HTMLElement} dropZoneElement
 * @param {File} file
 */
function updateThumbnail(dropZoneElement, file) {
  let thumbnailElement = dropZoneElement.querySelector(".drop-zone__thumb");
	
  // First time - remove the prompt
  if (dropZoneElement.querySelector(".drop-zone__prompt")) {
    dropZoneElement.querySelector(".drop-zone__prompt").style.display='none';
  }

  // First time - there is no thumbnail element, so lets create it
  if (!thumbnailElement) {
    thumbnailElement = document.createElement("div");
    thumbnailElement.classList.add("drop-zone__thumb");
    dropZoneElement.appendChild(thumbnailElement);
    dropZoneElement.thumbnailElement.show();
  }

  thumbnailElement.dataset.label = file.name;

  // Show thumbnail for image files
  if (file.type.startsWith("image/")) {
    const reader = new FileReader();

    reader.readAsDataURL(file);
    reader.onload = () => {
      thumbnailElement.style.backgroundImage = `url('${reader.result}')`;
    };
  } else {
    thumbnailElement.style.backgroundImage = null;
  }
}
