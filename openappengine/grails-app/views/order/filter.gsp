<div id="list-ohOrderHeader" class="content scaffold-list" role="main">
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="billingAccountId" title="${message(code: 'ohOrderHeader.billingAccountId.label', default: 'Billing Account Id')}" />
					
						<g:sortableColumn property="contractNumber" title="${message(code: 'ohOrderHeader.contractNumber.label', default: 'Contract Number')}" />
					
						<g:sortableColumn property="currencyUom" title="${message(code: 'ohOrderHeader.currencyUom.label', default: 'Currency Uom')}" />
					
						<g:sortableColumn property="entryDate" title="${message(code: 'ohOrderHeader.entryDate.label', default: 'Entry Date')}" />
					
						<g:sortableColumn property="externalId" title="${message(code: 'ohOrderHeader.externalId.label', default: 'External Id')}" />
					
						<th />
					</tr>
				</thead>
				<tbody>
				<g:each in="${ohOrderHeaderInstanceList}" status="i" var="ohOrderHeaderInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${fieldValue(bean: ohOrderHeaderInstance, field: "billingAccountId")}</td>
					
						<td>${fieldValue(bean: ohOrderHeaderInstance, field: "contractNumber")}</td>
					
						<td>${fieldValue(bean: ohOrderHeaderInstance, field: "currencyUom")}</td>
					
						<td><g:formatDate date="${ohOrderHeaderInstance.entryDate}" /></td>
					
						<td>${fieldValue(bean: ohOrderHeaderInstance, field: "externalId")}</td>
						
						<td>
							<g:link action="show" class="view_details"
								id="${ohOrderHeaderInstance.orderId}">
								<img src="${resource(dir: 'images/skin/icons', file: 'application_view_detail.png')}"
									alt="View Details" class="icon" />
							</g:link>
						</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ohOrderHeaderInstanceTotal}" />
			</div>
		</div>