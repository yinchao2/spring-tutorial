<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
  <head>
	<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
    <title><tiles:getAsString name="title"/></title>
  </head>
  <body>
		<div class="header">
			<tiles:insertAttribute name="header" />
		</div>
          
		<div class="content">
			<tiles:insertAttribute name="content" />
		</div>
        <hr/>
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
  </body>
</html>