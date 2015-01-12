<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="messages"></div>

<script type="text/javascript">
	
	function onLoad() {
		alert("messages");
	}
	
	$(document).ready(onLoad);
</script>