<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Grid: Sorting, Paging, Filtering</title>
	<meta name="layout" content="main">
	<link rel="stylesheet" href="${resource(dir: 'css/base', file: 'jquery.ui.all.css')}" type="text/css">
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'demos.css')}" type="text/css">
	<script src="${resource(dir: 'js', file: 'jquery-1.7.1.js')}"></script>
	<script src="${resource(dir: 'js/external', file: 'jquery.tmpl.js')}"></script>
	<script src="${resource(dir: 'js/ui', file: 'jquery.ui.core.js')}"></script>
	<script src="${resource(dir: 'js/ui', file: 'jquery.ui.widget.js')}"></script>
	<script src="${resource(dir: 'js/ui', file: 'jquery.ui.button.js')}"></script>
	<script src="${resource(dir: 'js/ui', file: 'jquery.ui.observable.js')}"></script>
	<script src="${resource(dir: 'js/ui', file: 'jquery.ui.dataview.js')}"></script>
	<script src="${resource(dir: 'js/ui', file: 'jquery.ui.grid.js')}"></script>
	<script src="${resource(dir: 'js/ui', file: 'jquery.ui.dataviewlocal.js')}"></script>
	<script src="${resource(dir: 'js', file: 'pager.js')}"></script>
	<script src="${resource(dir: 'js', file: 'dataview-odata.js')}"></script>
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

	$.fn.filterControl = function( dataview ) {
		this.addClass( "tool" ).find( "button" ).click(function() {
			var button = $( this ),
				field = button.data( "filter-field" ),
				value = button.data( "filter-value" ),
				operator = button.data( "filter-operator" ),
				key = "filter." + field;

			if ( dataview.option( "filter." + field ) ) {
				dataview.option( key, null );
			} else {
				dataview.option(key, {
					value: value,
					operator: operator
				});
			}
			dataview.refresh();

			button.toggleClass( "active" );
		})
		return this;
	};

	$.fn.sorterControl = function( dataview ) {
		var sorted = {};
		this.addClass( "tool" ).find( "button" ).click(function() {
			var button = $( this ),
				field = button.data( "sort-field" );
			if ( sorted[ field ] ) {
				if ( sorted[ field ].charAt( 0 ) === "-" ) {
					delete sorted[ field ];
					button.removeClass( "active sort-desc" );
				} else {
					sorted[ field ] = "-" + sorted[ field ];
					button.removeClass( "sort-asc" ).addClass( "sort-desc" );
				}
			} else {
				sorted[ field ] = field;
				$( this ).addClass( "active sort-asc" )
			}
			var sort = [];
			for ( var key in sorted ) {
				sort.push( sorted[ key ] );
			}
			dataview.option( "sort", sort ).refresh();
		})
		return this;
	};

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

		$( "#filterDevelopers" ).filterControl( developers );
		$( "#sortDevelopers" ).sorterControl( developers );
		$( "#pageDevelopers" ).pager({
			source: developers
		});

		developers.refresh();

		// A similar example...but with server integration and remote queries.
		var movies = $.ui.odataDataview({
			resource: "http://odata.netflix.com/Catalog/Titles"
		});
		$( "#movies" ).grid({
			source: movies.result
		});

		$( "#filterMovies" ).filterControl( movies );
		$( "#sortMovies" ).sorterControl( movies );
		$( "#pageMovies" ).pager({
			source: movies
		});

		movies.refresh();
	});
	</script>
	<style>
	.tool button {
		border: 1px solid white;
	}
	.tool button.active {
		border: 1px solid black;
	}
	.sort-asc:after {
		content: " ↑"
	}
	.sort-desc:after {
		content: " ↓"
	}
	</style>
</head>
<body>

<h1>Grids with local and remote dataview</h1>
<p>features: sorting, filtering, paging</p>

<h2>local data source</h2>
<p id="filterDevelopers">
	Filter:
	<button data-filter-field="firstName" data-filter-value="Scott" type="button">Toggle firstName=Scott</button>
	<button data-filter-field="lastName" data-filter-value="Worth"  type="button">Toggle lastName=Worth</button>
	<button data-filter-field="country" data-filter-value="USA" type="button">Toggle country=USA</button>
	<button data-filter-field="country" data-filter-value="au" data-filter-operator="like" type="button">Toggle country like 'au'</button>
</p>
<p id="sortDevelopers">
	Sort:
	<button data-sort-field="firstName" type="button">Sort by first name</button>
	<button data-sort-field="lastName" type="button">Sort by last name</button>
	<button data-sort-field="country" type="button">Sort country</button>
</p>
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
</div>

<h2>remote data source</h2>
<p id="filterMovies">
	Filter:
	<button data-filter-field="Name" data-filter-operator="like"  data-filter-value="ultra"  type="button">Toggle Name like 'ultra'</button>
	<button data-filter-field="ReleaseYear" data-filter-operator="<="  data-filter-value="1990"  type="button">Toggle ReleaseYear &lt;= 1990</button>
	<button data-filter-field="AverageRating" data-filter-operator=">" data-filter-value="3" type="button">Toggle AverageRating > 3</button>
</p>
<p id="sortMovies">
	Sort:
	<button data-sort-field="Name" type="button">Sort by Name</button>
	<button data-sort-field="ReleaseYear" type="button">Sort by Release Year</button>
	<button data-sort-field="AverageRating" type="button">Sort by Average Rating</button>
</p>
<p id="pageMovies">
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

<div style="width:80%">
<table id="movies">
	<colgroup>
		<col width="60%">
		<col width="20%">
		<col width="20%">
	</colgroup>
	<thead>
		<tr>
			<th data-property="Name">Name</th>
			<th data-property="ReleaseYear">Release Year</th>
			<th data-property="AverageRating">Average Rating</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
</div>

</body>
</html>
