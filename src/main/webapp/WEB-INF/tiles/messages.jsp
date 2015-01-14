<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="messages"></div>

<script type="text/javascript">
	
	var timer;
	
	function showReply(i) {
		stopTimer();
		$("#form" + i).toggle();
	}
	
	function success(data) {
		$("#form" + data.id).toggle();
		$("#alert" + data.id).text("Message has been sent!");
		startTimer();
	}
	
	function error() {
		alert("error");
	}
	
	function replyMessages(i, name, email) {
		var text = $("#textbox" + i).val();
		
		$.ajax({
			"type": 'POST',
			"url": '<c:url value="/replymessages" />',
			"data": JSON.stringify({"id": i, "text": text, "name": name, "email": email}),
			"success": success,
			"error": error,
			contentType: "application/json",
			dataType: "json"
		});
	}
	
	function showMessages(data) {
		
		$("#messages").html("");
		
		for(var i=0; i<data.messages.length; i++) {
			var message = data.messages[i];
			
			var messageDiv = document.createElement("div");
			messageDiv.setAttribute("class", "message");
			
			var subjectSpan = document.createElement("span");
			subjectSpan.setAttribute("class", "subject");
			
			subjectSpan.appendChild(document.createTextNode(message.subject));
			
			var contentSpan = document.createElement("span");
			contentSpan.setAttribute("class", "messagebody");
			
			contentSpan.appendChild(document.createTextNode(message.content));
			
			var nameSpan = document.createElement("span");
			nameSpan.setAttribute("class", "name");
			
			nameSpan.appendChild(document.createTextNode(message.name + " ("));
			
			var link = document.createElement("a");
			link.setAttribute("href", "#");
			link.setAttribute("class", "replylink");
			link.setAttribute("onclick", "showReply(" + i + ")");
			
			link.appendChild(document.createTextNode(message.email));
			
			nameSpan.appendChild(link)
			nameSpan.appendChild(document.createTextNode(")"))
			
			var alertSpan = document.createElement("span");
			alertSpan.setAttribute("class", "alert");
			alertSpan.setAttribute("id", "alert" + i);
			
			var replyForm = document.createElement("form");
			replyForm.setAttribute("class", "replyform");
			replyForm.setAttribute("id", "form" + i);
			
			var textarea = document.createElement("textarea");
			textarea.setAttribute("class", "replyarea");
			textarea.setAttribute("id", "textbox" + i);
			
			var replyButton = document.createElement("input");
			replyButton.setAttribute("class", "replybutton");
			replyButton.setAttribute("type", "button");
			replyButton.setAttribute("value", "Reply");
			replyButton.onclick = function(j, name, email) {
				return function() {
					replyMessages(j, name, email);
				}
			}(i, message.name, message.email);
			
			replyForm.appendChild(textarea);
			replyForm.appendChild(replyButton);
			
			messageDiv.appendChild(subjectSpan);
			messageDiv.appendChild(contentSpan);
			messageDiv.appendChild(nameSpan);
			messageDiv.appendChild(alertSpan);
			messageDiv.appendChild(replyForm);
			
			$("#messages").append(messageDiv);
		}
		
	}
	
	function updatePage() {
		$.getJSON("<c:url value='/getmessages' />", showMessages);
	}
	
	function onLoad() {
		updatePage();
		startTimer();
	}
	
	function startTimer() {
		timer = window.setInterval(updatePage, 5000);
	}
	
	function stopTimer() {
		window.clearInterval(timer);
	}
	
	$(document).ready(onLoad);
</script>