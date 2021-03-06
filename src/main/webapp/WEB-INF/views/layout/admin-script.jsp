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

