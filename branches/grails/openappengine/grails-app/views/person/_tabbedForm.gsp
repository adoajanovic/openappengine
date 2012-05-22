<%@ page import="com.openappengine.model.party.Person" %>
<!doctype html>
<html>
	<head>
		<script type="text/javascript">
	        $(document).ready(function () {
	            var theme = getTheme();
	            // Create jqxTabs.
	            $('#jqxTabs').jqxTabs({ position: 'top', theme: theme });
	            $('#jqxTabs').bind('change', function (event) {
	                var checked = event.args.checked;
	                $('#jqxTabs').jqxTabs({ selectionTracker: checked });
	            });

	            var validator = $("form").validate({
					rules: {
						firstName: "required",
						lastName: "required",
						address1: "required"
					},
					messages: {
						firstname: "Enter your firstname"
					},
					
					// set this class to error-labels to indicate valid fields
					success: function(label) {
						// set &nbsp; as text for IE
						label.html("&nbsp;").addClass("checked");
					}
				});
	        });
		 </script>
	</head>
	<body>
		<form name="personForm" id="personForm" action="save" >
			<div id="validation-errors">
				
			</div>
			<div class="section">
					<div id="personForm">
						<!-- Person Form -->
						<fieldset class="form">
							<g:render template="form" />
						</fieldset>
					</div>
				</div>
				<div class="section">
					<div id="addressForm">
						<fieldset class="form">
							<g:render template="/address/form" />
						</fieldset>
					</div>
			</div>
			<fieldset class="buttons">
				<g:submitButton name="create" id="saveButton" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
			</fieldset>
		</form>
	</body>
</html>