<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <title>Slide Demo - Fixed Drawer</title>
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

    <link rel="stylesheet" href="${rc.getContextPath()}/resources/jquery/themes/base/jquery.ui.all.css">
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/jquery-1.6.2.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.position.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.core.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.accordian.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.dimensions.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.widget.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.button.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.tabs.js"></script>
	 <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.dialog.js"></script>

    <script type="text/javascript">
    <!--
    $(function () {
        $('ul.drawers').accordion({
            header: 'H2.drawer-handle',
            selectedClass: 'open',
            event: 'mouseover'
        });
    });
    //-->    
    </script>
</head>
<body id="page">
    <h1>Fixed drawer slide out demo (using accordion plugin)</h1>
    <p>This example demonstrates the Apple downloads slider/accordion effect using the jQuery Accordion plugin.</p>
    <p>Mouse over the headings to reveal the list of available links.</p>

    <p><a href="http://jqueryfordesigners.com/slide-out-and-drawer-effect/">Read the article this demonstration relates to</a></p>
    <div class="drawers-wrapper">
        <div class="boxcap captop"></div>
    <ul class="drawers">
        <li class="drawer">
            <h2 class="drawer-handle open">Downloads</h2>
            <ul class="alldownloads">
                <li id="sn-downloadsmacosx"><a href="/downloads/macosx/">All Categories</a></li>
                <li id="sn-aperture"><a href="/downloads/macosx/aperture/">Aperture</a></li>
                <li id="sn-apple"><a href="/downloads/macosx/apple/">Apple</a></li>
                <li id="sn-audio"><a href="/downloads/macosx/audio/">Audio</a></li>
                <li id="sn-automator"><a href="/downloads/macosx/automator/">Automator Actions</a></li>
                <li id="sn-businessfinance"><a href="/downloads/macosx/business_finance/">Business &amp; Finance</a></li>
                <li id="sn-calendars"><a href="/downloads/macosx/calendars/">Calendars</a></li>
                <li id="sn-developmenttools"><a href="/downloads/macosx/development_tools/">Development Tools</a></li>
                <li id="sn-drivers"><a href="/downloads/macosx/drivers/">Drivers</a></li>
                <li id="sn-emailchat"><a href="/downloads/macosx/email_chat/">Email &amp; Chat</a></li>
                <li id="sn-finalcutstudio"><a href="/downloads/macosx/finalcutstudio/">Final Cut Studio</a></li>
                <li id="sn-games"><a href="/downloads/macosx/games/">Games</a></li>
                <li id="sn-homelearning"><a href="/downloads/macosx/home_learning/">Home &amp; Learning</a></li>
                <li id="sn-iconsscreensavers"><a href="/downloads/macosx/icons_screensavers/">Icons, Screensavers, etc.</a></li>
                <li id="sn-imaging3d"><a href="/downloads/macosx/imaging_3d/">Imaging &amp; 3D</a></li>
                <li id="sn-internetutilities"><a href="/downloads/macosx/internet_utilities/">Internet Utilities</a></li>
                <li id="sn-ipoditunes"><a href="/downloads/macosx/ipod_itunes/">iPod + iTunes</a></li>
                <li id="sn-mathscience"><a href="/downloads/macosx/math_science/">Math &amp; Science</a></li>
                <li id="sn-networkingsecurity"><a href="/downloads/macosx/networking_security/">Networking &amp; Security</a></li>
                <li id="sn-productivitytools"><a href="/downloads/macosx/productivity_tools/">Productivity Tools</a></li>
                <li id="sn-spotlight"><a href="/downloads/macosx/spotlight/">Spotlight Plugins</a></li>
                <li id="sn-systemdiskutilities"><a href="/downloads/macosx/system_disk_utilities/">System/Disk Utilities</a></li>
                <li id="sn-unixopensource"><a href="/downloads/macosx/unix_open_source/">UNIX &amp; Open Source</a></li>
                <li id="sn-video"><a href="/downloads/macosx/video/">Video</a></li>
                <li id="sn-dashboard"><a href="/downloads/dashboard/" class="bottom">Widgets</a></li>
            </ul>
        </li>
        <li class="drawer">
            <h2 class="drawer-handle">Top Downloads</h2>
            <ul>
                <li><a title="iTunes 7.5" href="http://www.apple.com/itunes/download/">1. iTunes 7.5</a></li>
                <li><a title="QuickTime 7.3.1" href="http://www.apple.com/quicktime/download/">2. QuickTime 7.3.1</a></li>
                <li><a title="Safari 3 Public Beta" href="http://www.apple.com/safari/download/">3. Safari 3 Public Beta</a></li>
                <li><a title="MacPool" href="/downloads/macosx/games/simulation_and_sports/macpool.html">4. MacPool Realistic and easy to play computer simu�</a></li>
                <li><a title="Guitar Hero III: Legends of Rock" href="/downloads/macosx/games/demos_updates/guitarheroiiilegendsofrock.html">5. Guitar Hero III: L�</a></li>
                <li><a title="Messenger for Mac" href="/downloads/macosx/email_chat/messengerformac.html">6. Messenger for Mac</a></li>
                <li><a title="Google Earth" href="/downloads/macosx/home_learning/googleearth.html">7. Google Earth</a></li>
                <li><a title="Monopoly" href="/downloads/macosx/games/cards_puzzle/monopoly.html">8. Monopoly</a></li>
                <li><a title="Litho System Icons" href="/downloads/macosx/icons_screensavers/lithosystemicons.html">9. Litho System Icons</a></li>
                <li><a title="Battlefield 2142" href="/downloads/macosx/games/demos_updates/battlefield2142.html">10. Battlefield 2142</a></li>
                <li><a title="More iChat Effects" href="/downloads/macosx/email_chat/moreichateffects.html">11. More iChat Effects</a></li>
                <li><a title="Dragster" href="/downloads/macosx/internet_utilities/dragster.html">12. Dragster</a></li>
                <li><a title="iSquint" href="/downloads/macosx/ipod_itunes/isquint.html">13. iSquint</a></li>
                <li class="last"><a title="US Holiday Calendar" href="/downloads/macosx/calendars/usholidaycalendar.html">14. US Holiday Calendar</a></li>
            </ul>
        </li>
        <li class="drawer last">
            <h2 class="drawer-handle">Top Apple Downloads</h2>
            <ul>
                <li><a title="iTunes 7.5" href="http://www.apple.com/itunes/download/">1. iTunes 7.5</a></li>
                <li><a title="QuickTime 7.3.1" href="http://www.apple.com/quicktime/download/">2. QuickTime 7.3.1</a></li>
                <li><a title="Safari 3 Public Beta" href="http://www.apple.com/safari/download/">3. Safari 3 Public Beta</a></li>
                <li><a title="Mac OS X 10.5.1 Update" href="/downloads/macosx/apple/macosx_updates/macosx1051update.html">4. Mac OS X 10.5.1 Up�</a></li>
                <li><a title="Java for Mac OS X 10.4 Release 5" href="/downloads/macosx/apple/macosx_updates/javaformacosx104release5.html">5. Java for Mac OS X �</a></li>
                <li><a title="iPod Reset Utility 1.0.2 for Windows" href="/downloads/macosx/apple/ipod_itunes/ipodresetutility102forwindows.html">6. iPod Reset Utility�</a></li>
                <li><a title="iPhoto 7.1.1" href="/downloads/macosx/apple/application_updates/iphoto711.html">7. iPhoto 7.1.1</a></li>
                <li><a title="Bonjour for Windows" href="/downloads/macosx/apple/windows/bonjourforwindows.html">8. Bonjour for Windows</a></li>
                <li><a title="Mac OS X 10.4.11 Combo Update (PPC)" href="/downloads/macosx/apple/macosx_updates/macosx10411comboupdateppc.html">9. Mac OS X 10.4.11 C�<br/>The 10.4.11 Update is recommended for al�</a></li>
                <li><a title="Java for Mac OS X 10.4, Release 6" href="/downloads/macosx/apple/macosx_updates/javaformacosx104release6.html">10. Java for Mac OS X �</a></li>
                <li><a title="GarageBand 4.1.1" href="/downloads/macosx/apple/application_updates/garageband411.html">11. GarageBand 4.1.1</a></li>
                <li><a title="iPod Updater 2006-06-28 for Windows" href="/downloads/macosx/apple/ipod_itunes/ipodupdater20060628forwindows.html">12. iPod Updater 2006-�</a></li>
                <li><a title="Security Update 2007-009 1.1 (10.4.11 Universal)" href="/downloads/macosx/apple/security_updates/securityupdate20070091110411universal.html">13. Security Update 20�</a></li>
                <li class="last"><a title="Security Update 2007-009 1.1 (10.5.1)" href="/downloads/macosx/apple/security_updates/securityupdate2007009111051.html">14. Security Update 20�</a></li>
            </ul>
        </li>
    </ul>
        <div class="boxcap"></div>
        </div>
</body>
</html>