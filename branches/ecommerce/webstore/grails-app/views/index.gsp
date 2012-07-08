<!doctype html>
<html>
<head>
<meta name="layout" content="main" />
<title>Web Store</title>
<link rel="stylesheet"
	href="${resource(dir: 'css', file: 'orbit-1.2.3.css')}" type="text/css">
<script src="${resource(dir: 'js', file: 'jquery.orbit-1.2.3.min.js')}"></script>

<!--[if IE]>
		<style type="text/css">
		   .timer { display: none !important; }
		   div.caption { background:transparent; filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000,endColorstr=#99000000);zoom: 1; }
		</style>
	<![endif]-->

<!-- Run the plugin -->
<script type="text/javascript">
	$(window).load(function() {
		//$('#featured').orbit();
		$('#top-banner-slider').orbit({
			animation : 'fade', // fade, horizontal-slide, vertical-slide, horizontal-push
			animationSpeed : 1200, // how fast animations are
			timer : true, // true or false to have the timer
			advanceSpeed : 2000, // if timer is enabled, time between transitions
			pauseOnHover : true, // if you hover pauses the slider
			startClockOnMouseOut : true, // if clock should start on MouseOut
			startClockOnMouseOutAfter : 1000, // how long after MouseOut should the timer start again
			directionalNav : true, // manual advancing directional navs
			captions : false, // do you want captions?
			captionAnimation : 'fade', // fade, slideOpen, none
			captionAnimationSpeed : 800, // if so how quickly should they animate in
			bullets : true, // true or false to activate the bullet navigation
			bulletThumbs : true, // thumbnails for the bullets
			bulletThumbLocation : '', // location from this file where thumbs will be
			afterSlideChange : function() {
			} // empty function
		});
	});
</script>
</head>
<body>
		<div id="top-bar">
			<div id="top-bar-content">
				<h2>Free Shipping with every order.</h2>
			</div>
		</div>
		
		<hr/>
		
		<div style="padding-top: 5px;">
			<div id="top-banner-slider">
				<div class="top-banner-slider-content">
					<h1>Orbit does content now.</h1>
					<h3>Highlight me...I'm text.</h3>
				</div>
				<img
					src="${resource(dir: 'images/site/home/banner', file: 'overflow.jpg')}" />
				<img
					src="${resource(dir: 'images/site/home/banner', file: 'captions.jpg')}"
					data-caption="#htmlCaption" /> <img
					src="${resource(dir: 'images/site/home/banner', file: 'features.jpg')}" />
			</div>
			<!-- Captions for Orbit -->
			<span class="orbit-caption" id="htmlCaption"><strong>I'm
					A Badass Caption:</strong> I can haz <a href="#">links</a>, <em>style</em>
				or anything that is valid markup :) </span> <br /> <br /> <br />
		</div>

		<div class="clearfix shadow"
			style="padding-top: 5px; margin-top: 10px;">

			<div class="row">
					<div class="fourcol box-small">
						<!-- title -->
						<h2 class="title">
							Gemstone
						</h2>
						<div id="content">
							<div class="left" style="max-width: 200px;">
								<ul class="ullist">
									<li>
										<a href="#">Gemstones</a></li>
									<li>
										<a href="#">Gemstones</a></li>	
								</ul>
							</div>
							<div class="right">
								<img
									src="${resource(dir: 'images/site/home', file: 'gem-stones.jpg')}"
									style="width: 180px; height: 120px; padding: 5px; margin-top: 25px; display: block;" />
							</div>
						</div>
					</div>

					<div class="fourcol box-small">
						<!-- title -->
						<h2 class="title">
							Jewelry
						</h2>
						<div id="content">
							<div class="left" style="max-width: 200px;">
								<ul class="ullist">
									<li>
										<a href="#">Diamond Jewelry</a></li>
									<li>
										<a href="#">Gemstone Jewelry</a></li>
									<li>
										<a href="#">Artificial Jewelry</a></li>
								</ul>
							</div>
							<div class="right">
								<img
									src="${resource(dir: 'images/site/home', file: 'Dia_Pendant_w_Chain.jpg')}"
									style="width: 180px; height: 120px; padding: 5px; margin-top: 25px; display: block;" />
							</div>
						</div>
					</div>

					<div class="fourcol last box-small">
						<!-- title -->
						<h2 class="title">
							Diamonds
						</h2>
						<div id="content">
							<div class="left" style="max-width: 200px;">
								<ul class="ullist">
									<li>
										<a href="#">Search Diamonds</a></li>
									<li>
										<a href="#">Education</a></li>
								</ul>
							</div>
							<div class="right">
								<img
									src="${resource(dir: 'images/site/home', file: 'Diamond_Bracelet.jpg')}"
									style="width: 180px; height: 120px; padding: 5px; margin-top: 25px; display: block;" />
							</div>
						</div>
					</div>

			</div>

			<div class="clearfix"></div>
			
			<hr/>

			<div class="row">
			<div class="fourcol">
				<h2 class="title">Stock List</h2>
				<div id="contents">
					<ul class="ullist" style="z-index: 1000;">
						<li><a href="#">List 1</a></li>
						<li><a href="#">List 2</a></li>
					</ul>
				</div>
			</div>
			<div class="eightcol last">
					<h3>Diamond Search</h3>
					<div id="contents">
						<br /> <br />
					</div>
				</div>
			</div>

			<hr/>

			<div class="clearfix"
			style="padding-top: 5px; margin-top: 10px;">

			<div class="row">
					<div class="fourcol box-small">
						<!-- title -->
						<h2 class="title">
							Recent Articles
						</h2>
						<div id="content">
							<div style="max-width: 300px;">
								<ul class="ullist">
									<li class="recent_article">
										Nature, color, global, feminine–it’s your time to shine with the hottest trends.
										<a class="read_more" href="#">read more</a>	
									</li>
									<li class="recent_article">
										Nature, color, global, feminine–it’s your time to shine with the hottest trends.
										<a class="read_more" href="#">read more</a>	
									</li>
									<li class="recent_article">
										Nature, color, global, feminine–it’s your time to shine with the hottest trends.
										<a class="read_more" href="#">read more</a>	
									</li>	
								</ul>
							</div>
						</div>
					</div>

					<div class="fourcol box-small">
						<!-- title -->
						<h2 class="title">
							Testimonials
						</h2>
						<div id="content">
							<div style="max-width: 300px;">
								<ul class="ullist">
									<li class="testimonial">
										Nature, color, global, feminine–it’s your time to shine with the hottest trends.
										Nature, color, global, feminine–it’s your time to shine with the hottest trends.
										Nature, color, global, feminine–it’s your time to shine with the hottest trends.
										Nature, color, global, feminine–it’s your time to shine with the hottest trends.
										<a class="read_more" href="#">read more</a>	
									</li>
								</ul>
							</div>
						</div>
					</div>

					<div class="fourcol last box-small">
						<!-- title -->
						<h3 class="title">
							Trends
						</h3>
						<div id="content">
							<div style="max-width: 300px;">
								<ul class="ullist">
									<li class="testimonial">
										Nature, color, global, feminine–it’s your time to shine with the hottest trends.
										<a class="read_more" href="#">read more</a>	
									</li>
								</ul>
							</div>
						</div>
						
						<hr/>
						
						<h3 class="title">
							New Additions
						</h3>
						<div id="content">
							<div style="max-width: 300px;">
								<ul class="ullist">
									<li class="testimonial">
										Nature, color, global, feminine–it’s your time to shine with the hottest trends.
										<a class="read_more" href="#">read more</a>	
									</li>
								</ul>
							</div>
						</div>
					</div>

			</div>

			<div class="clearfix"></div>
		</div>
	</div>
</body>
</html>
