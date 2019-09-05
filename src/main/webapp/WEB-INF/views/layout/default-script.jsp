<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="/resources/scripts/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/resources/scripts/jquery-migrate-3.1.0.min.js"></script>
<script type="text/javascript" src="/resources/scripts/mmenu.min.js"></script>
<script type="text/javascript" src="/resources/scripts/chosen.min.js"></script>
<script type="text/javascript" src="/resources/scripts/slick.min.js"></script>
<script type="text/javascript" src="/resources/scripts/rangeslider.min.js"></script>
<script type="text/javascript" src="/resources/scripts/magnific-popup.min.js"></script>
<script type="text/javascript" src="/resources/scripts/waypoints.min.js"></script>
<script type="text/javascript" src="/resources/scripts/counterup.min.js"></script>
<script type="text/javascript" src="/resources/scripts/jquery-ui.min.js"></script>
<script type="text/javascript" src="/resources/scripts/tooltips.min.js"></script>
<script type="text/javascript" src="/resources/scripts/custom.js"></script>

<script type="text/javascript" src="/resources/scripts/loginregister.js"></script>


<!-- Date Range Picker - docs: http://www.daterangepicker.com/ -->
<script src="/resources/scripts/moment.min.js"></script>
<script src="/resources/scripts/daterangepicker.js"></script>
<script>
// Calendar Init
$(function() {
	$('#date-picker').daterangepicker({
		"opens": "left",
		singleDatePicker: true,

		// Disabling Date Ranges
		isInvalidDate: function(date) {
		// Disabling Date Range
		var disabled_start = moment('2018/09/02', 'YYYY/MM/DD');
		var disabled_end = moment('2018//09/06', 'YYYY/MM/DD');
		return date.isAfter(disabled_start) && date.isBefore(disabled_end);

		// Disabling Single Day
		// if (date.format('MM/DD/YYYY') == '08/08/2018') {
		//     return true; 
		// }
		},
		locale: {
			format: 'YYYYMMDD'
			}
	});
});

// Calendar animation
$('#date-picker').on('showCalendar.daterangepicker', function(ev, picker) {
	$('.daterangepicker').addClass('calendar-animated');
});
$('#date-picker').on('show.daterangepicker', function(ev, picker) {
	$('.daterangepicker').addClass('calendar-visible');
	$('.daterangepicker').removeClass('calendar-hidden');
});
$('#date-picker').on('hide.daterangepicker', function(ev, picker) {
	$('.daterangepicker').removeClass('calendar-visible');
	$('.daterangepicker').addClass('calendar-hidden');
});
</script>
<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('42580803bc68d1e639dd665f90bfadc4');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      persistAccessToken : false,
      throughTalk : false,
      success: function(authObj) {
          var JsonStr = JSON.stringify(authObj);
          $.ajax({
  			url : '/member/Kakaologin',
  			type: 'post',
  			datatype : 'json',
  			data: JsonStr,
  			contentType : "application/json",
  			success:function(data){
  				if(data =='1'){
  					window.location.href ="/main/main"
  	  			}else if(data == '2'){
  	  				window.location.href ="/member/kakaoRegister"
  	  	  		}else if(data == '3'){
  	  	  	  		alert("모든 권한을 동의 해 주세요.")
  	  	  			window.location.href ="/main/main"
  	  	  	  	}
  			},
  			error: function (XMLHttpRequest, textStatus, errorThrown){
  	        	alert('서버와의 통신이 원할하지 않습니다.\n다시 시도 해 주십시오.' );
  	        }
  	});
      },
      fail: function(err) {
         alert(JSON.stringify(err));
      }
    });
   
  //]]>
</script>

