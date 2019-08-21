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


<!-- Google Autocomplete -->
<script>
  function initAutocomplete() {
    var input = document.getElementById('autocomplete-input');
    var autocomplete = new google.maps.places.Autocomplete(input);

    autocomplete.addListener('place_changed', function() {
      var place = autocomplete.getPlace();
      if (!place.geometry) {
        return;
      }
    });

	if ($('.main-search-input-item')[0]) {
	    setTimeout(function(){ 
	        $(".pac-container").prependTo("#autocomplete-container");
	    }, 300);
	}
}
</script>
<script src="https://maps.googleapis.com/maps/api/js?libraries=places&callback=initAutocomplete"></script>
