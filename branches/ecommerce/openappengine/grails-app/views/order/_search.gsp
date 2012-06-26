<div>
			<g:formRemote name="searchForm" on404="alert('not found!')" update="list-ohOrderHeader"
	              url="[action:'filter']" class="search-form">
	            <table style="width:auto;">
	            	<thead>
						<tr>
							<th colspan="6">
									Search
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Contract Number:</td>
							<td><input id="contractNumber" name="contractNumber" type="text" /></td>
						</tr>
						<tr>
							<td>Order Number:</td>
							<td><input id="orderNumber" name="orderNumber" type="text" /></td>
						</tr>
						<tr>
		            		<td colspan="6">
		            			<input type="submit" value="Search" />			
		            		</td>
		            	</tr>
					</tbody>
	            </table>  
			</g:formRemote>
		</div>