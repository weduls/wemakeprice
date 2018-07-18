<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>we make price</title>
</head>
<body>
	<!-- 타이틀 -->
	<div>
		값을 입력하세요. 값은 숫자와 문자만 가능합니다.
	</div>
	
	<!-- 입력창 -->
	<input type="text" id="inputText" style="width:379px;">
	
	<!-- 결과창 -->
	<div style="padding-top:30px;">
		<span>정렬 결과 : </span>
		<div>
			<textarea disabled id="result" style="width:379px;height:135px;"></textarea>
		</div>
	</div>
</body>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
var $inputText = $('#inputText');
var $result = $('#result');

$inputText.keyup(function(e) {
  $.ajax({
     type: 'POST',
     url: "/sort",
     data: { str: $inputText.val() },
     contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
     success: function(e) {
    	 if (e.errMsg) {
    		 switch(e.errMsg) {
    		 case 'NoEnglishAndNumberException':
        		 $result.val("숫자와 영어만 사용하실 수 있습니다.");   		
        		 $result.css({'color': 'red'});
    			 break;
    			 
    		 case 'IllegalArgumentException':
    			 $result.val("데이터를 입력하세요.");   		
        		 $result.css({'color': 'blue'});
    			 break;
    			 
    		 default:
    			 $result.val("알수 없는 에러가 발생되었습니다. 관리자에게 문의하세요.");   		
    			 $result.css({'color': 'red'});
    			 break;
    		 }
    	 } else {
	    	 $result.val(e);
	    	 $result.css({'color': 'black'});
    	 }
     }
   });
});
</script>
</html>