<%@page import="java.util.List"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.json.simple.JSONArray"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>
	

<!DOCTYPE html>
<html>
    <head>

        <!-- /.website title -->
        <title>전시 상세</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

        <meta charset="UTF-8" />
        <!-- CSS Files -->
        <link href="/sist/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="/sist/css/font-awesome.min.css" rel="stylesheet">
        <link href="/sist/fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
        <link href="/sist/fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
        <link href="/sist/css/animate.css" rel="stylesheet" media="screen">
        <link href="/sist/css/owl.theme.css" rel="stylesheet">
        <link href="/sist/css/owl.carousel.css" rel="stylesheet">
        <link href="/sist/css/bootstrap-datetimepicker.min.css" rel="stylesheet">

        <!-- Colors -->
        <!-- <link href="css/css-index-blue.css" rel="stylesheet" media="screen"> -->
        <!-- <link href="css/css-index-green.css" rel="stylesheet" media="screen"> -->
        <!-- <link href="css/css-index-purple.css" rel="stylesheet" media="screen"> -->
        <!-- <link href="css/css-index-red.css" rel="stylesheet" media="screen"> -->
        <!-- <link href="css/css-index-orange.css" rel="stylesheet" media="screen"> -->
        <link href="/sist/css/css-index-yellow.css" rel="stylesheet" media="screen"> 

        <!-- Google Fonts -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic" />

    </head>



    <body data-spy="scroll" data-target="#navbar-scroll">


        <!-- /.preloader -->
        <div id="preloader"></div>
        <div id="top"></div>

        <!-- /.parallax full screen background image -->
        <div class="fullscreen landing parallax blog-page" style="background-image:url('http://localhost/sist/images/bg-baner.jpg');" data-img-width="2000" data-img-height="1333" data-diff="100">

            <div class="overlay">
                <div class="container">
                    <div class="col-md-10 col-md-offset-1 text-center">

                        <!-- /.logo -->
                        <div class="logo wow fadeInDown" style="margin-top: 50px"> 
                            <a href="user_index.do">Exhibition</a>
                        </div>

                        <!-- /.main title -->
                      

                    </div>
                </div> 
            </div> 
        </div>
        
        
             <!-- NAVIGATION -->
        <div id="menu">
               <div class="container"> 
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-backyard">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand site-name" href="user_index.do">Exhibition</a>
                    </div>

                    <div id="navbar-scroll" class="collapse navbar-collapse navbar-backyard navbar-right">
                        <ul class="nav navbar-nav">
                               <li><a href="list.do">전체 전시 보기</a></li>
                            <li><a href="loc.do">지역별 전시 보기</a></li>
                            <li><a href="reservation.do">예약하기</a></li>
                                    <li><a href="list.do">게시판</a></li>
                        
                        </ul>
                    </div>
                 </div>  
        </div>
          <c:forEach var="exhibitionView" items="${ exhibitionView }">
         <div id="carssection">
            <div class="container">
              
          <div class="row carssections">
                        <div class="screen wow fadeInUp" data-path-hover="m 180,34.57627 -180,0 L 0,0 180,0 z">
                            <figure >
                                <div class="screen wow fadeInUp" style="position:absolute; left:350px; width: 900px; height: 400px"><strong>${ exhibitionView.ex_num }. ${ exhibitionView.ex_name}</strong><br/>${ exhibitionView.ex_intro }</div>
                                <img src="http://localhost/sist/img/${ exhibitionView.exhibition_poster }" style="width:300px"/>
                             <a href="list.do"><input type="button"  value="예약" style="width:260px; background-color: #F0AD4E;color:#ffffff; border:0px ;margin-left: 500px"></a> 
                               <%--  <a href="catBoard.do?cat_num=${ exhibitionView.cat_num }"> --%>
                               <a href="list.do"><input type="button"   value="후기" style="width:260px; margin-left: 15px ;background-color: #F0AD4E;color:#ffffff; border:0px"></a> 
                            
                            </figure>
                        </div>   
                        </div>
                        </div>
                        </div>
                        <!-- 전시 상세 -->
             	<div class="container" style="width: 1200px; height: 1500px; background-color: #ffffff ;border:1px solid #E5E5E5">
             	
             	<img src="http://localhost/sist/img/${ exhibitionView.add_Img }" style="width:100%; height:500px; "/><br/><br/>
             	<div id="output"></div>${ exhibitionView.ex_info }

             	<div id="map" style="width:70%;height:350px; margin-left: 150px; margin-top: 100px"></div>
             	</div>
          </c:forEach>
             	
           <!-- /.footer -->
        <footer id="footer" >
            <div class="footer-top">
                <div class="container">
                    <div class="">
                        <div class="col-md-4 col-sm-6">
                            <h4>고객 센터</h4>
                            <p><strong>3조</strong>
                                <br>전화 번호 :081) 123-1234  
                                <br>상담 가능 시간: AM 10:00~PM 05:00
                                <br>관련 이메일: exhibition@naver.com
                            </p>
                            <hr class="hidden-md hidden-lg">
                        </div> 

                        
                        <!-- /.col-md-4 -->
                        
                        <div class="col-md-4 col-sm-6">
                            <h4>사업자 등록번호</h4>
                            <div class="newsletter-box">
                                <div class="newsletter">  
                                    <div class="newsletter-content"> 
                                        <p>123-1234-1234</p>
                                    </div> 
                                    
                                    <div class="clear"> </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.col-md-4 -->

                    </div>
                    </div>
                    </div>
                    </footer>
       


        <!-- /.javascript files -->
        <script src="/sist/js/jquery.js"></script>
        <script src="/sist/js/bootstrap.min.js"></script>
        <script src="/sist/js/bootstrap-datetimepicker.min.js"></script>
        <script src="/sist/js/custom.js"></script>
        <script src="/sist/js/jquery.sticky.js"></script>
        <script src="/sist/js/wow.min.js"></script>
        <script src="/sist/js/owl.carousel.min.js"></script>
           <script src="/sist/js/jquery.validate.min.js"></script> 



	<script>
		new WOW().init();
		$('#date_time').datetimepicker({
			format : 'dd/MM/yyyy hh:mm:ss',
			language : 'en-US',
			pickDate : true, // disables the date picker
			pickTime : true
		});
	</script>
        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=33a56ba20c73caaac66039b100edcde8"></script>
       <script>
            (function () {
                function init() {
                    var speed = 250,
                            easing = mina.easeinout;
                    [].slice.call(document.querySelectorAll('#carssections > div')).forEach(function (el) {
                        var s = Snap(el.querySelector('svg')), path = s.select('path'),
                                pathConfig = {
                                    from: path.attr('d'),
                                    to: el.getAttribute('data-path-hover')
                                };

                        el.addEventListener('mouseenter', function () {
                            path.animate({'path': pathConfig.to}, speed, easing);
                        });

                        el.addEventListener('mouseleave', function () {
                            path.animate({'path': pathConfig.from}, speed, easing);
                        });
                    });
                }
                init();
            })();
        </script>
        <script>
  <c:forEach var="exListView" items="${ exListView }">
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(${ mapView.latitude },${ mapView.longitude }), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };
</c:forEach>
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
  <c:forEach var="exListView" items="${ exListView }">
var markerPosition  = new kakao.maps.LatLng(${ mapView.latitude },${ mapView.longitude }); 
</c:forEach>
// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);    
</script>
    </body>
</html>