<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
$(document).ready(function(){
   $('#theme').change(function(){
      var title = $("#title").val();
      var theme = $("#theme option:selected").val();

      $("#finaldata").append("<input type='hidden' name='title' value='"+title+"'>");
      $("#finaldata").append("<input type='hidden' name='theme' value='"+theme+"'>");
   })
   //음식
   $('#foodcode').change(function(){
      var areaCode = $("#areafood option:selected").val();
      var foodCode = $("#foodcode option:selected").val();
      var foodCate = $("#foodcode option:checked").text();
      var resultStr = "";
      
      $.ajax({        
           url: 'adminfood.do',
           dataType: 'json',
           type: 'post',
           data : {"areaCode" : areaCode, "foodCode" :foodCode},
           success: function(data){
                 console.log(JSON.stringify(data));
                  if(data.length == 0) {
                     alert("없음");
                     $('#foodlist').append("<label for=''>없음</option>")
                  }else {
                     $('#foodlist').append("<h5>"+foodCate+"</h5>");
                    $.each(data, function(i){ 
                       $("#foodlist").append("<input type ='checkbox' name = 'foodchk' id='food"+data[i].foodNum+"'value = '"+data[i].name+"'>"
                             +"<label for = 'food"+data[i].foodNum+"'>"+data[i].name+"</label>");
                       }); 
                    } 
                  
               },
           error: function(XMLHttpRequest, textStatus, errorThrown) { 
                   alert("검색 결과가 없습니다.");
           }
           });   
   });
   //축제
   $('#areafest').change(function(){
      var areaCode = $("#areafest option:selected").val();
      var date = $("#date-picker").val();
      var resultStr = "";
      
      $.ajax({        
           url: 'adminfest.do',
           dataType: 'json',
           type: 'post',
           data : {"areaCode" : areaCode, "date" :date},
           success: function(data){
                 console.log(JSON.stringify(data));
                  if(data.length == 0) {
                     alert("없음");
                     $('#festlist').append("<label for=''>없음</option>")
                  }else {
                     $('#festlist').empty();
                    $.each(data, function(i){ 
                       $("#festlist").append("<input type ='checkbox' name = 'festchk' id='fest"+data[i].festNum+"'value = '"+data[i].subject+"'>"
                          +"<label for = 'fest"+data[i].festNum+"'>"+data[i].subject+
                          "("+(data[i].fdate1.month+1)+"/"+data[i].fdate1.date+"~"+(data[i].fdate2.month+1)+"/"+data[i].fdate2.date+")</label>");
                       }); 
                    } 
                  
               },
           error: function(XMLHttpRequest, textStatus, errorThrown) { 
                   alert("검색 결과가 없습니다.");
           }
           });   
      $("#finaldata").append("<input type='hidden' name='area' value='"+areaCode+"'>");
   });
      //관광지
      $('#spotcode').change(function(){
         var areaCode = $("#areaspot option:selected").val();
         var spotCode = $("#spotcode option:selected").val();
         var spotCote = $("#spotcode option:selected").text();
         var resultStr = "";
         
         $.ajax({        
              url: 'adminspot.do',
              dataType: 'json',
              type: 'post',
              data : {"areaCode" : areaCode, "spotCode" :spotCode},
              success: function(data){
                    console.log(JSON.stringify(data));
                     if(data.length == 0) {
                        alert("없음");
                        $('#spotlist').append("<label for=''>없음</option>");
                     }else {
                        $('#spotlist').append("<h5>"+spotCote+"</h5>");
                       $.each(data, function(i){    
                          $("#spotlist").append("<input type ='checkbox' name = 'spotchk' id='spot"+data[i].spotNum+"'value = '"+data[i].name+"'>"
                                +"<label for = 'spot"+data[i].spotNum+"'>"+data[i].name+"</label>");
                          }); 
                       } 
                     
                  },
              error: function(XMLHttpRequest, textStatus, errorThrown) { 
                      alert("검색 결과가 없습니다.");
              }
              });   
      });
   $("#foodclear").click(function(){
      $('#foodlist').empty();
   });
   $("#festclear").click(function(){
      $('#festlist').empty();
   });
   $("#spotclear").click(function(){
      $('#spotlist').empty();
   });   
});

   //음식점이 코스에 추가되는거
   $(document).on("change",'input:checkbox[name="foodchk"]',function(){
   
      var id = $(this).attr('id'); 
      
      $('#'+id).attr("checked",true);
      var food = $('#'+id).val();
      var newfood = "<tr class='pricing-list-item pattern ui-sortable-handle' >";
         newfood += "<td>";
         newfood += "<div class='fm-move'><i class='sl sl-icon-cursor-move'></i></div>";
         newfood += "<div class='fm-input pricing-name'><input type='text' value='음식점'/></div>";
         newfood +=  "<div class='fm-input pricing-ingredients'><input type='text' value ='"+food+"'/></div>";
         newfood += "<div class='fm-close'><a class='delete' href='#'><i class='fa fa-remove'></i></a></div>";
         newfood += "</td>";
         newfood += "</tr>";
   
         $("#finalcourse").append(newfood);
         $("#finaldata").append("<input type='hidden' name='food' value='"+food+"'>");    
       
   });
   
   //축제가 코스에 추가되는거
   $(document).on("change",'input:checkbox[name="festchk"]',function(){
   
      var id = $(this).attr('id'); 
      $('#'+id).attr("checked",true);
      var fest = $('#'+id).val();
                     
      var newfest = "<tr class='pricing-list-item pattern ui-sortable-handle' >";
         newfest += "<td>";
         newfest += "<div class='fm-move'><i class='sl sl-icon-cursor-move'></i></div>";
         newfest += "<div class='fm-input pricing-name'><input type='text' value='축제'/></div>";
         newfest +=  "<div class='fm-input pricing-ingredients'><input type='text' value ='"+fest+"'/></div>";
         newfest += "<div class='fm-close'><a class='delete' href='#'><i class='fa fa-remove'></i></a></div>";
         newfest += "</td>";
         newfest += "</tr>";
   
         $("#finalcourse").append(newfest);
         $("#finaldata").append("<input type='hidden' name='fest' value='"+fest+"'>");    
       
   });
   //관광지가 코스에 추가되는거
   $(document).on("change",'input:checkbox[name="spotchk"]',function(){
   
      var id = $(this).attr('id'); 
      $('#'+id).attr("checked",true);
      var spot = $('#'+id).val();
      
      var newspot = "<tr class='pricing-list-item pattern ui-sortable-handle' >";
         newspot += "<td>";
         newspot += "<div class='fm-move'><i class='sl sl-icon-cursor-move'></i></div>";
         newspot += "<div class='fm-input pricing-name'><input type='text' value='관광지'/></div>";
         newspot +=  "<div class='fm-input pricing-ingredients'><input type='text' value ='"+spot+"'/></div>";
         newspot += "<div class='fm-close'><a class='delete' href='#'><i class='fa fa-remove'></i></a></div>";
         newspot += "</td>";
         newspot += "</tr>";
         $("#finalcourse").append(newspot);
         $("#finaldata").append("<input type='hidden' name='spot' value='"+spot+"'>");    
       
   });
   //마지막 체크부분
   var arrayfood = new Array();
   var arrayspot = new Array();
   $(document).on("change",'input:checkbox[name="finalfood"]',function(){
      
      var id = $(this).attr('id'); 
      $('#'+id).attr("checked",true);
      var chk = $('#'+id).val();
      
      arrayfood.push($(this).val());
      
      
   });
   $(document).on("change",'input:checkbox[name="finalspot"]',function(){
      
      var id = $(this).attr('id'); 
      $('#'+id).attr("checked",true);
      var chk = $('#'+id).val();
      
      arrayspot.push($(this).val());
      
      
      
   
   });

   $(function(){
      $("#preview").click(function() {
         $("#finaldata").append("<input type='hidden' name='arrayspot' id='arrayspot' value='"+arrayspot+"'>");
         $("#finaldata").append("<input type='hidden' name='arrayfood' id='arrayfood' value='"+arrayfood+"'>"); 
         //날짜넣기
         var startdate = $("#startdate").val();
         var enddate = $("#enddate").val();

         $("#finaldata").append("<input type='hidden' name='startdate' id='startdate' value='"+startdate+"'>");
         $("#finaldata").append("<input type='hidden' name='enddate' id='enddate' value='"+enddate+"'>");
          
      })
         
   })

