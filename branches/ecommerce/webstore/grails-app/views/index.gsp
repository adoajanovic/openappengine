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
			captions : true, // do you want captions?
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

	<div class="clearfix shadow">
		<div id="top-bar">
			<div id="top-bar-content">
				<h2>Free Shipping with every order.</h2>
			</div>
		</div>

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
				<section>
					<div class="fourcol box-small">
						<!-- title -->
						<h3>Gemstones</h3>
						<div id="content">
							<br /> <br /> <br /> <br />
						</div>
					</div>
				</section>

				<section>
					<div class="fourcol box-small">
						<!-- title -->
						<h3>Jewelry</h3>
						<div id="contents">
							<br /> <br /> <br /> <br />
						</div>
					</div>
				</section>

				<section>
					<div class="fourcol box-small">
						<!-- title -->
						<h3>Diamonds</h3>
						<div id="contents">
							<br /> <br /> <br /> <br />
						</div>
					</div>
				</section>

			</div>

			<div class="clearfix"></div>

			<div class="row" style="height:50px;">
				<div class="fourcol" style="border: 1px solid #D9DCDC;">
					<h3>Stock List</h3>
					<div id="contents">
						<br /> <br /> 
					</div>
				</div>
				<div class="eightcol last" style="border: 1px solid #D9DCDC;">
					<h3>Diamond Search</h3>
					<div id="contents">
						<br /> <br /> 
					</div>
				</div>
			</div>

			<div class="clearfix"></div>

			<div class="row">
				<section>
					<div class="fourcol box-small">
						<!-- title -->
						<h3>Featured Articles</h3>
						<div id="content">
							<ul>
								<li>This is Inland, the first in a new series of HTML/CSS
									templates.This is Inland, the first in a new series of HTML/CSS
									templates...</li>
								<li>This is Inland, the first in a new series of HTML/CSS
									templates.This is Inland, the first in a new series of HTML/CSS
									templates...</li>
							</ul>
						</div>
					</div>
				</section>

				<section>
					<div class="fourcol box-small">
						<!-- title -->
						<h3>Jewelry</h3>
						<div id="contents">
							<br /> <br /> <br /> <br />
						</div>
					</div>
				</section>

				<section>
					<div class="fourcol box-small">
						<!-- title -->
						<h3>Diamonds</h3>
						<div id="contents">
							<br /> <br /> <br /> <br />
						</div>
					</div>
				</section>

			</div>
			
			<div class="clearfix"></div>
		</div>
	</div>
</body>
</html>
