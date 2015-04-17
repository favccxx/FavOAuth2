<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/commonInclude.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>白富美交友</title>
<link rel="stylesheet" href="<%=basePath %>assets/css/home_client.css" type="text/css" media="screen" />
<%-- <link rel="stylesheet" type="text/css" href="<%=basePath %>print.css" media="print" /> --%>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script> 
<script type="text/javascript" src="<%=basePath %>assets/js/equalcolumns.js"></script> 
</head>
<body>
	<header>
		<h1>CoffeeCols</h1>
	</header>
	<nav>
		<ul>
			<li class="selected"><a href="#">Home</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Products</a></li>
			<li><a href="#">Contact</a></li>
			<li><a href="#">Support</a></li>
		</ul>
	</nav>
	<section id="intro">
		<header>
			<h2>Your Spiffy Tag Line Goes Here</h2>
		</header>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut.</p>
		<img src="images/introimage.png" alt="lime" />
	</section>
	
	<section id="content">
				<ul class="column">
				    <!--eqblock-->
				    <li>
				        <section class="block">
									<a href="#"><img src="<%=basePath %>assets/images/1-thumb.jpg" alt=""  /></a> 
										<h2><a href="#">Coffee 101</a></h2> 
										<p>Proin metus odio, ultricies eu pharetra dictum, laoreet id odio. Curabitur in odio augue. Morbi congue auctor interdum. Phasellus sit amet metus justo. </p> 
				        </section>
				    </li>

				    <!--eqblock-->
				    <li>
				        <section class="block">
									<a href="#"><img src="<%=basePath %>assets/images/2-thumb.jpg" alt=""  /></a> 
										<h2><a href="#">All About Beans</a></h2> 
										<p>Morbi congue auctor interdum. Proin metus odio, ultricies eu pharetra dictum, laoreet id odio. Curabitur in odio augue. Phasellus sit amet metus justo. </p> 
				        </section>
				    </li>

				    <!--eqblock-->
				    <li>
				        <section class="block">
									<a href="#"><img src="<%=basePath %>assets/images/3-thumb.jpg" alt=""  /></a> 
										<h2><a href="#">Compatible Foods</a></h2> 
										<p>Phasellus sit amet metus justo. Proin metus odio, ultricies eu pharetra dictum, laoreet id odio. Curabitur in odio augue. Morbi congue auctor. </p> 
				        </section>
				    </li>

				    <!--eqblock-->
				    <li>
				        <section class="block">
									<a href="#"><img src="<%=basePath %>assets/images/4-thumb.jpg" alt=""  /></a> 
										<h2><a href="#">Coffee Sizzle</a></h2> 
										<p>Proin metus odio, ultricies eu pharetra dictum, laoreet id odio. Morbi congue auctor interdum. Curabitur in odio augue. Phasellus sit amet metus justo. </p> 
				        </section>
				    </li>

				    <!--eqblock-->
				    <li>
				        <section class="block">
									<a href="#"><img src="<%=basePath %>assets/images/5-thumb.jpg" alt=""  /></a> 
										<h2><a href="#">Tools of the Trade</a></h2> 
										<p>Curabitur in odio augue. Proin metus odio, ultricies eu pharetra dictum, laoreet id odio. Morbi congue auctor interdum. Phasellus sit amet metus justo. </p> 
				        </section>
				    </li>

				    <!--eqblock-->
				    <li>
				        <section class="block">
									<a href="#"><img src="<%=basePath %>assets/images/6-thumb.jpg" alt=""  /></a> 
										<h2><a href="#">The Art of Making Coffee</a></h2> 
										<p>Proin metus odio, ultricies eu pharetra dictum, laoreet id odio. Phasellus sit amet metus justo. Curabitur in odio augue. Morbi congue auctor interdum.  </p> 
				        </section>
				    </li>

				    <!--eqblock-->
				    <li>
				        <section class="block">
									<a href="#"><img src="<%=basePath %>assets/images/7-thumb.jpg" alt=""  /></a> 
										<h2><a href="#">Coffee Style</a></h2> 
										<p>Proin metus odio, ultricies eu pharetra dictum, laoreet id odio. Curabitur in odio augue. Morbi congue auctor interdum. Phasellus sit amet metus justo. </p> 
				        </section>
				    </li>
				</ul>
		</section>
		
	<footer>
    <section>
    <h3>Left Stuff</h3>
    <p>Left aligned text here. Proin metus odio, ultricies eu pharetra dictum, laoreet id odio. Curabitur in odio augue. Morbi congue auctor interdum. Phasellus sit amet metus justo.</p>
    <p>Next line here</p>
    </section>
    
    <section>
    <h3>Center Stuff</h3>
    <p>Center Text here. Proin metus odio, ultricies eu pharetra dictum, laoreet id odio. Curabitur in odio augue. Morbi congue auctor interdum. Phasellus sit amet metus justo.</p>
    <p>Next line here</p>
    </section>
    
    <section>
    <h3>Right Stuff</h3>
    <p>&copy; 2010 <a href="#" title="your site name">yoursite.com</a> All rights reserved.</p>
    <p>Center Text here. Proin metus odio, ultricies eu pharetra dictum, laoreet id odio. Curabitur in odio augue. Morbi congue auctor interdum. Phasellus sit amet metus justo.</p>
    </section>

	</footer>
</body>
</html>