</script>
<div class="dashboard-content">

      <!-- Titlebar -->
      <div id="titlebar">
         <div class="row">
            <div class="col-md-12">
               <h2>Add Courses</h2>
            </div>
         </div>
      </div>

      <div class="row">
         <div class="col-lg-12">

            <div id="add-listing">

               <!-- Section -->
               <div class="add-listing-section">

                  <!-- Headline -->
                  <div class="add-listing-headline">
                     <h3><i class="sl sl-icon-doc"></i>Trip Info</h3>
                  </div>

                  <!-- Title -->
                  <div class="row with-forms">
                     <div class="col-md-6">
                        <h5>Course Title <i class="tip" data-tip-content="추천코스의 이름으로 등록됩니다"></i></h5>
                        <input class="search-field" id = "title" type="text" value=""/>
                     </div>
                     
                     <!-- Status -->
                     <div class="col-md-6">
                        <h5>Category</h5>
                        <select class="chosen-select-no-single" id ="theme" >
                           <option label="blank">--선택--</option>   
                           <option value ="child">아이와 함께</option>
                           <option value ="parent">부모님과 함께</option>
                           <option value ="couple">연인과 함께</option>
                           <option value ="firend">친구와 함께</option>
                        </select>
                     </div>
                  </div>

                  
                  <!-- Row / End -->

               </div>
               <!-- Section / End -->
               
               <!-- Section -->
               <div class="add-listing-section margin-top-45">

                  <!-- Headline -->
                  <div class="add-listing-headline">
                     <h3><i class="sl sl-icon-cup"></i>Eat<a href="#" class="button" style="float:right; margin-top:100" id="foodclear">clear</a></h3>
                     
                  </div>
               <div class="row with-forms">
                  <div class="col-md-6">
                           <h5>여행 지역</h5>
                           <select class="chosen-select-no-single" id="areafood" >
                                 <option value = "">--선택--</option>   
                                 <option value ="1">서울</option>
                                 <option value ="2">인천</option>
                                 <option value ="3">대전</option>
                                 <option value ="4">대구</option>
                                 <option value ="5">광주</option>
                                 <option value ="6">부산</option>
                                 <option value ="7">울산</option>
                                 <option value ="8">세종특별자치시</option>
                                 <option value ="31">경기도</option>
                                 <option value ="32">강원도</option>
                                 <option value ="33">충청북도</option>
                                 <option value ="34">충청남도</option>
                                 <option value ="35">경상북도</option>
                                 <option value ="36">경상남도</option>
                                 <option value ="37">전라북도</option>
                                 <option value ="38">전라남도</option>
                                 <option value ="39">제주도</option>
                           </select>
                        </div>
                        
                        <div class="col-md-6">
                           <h5>음식 분류</h5>
                           <select class="chosen-select" id="foodcode">
                              <option value = "">--선택--</option>   
                              <option value ="A05020100">한식</option>
                              <option value ="A05020200">양식</option>
                              <option value ="A05020300">일식</option>
                              <option value ="A05020400">중식</option>
                              <option value ="A05020500">아시아음식점</option>
                              <option value ="A05020600">패밀리레스토랑</option>
                              <option value ="A05020700">이색음식점</option>
                              <option value ="A05020800">채식음식점</option>
                              <option value ="A05020900">바 / 카페</option>
                           </select>
                        </div>
                  
         
                  <div class="col-md-12">
                        <!-- Checkboxes -->
                  <h5 class="margin-top-30 margin-bottom-10"><br/>음식점 선택</h5>
                  <div class="checkboxes in-row margin-bottom-20" id = "foodlist">
                        </div>
                        </div>
                        </div>

               </div>
               <!-- Section / End -->
               
               <!-- Section -->
               <div class="add-listing-section margin-top-45">

                  <!-- Headline -->
                  <div class="add-listing-headline">
                     <h3><i class="sl sl-icon-magic-wand"></i>Festival<a href="#" class="button" style="float:right; margin-top:100" id="festclear">clear</a></h3>
                  </div>
               <div class="row with-forms">
                  <div class="col-md-6">
                           <h5>날짜</h5>
                           <div class="main-search-input-item">
                              <input type="text" id="date-picker" placeholder="Date" readonly="readonly">
                           </div>
                  </div>
                  <div class="col-md-6">
                           <h5>여행 지역</h5>
                           <select class="chosen-select-no-single" id="areafest" >
                                 <option value = "">--선택--</option>   
                                 <option value ="1">서울</option>
                                 <option value ="2">인천</option>
                                 <option value ="3">대전</option>
                                 <option value ="4">대구</option>
                                 <option value ="5">광주</option>
                                 <option value ="6">부산</option>
                                 <option value ="7">울산</option>
                                 <option value ="8">세종특별자치시</option>
                                 <option value ="31">경기도</option>
                                 <option value ="32">강원도</option>
                                 <option value ="33">충청북도</option>
                                 <option value ="34">충청남도</option>
                                 <option value ="35">경상북도</option>
                                 <option value ="36">경상남도</option>
                                 <option value ="37">전라북도</option>
                                 <option value ="38">전라남도</option>
                                 <option value ="39">제주도</option>
                           </select>
                        </div>
                        
                        
                  
         
                  <div class="col-md-12">
                        <!-- Checkboxes -->
                  <h5 class="margin-top-30 margin-bottom-10"><br/>축제 선택</h5>
                  <div class="checkboxes in-row margin-bottom-20" id = "festlist">
                        </div>
                        </div>
                        </div>

               </div>
               <!-- Section / End -->
               
               <!-- Section -->
               <div class="add-listing-section margin-top-45">

                  <!-- Headline -->
                  <div class="add-listing-headline">
                     <h3><i class="sl sl-icon-compass"></i>Travel Spot<a href="#" class="button" style="float:right; margin-top:100" id="spotclear">clear</a></h3>
                  </div>
               <div class="row with-forms">
                  <div class="col-md-6">
                           <h5>여행 지역</h5>
                           <select class="chosen-select-no-single" id="areaspot" >
                                 <option value = "">--선택--</option>   
                                 <option value ="1">서울</option>
                                 <option value ="2">인천</option>
                                 <option value ="3">대전</option>
                                 <option value ="4">대구</option>
                                 <option value ="5">광주</option>
                                 <option value ="6">부산</option>
                                 <option value ="7">울산</option>
                                 <option value ="8">세종특별자치시</option>
                                 <option value ="31">경기도</option>
                                 <option value ="32">강원도</option>
                                 <option value ="33">충청북도</option>
                                 <option value ="34">충청남도</option>
                                 <option value ="35">경상북도</option>
                                 <option value ="36">경상남도</option>
                                 <option value ="37">전라북도</option>
                                 <option value ="38">전라남도</option>
                                 <option value ="39">제주도</option>
                           </select>
                        </div>
                        
                        <div class="col-md-6">
                           <h5>관광지 분류</h5>
                           <select class="chosen-select" id="spotcode">
                              <option value = "">--선택--</option>   
                              <option value ="A01010100">공원</option>
                              <option value ="A01010400">산</option>
                              <option value ="A01010500">자연생태관광지</option>
                              <option value ="A01010600">자연휴양림</option>
                              <option value ="A01010700">수목원</option>
                              <option value ="A01010800">폭포</option>
                              <option value ="A01010900">계곡</option>
                              <option value ="A01011000">약수터</option>
                              <option value ="A01011100">해안절경</option>
                              <option value ="A01011200">해수욕장</option>
                              <option value ="A01011300">섬</option>
                              <option value ="A01011400">항구/포구</option>
                              <option value ="A01011500">어촌</option>
                              <option value ="A01011600">등대</option>
                              <option value ="A01011700">호수</option>
                              <option value ="A01011800">강</option>
                              <option value ="A01011900">동굴</option>
                           </select>
                        </div>
                  
         
                  <div class="col-md-12">
                        <!-- Checkboxes -->
                  <h5 class="margin-top-30 margin-bottom-10"><br/>관광지 선택</h5>
                  <div class="checkboxes in-row margin-bottom-20" id = "spotlist">
                        </div>
                        </div>
                        </div>

               </div>
               <!-- Section / End -->
               
               <!-- Section -->
               <div class="add-listing-section margin-top-45">

                  <!-- Headline -->
                  <div class="add-listing-headline">
                     <h3><i class="sl sl-icon-location"></i> Trip Detail</h3>
                  </div>

                  <div class="submit-section">

                     <!-- Row -->
                     <div class="row with-forms">

                        <!-- City -->
                        <div class="col-md-4">
                           <h5>여행 지역</h5>
                           <select class="chosen-select-no-single" id="finalarea" >
                                 <option value = "">지역 선택</option>   
                                 <option value ="1">서울</option>
                                 <option value ="2">인천</option>
                                 <option value ="3">대전</option>
                                 <option value ="4">대구</option>
                                 <option value ="5">광주</option>
                                 <option value ="6">부산</option>
                                 <option value ="7">울산</option>
                                 <option value ="8">세종특별자치시</option>
                                 <option value ="31">경기도</option>
                                 <option value ="32">강원도</option>
                                 <option value ="33">충청북도</option>
                                 <option value ="34">충청남도</option>
                                 <option value ="35">경상북도</option>
                                 <option value ="36">경상남도</option>
                                 <option value ="37">전라북도</option>
                                 <option value ="38">전라남도</option>
                                 <option value ="39">제주도</option>
                           </select>
                        </div>

                        <!-- Address -->
                        <div class="col-md-4">
                           <h5>여행 날짜</h5>
                           <input type="text" id="startdate" placeholder="20190101" >
                        </div>
                        <div class="col-md-4">
                           <h5>여행 날짜</h5>
                           <input type="text" id="enddate"  placeholder="20191231" >
                        </div>
                  <div class="col-md-12">
                        <!-- Checkboxes -->
                  <h5 class="margin-top-30 margin-bottom-10"><br/>선호 관광지<span>(optional)</span></h5>
                  <div class="checkboxes in-row margin-bottom-20">
               
                     <input id="A01010100" type="checkbox" name="finalspot" value="A01010100">
                     <label for="A01010100">공원</label>

                     <input id="A01010400" type="checkbox" name="finalspot" value="A01010400">
                     <label for="A01010400">산</label>

                     <input id="A01010500" type="checkbox" name="finalspot" value="A01010500">
                     <label for="A01010500">자연생태관광지</label>

                     <input id="A01010600" type="checkbox" name="finalspot" value="A01010600">
                     <label for="A01010600">자연휴양림</label>

                     <input id="A01010700" type="checkbox" name="finalspot" value="A01010700" >
                     <label for="A01010700">수목원</label>

                     <input id="A01010800" type="checkbox" name="finalspot" value="A01010800">
                     <label for="A01010800">폭포</label>

                     <input id="A01010900" type="checkbox" name="finalspot" value="A01010900">
                     <label for="A01010900">계곡</label>   

                     <input id="A01011000" type="checkbox" name="finalspot" value="A01011000">
                     <label for="A01011000">약수터</label>
                     
                     <input id="A01011100" type="checkbox" name="finalspot" value="A01011100">
                     <label for="A01011100">해안절경</label>
                     
                     <input id="A01011200" type="checkbox" name="finalspot" value="A01011200">
                     <label for="A01011200">해수욕장</label>
                     
                     <input id="A01011300" type="checkbox" name="finalspot" value="A01011300">
                     <label for="A01011300">섬</label>
                     
                     <input id="A01011400" type="checkbox" name="finalspot" value="A01011400">
                     <label for="A01011400">항구/포구</label>
                     
                     <input id="A01011500" type="checkbox" name="finalspot" value="A01011500">
                     <label for="A01011500">어촌</label>
                     
                     <input id="A01011600" type="checkbox" name="finalspot" value="A01011600">
                     <label for="A01011600">등대</label>
                     
                     <input id="A01011700" type="checkbox" name="finalspot" value="A01011700">
                     <label for="A01011700">호수</label>
                     
                     <input id="A01011800" type="checkbox" name="finalspot" value="A01011800">
                     <label for="A01011800">강</label>
                     
                     <input id="A01011900" type="checkbox" name="finalspot" value="A01011900">
                     <label for="A01011900">동굴</label>
                  </div>
                  </div>
                  <!-- Checkboxes / End -->
                  <!-- Checkboxes -->
                  <div class="col-md-6">
                  <h5 class="margin-top-30 margin-bottom-10">선호 음식<span>(optional)</span></h5>
                  <div class="checkboxes in-row margin-bottom-20">
               
                     <input id="A05020100" type="checkbox" name="finalfood" value="A05020100">
                     <label for="A05020100">한식</label>

                     <input id="A05020200" type="checkbox" name="finalfood" value="A05020200">
                     <label for="A05020200">양식</label>

                     <input id="A05020300" type="checkbox" name="finalfood" value="A05020300">
                     <label for="A05020300">일식</label>

                     <input id="A05020400" type="checkbox" name="finalfood" value="A05020400">
                     <label for="A05020400">중식</label>

                     <input id="A05020500" type="checkbox" name="finalfood" value="A05020500">
                     <label for="A05020500">아시아식</label>

                     <input id="A05020600" type="checkbox" name="finalfood" value="A05020600">
                     <label for="A05020600">패밀리레스토랑</label>

                     <input id="A05020700" type="checkbox" name="finalfood" value="A05020700">
                     <label for="A05020700">이색음식점</label>   

                     <input id="A05020800" type="checkbox" name="finalfood" value="A05020800">
                     <label for="A05020800">채식전문점</label>
                     
                     <input id="A05020900" type="checkbox" name="finalfood" value="A05020900">
                     <label for="A05020900">바/카페</label>
                  </div>
                  </div>

                     </div>
                     <!-- Row / End -->

                  </div>
               </div>
               <!-- Section / End -->



               <!-- Section -->
               <div class="add-listing-section margin-top-45">
                  
                  <!-- Headline -->
                  <div class="add-listing-headline">
                     <h3><i class="sl sl-icon-book-open"></i>Schedule</h3>
                     <!-- Switcher -->
                     <label class="switch"><input type="checkbox" checked><span class="slider round"></span></label>
                  </div>
                  <!-- Switcher ON-OFF Content -->
                  <div class="switcher-content">

                     <div class="row">
                        <div class="col-md-12">
                           <table id="pricing-list-container" >
                              <tbody class="ui-sortable" id ="finalcourse">
                              </tbody>
                           </table>
                        </div>
                     </div>

                  </div>
                  <!-- Switcher ON-OFF Content / End -->

               </div>
               <!-- Section / End -->

               <form action = "chkCourse" id = "finaldata">
               
               <input type="submit"  class="button preview" value="submit" id="preview"/> 
               </form>

            </div>
         </div>

         <!-- Copyrights -->
         <div class="col-md-12">
            <div class="copyrights">© 2019 Listeo. All Rights Reserved.</div>
         </div>

      </div>

   </div>