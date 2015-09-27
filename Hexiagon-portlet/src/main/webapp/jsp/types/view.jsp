<%@page import="com.zenixia.plugins.hexiagon.permission.HexiagonPermission"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@include file="/jsp/init.jsp" %>

<liferay-ui:success key="type-added" message="type-added-successfully" />
<liferay-ui:success key="type-updated" message="type-updated-successfully" />
<liferay-ui:success key="type-deleted" message="type-deleted-successfully" />

<liferay-ui:error key="no-type-deleted" message="type-deleted-unsuccessfully" />

<c:if test='<%= HexiagonPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), "ADD_TYPE") %>'>
	<aui:nav-bar cssClass="label-info">
		<aui:nav >
			<portlet:renderURL var="addTypeURL">
				<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>" />
				<portlet:param name="jspPage" value="/jsp/types/edit.jsp"/>
		    </portlet:renderURL>
		    
			<aui:nav-item href="${addTypeURL}" iconCssClass="icon-plus" label="add-type" />
			
		</aui:nav>
	</aui:nav-bar>
</c:if>

<liferay-ui:search-container  searchContainer="${searchTypeContainer}" id="types">
	<liferay-ui:search-container-results
		results="${searchTypeContainer.results}"
		total="${searchTypeContainer.total}" 
	/>
	
	<liferay-ui:search-container-row 
		className="com.zenixia.plugins.hexiagon.model.Type"
		keyProperty="typeId"
		modelVar="type" escapedModel="true"
	>	
	
		<liferay-ui:search-container-column-text>
			<aui:input name="typeIds" type="hidden" value="${type.typeId}"> 
			</aui:input>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text
			name="name"
			value="${type.getName(locale)}"
		/>
		
		<liferay-ui:search-container-column-text
			name="order"
			property="order"
		/>
		
		<liferay-ui:search-container-column-jsp
			align="right"
			name="Actions"
			path="/jsp/types/actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" searchContainer="${searchTypeContainer}"/>
</liferay-ui:search-container>

<portlet:resourceURL var="saveTypesOrderURL" />

<c:if test ='<%= HexiagonPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), "UPDATE_ORDER") %>'>
	<aui:script>
		YUI().use('sortable', function (Y) {
		
		    var log, sortable;
		
		    log = Y.one('#log');
			var container = Y.one('#<portlet:namespace/>typesSearchContainer');
			
		    // Our sortable list instance.
		    sortable = new Y.Sortable({
		    	container: container,
		        nodes    : 'table tbody tr',
		        opacity  : '0.5'
		    });
		
		    sortable.delegate.after('drag:end', function (e) {
		        var node = sortable.delegate.get('currentNode'),
		            prev = node.previous(),
		            next = node.next(),
		            msg  = 'Moved ' + node.one('td').get('text');
		        
		        container.all('input[name=<portlet:namespace/>typeIds]');
		        
		        
			    var typeIds = container.all('input[name=<portlet:namespace/>typeIds]').get('value');
			    
			    <portlet:namespace />saveTypesOrder(typeIds);
		    });
		
		});
		
		Liferay.provide(window,'<portlet:namespace />saveTypesOrder',function(typeIds) {
		
			YUI().use(
			  'aui-io-request-deprecated',
			  function (Y) {
			    Y.io.request(
			      '${saveTypesOrderURL}',
			      {
			      	dataType: 'text/html',
			      	method: 'POST',
			      	data: {
						<portlet:namespace/>typeIds : typeIds
					}
			      }
			    );
			  }
			);
		});
	
	</aui:script>
</c:if>