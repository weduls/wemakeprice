<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>we make price</title>
</head>
<body>
	<!-- Ÿ��Ʋ -->
	<div>
		���� �Է��ϼ���. ���� ���ڿ� ���ڸ� �����մϴ�.
	</div>
	
	<!-- �Է�â -->
	<input type="text" id="inputText" style="width:379px;">
	
	<!-- ���â -->
	<div style="padding-top:30px;">
		<span>���� ��� : </span>
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
        		 $result.val("���ڿ� ��� ����Ͻ� �� �ֽ��ϴ�.");   		
        		 $result.css({'color': 'red'});
    			 break;
    			 
    		 case 'IllegalArgumentException':
    			 $result.val("�����͸� �Է��ϼ���.");   		
        		 $result.css({'color': 'blue'});
    			 break;
    			 
    		 default:
    			 $result.val("�˼� ���� ������ �߻��Ǿ����ϴ�. �����ڿ��� �����ϼ���.");   		
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