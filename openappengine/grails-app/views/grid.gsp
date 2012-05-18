<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="layout" content="main">
	<script>
	var localDevelopers;
	$.ajax({
		dataType: "json",
		url: "developers.json",
		async: false,
		success: function( result ) {
			localDevelopers = result;
		}
	});

	$(function() {
		var developers = $.ui.dataviewlocal({
			input: localDevelopers,
			paging: {
				limit: 3
			}
		});

		$( "#developers-local" ).grid({
			heightStyle: "fill",
			source: developers.result,
			select: function( event, ui ) {
				console.log( "Selected " + ui.item.firstName );
			}
		});

		//$( "#filterDevelopers" ).filterControl( developers );
		//$( "#sortDevelopers" ).sorterControl( developers );
		$( "#pageDevelopers" ).pager({
			source: developers
		});

		developers.refresh();
	});
	</script>
</head>
<body>

<h2>local data source</h2>
<div style="width:48em;">
<table id="developers-local">
	<thead>
		<tr>
			<th data-property="firstName">First Name</th>
			<th data-property="lastName">Last Name</th>
			<th data-property="country">Country</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
<p id="pageDevelopers">
	<button data-page="first">First</button>
	<button data-page="prev">Prev</button>
	<button data-page="prevStep">-1</button>
	<span>
		Page <input class="current" size="4"/>/<span class="total">0</span>,
		Total records <span class="totalRecords">0</span>
	</span>
	<button data-page="nextStep">+1</button>
	<button data-page="next">Next</button>
	<button data-page="last">Last</button>
</p>
</div>
</body>
</html>
