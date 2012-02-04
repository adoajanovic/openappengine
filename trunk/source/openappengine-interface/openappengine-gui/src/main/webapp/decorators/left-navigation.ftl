<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html>

<#--NOTE: this is the webapp/decorators/spring.ftl-->
<#import "spring.ftl" as spring/>
<#import "../WEB-INF/freemarker/common.ftl" as common/>

<head>
  	  <!--default.ftl-->
	  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
	  
	   <style type="text/css" media="screen">
        <!--
        BODY { margin: 10px; padding: 0; font: 1em "Trebuchet MS", verdana, arial, sans-serif; font-size: 100%; }
        DIV.container { margin: auto; width: 90%; margin-bottom: 10px;}
        TEXTAREA { width: 80%;}
        FIELDSET { border: 1px solid #ccc; padding: 1em; margin: 0; }
        LEGEND { color: #ccc; font-size: 120%; }
        INPUT, TEXTAREA { font-family: Arial, verdana; font-size: 125%; padding: 7px; border: 1px solid #999; }
        LABEL { display: block; margin-top: 10px; } 
        IMG { margin: 5px; }

        h2 {
            margin: 0;
        }

        .drawers-wrapper {
            position: relative;
            width: 188px;
            
        }

        .drawer {
            background:transparent url(http://images.apple.com/downloads/images/sideboxlight_bg20070611.gif) repeat-y scroll 0pt;
            color:#76797C;
            font-size:11px;
            line-height:1.3em;
        }

        .boxcap {
            height:5px;
            left:0pt;
            position:absolute;
            width:100%;
            z-index:100;
            background:transparent url(http://images.apple.com/downloads/images/sidenav_capbottom.png) no-repeat scroll 0%;
            margin-top:-5px;
        }

        .captop {
            background-image:url(http://images.apple.com/downloads/images/box_188captop.png);
            bottom:auto;
            top:0pt;
            margin-top:0;
        }

        .drawers {
            margin-bottom:15px;
            color:#76797C;
            font-size:11px;
            line-height: 18px;
        }

        .drawers A {
            color:#666666;
            text-decoration:none;
            font-family:"Lucida Grande",Geneva,Arial,Verdana,sans-serif;
            font-size-adjust:none;
            font-style:normal;
            font-variant:normal;
            font-weight:normal;
        }

        .drawer li {
            border-bottom:1px solid #E5E5E5;
            line-height:16px;
            padding:6px 0pt;
        }

        UL {
            list-style: none;
            padding: 0;
        }

        UL.drawers {
            margin: 0;
        }

        .drawer-handle {
            background:#939393 url(http://images.apple.com/downloads/images/slider_handlebg188.png) no-repeat scroll 0pt;
            color:#333333;
            cursor:default;
            font-size:12px;
            font-weight:normal;
            height:25px;
            line-height:25px;
            margin-bottom:0pt;
            text-indent:15px;
            width:100%;
        }

        .drawer-handle.open {
            background-color:#72839D;
            background-position:-188px 0pt;
            color:#FFFFFF;
        }

        .drawer UL {
            padding: 0 12px;
            padding-bottom:0pt;
        }

        .drawer-content UL {
            padding-top: 7px;
        }

        .drawer-content LI A {
            display:block;
            overflow:hidden;
        }

        .alldownloads li {
            border:0pt none;
            line-height:18px;
            padding:0pt;
        }
        -->
        </style>
	  
	  
	  <!-- default css -->
	  <link rel="stylesheet" href="${rc.getContextPath()}/resources/css/styles.css">
	  
	  <!-- FavIcon -->
	  <link rel="shortcut icon" href="${rc.getContextPath()}/resources/favicon.ico" type="image/x-icon" />
	  
	  <!-- jquery css and js -->
	  <link rel="stylesheet" href="${rc.getContextPath()}/resources/jquery/themes/base/jquery.ui.all.css">
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/jquery-1.6.2.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.position.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.core.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.widget.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.button.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.tabs.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.dialog.js"></script>
	  
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.accordian.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.dimensions.js"></script>
	  
	</head>

	<body>
		<!-- Left Menu -->
		<div  id="left-menu">
		    <div class="drawers-wrapper">
        <div class="boxcap captop"></div>
    <ul class="drawers">
        <li class="drawer">
            <h2 class="drawer-handle open">Quick Links</h2>
        </li>
        <li class="drawer">
            <h2 class="drawer-handle">Example</h2>
            <ul>
                <li><a title="iTunes 7.5" href="http://www.apple.com/itunes/download/">1. iTunes 7.5</a></li>
                <li><a title="QuickTime 7.3.1" href="http://www.apple.com/quicktime/download/">2. QuickTime 7.3.1</a></li>
                <li><a title="Safari 3 Public Beta" href="http://www.apple.com/safari/download/">3. Safari 3 Public Beta</a></li>
                <li><a title="MacPool" href="/downloads/macosx/games/simulation_and_sports/macpool.html">4. MacPool Realistic and easy to play computer simu…</a></li>
                <li><a title="Guitar Hero III: Legends of Rock" href="/downloads/macosx/games/demos_updates/guitarheroiiilegendsofrock.html">5. Guitar Hero III: L…</a></li>
                <li><a title="Messenger for Mac" href="/downloads/macosx/email_chat/messengerformac.html">6. Messenger for Mac</a></li>
                <li><a title="Google Earth" href="/downloads/macosx/home_learning/googleearth.html">7. Google Earth</a></li>
                <li><a title="Monopoly" href="/downloads/macosx/games/cards_puzzle/monopoly.html">8. Monopoly</a></li>
            </ul>
        </li>
        
        <li class="drawer last">
            <h2 class="drawer-handle">Top Apple Downloads</h2>
            <ul>
                <li><a title="iTunes 7.5" href="http://www.apple.com/itunes/download/">1. iTunes 7.5</a></li>
                <li><a title="QuickTime 7.3.1" href="http://www.apple.com/quicktime/download/">2. QuickTime 7.3.1</a></li>
                <li><a title="Safari 3 Public Beta" href="http://www.apple.com/safari/download/">3. Safari 3 Public Beta</a></li>
                <li><a title="Mac OS X 10.5.1 Update" href="/downloads/macosx/apple/macosx_updates/macosx1051update.html">4. Mac OS X 10.5.1 Up…</a></li>
                <li><a title="Java for Mac OS X 10.4 Release 5" href="/downloads/macosx/apple/macosx_updates/javaformacosx104release5.html">5. Java for Mac OS X …</a></li>
                <li><a title="iPod Reset Utility 1.0.2 for Windows" href="/downloads/macosx/apple/ipod_itunes/ipodresetutility102forwindows.html">6. iPod Reset Utility…</a></li>
                <li><a title="iPhoto 7.1.1" href="/downloads/macosx/apple/application_updates/iphoto711.html">7. iPhoto 7.1.1</a></li>
            </ul>
        </li>
    </ul>
        <div class="boxcap"></div>
        </div>
		</div>
		            
			  
	</body>
</html>