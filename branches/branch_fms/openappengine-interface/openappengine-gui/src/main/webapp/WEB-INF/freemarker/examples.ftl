<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<#import "/spring.ftl" as spring/>
<head>
  <title>
  	Test
  </title>
</head>

<body id="index">					
        
 <#if serverTime?exists>
	<div style="z-index: 99; position: absolute; left: 200px;">
	 
	</div>
 </#if>			  	 	  
 
 <br/><br/>
 	
 <div id="main">
 
 	<!-- Message -->
	<div class="success">
		<ul>
			<li>
				<div style="margin-left:18%;">	
					<a href="${rc.getContextPath()}/apps/codeType/CodeTypeSimple.screen?codeTypeId=1">
						Simple Code Type Save Form
					</a>
				</div>
			</li>
			
			<li>
				<div style="margin-left:18%;">	
					<a href="${rc.getContextPath()}/apps/codeType/CodeTypeWithPrefix.screen?a.codeTypeId=1">
						Code Type Save Form With Prefix 'a'
					</a>
				</div>
			</li>
			
			<li>
				<div style="margin-left:18%;">	
					<a href="${rc.getContextPath()}/apps/codeType/CodeTypeMultipleFormSingle.screen?a.codeTypeId=1&b.codeTypeId=2">
						Multiple Code Type Save Form With Prefix 'a' and 'b'
					</a>
				</div>
			</li>
		</ul>	
	</div>
	
	
	
    </div>   
</body>
</html>