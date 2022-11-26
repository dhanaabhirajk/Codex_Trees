function showSnackbar(text) {
	var snackBar = document.getElementById("snackbar");
	
	snackbar.innerHTML = text;
	snackBar.className = "show-bar";
	setTimeout(
			function() {
				snackBar.className = snackBar.className.replace(
						"show-bar", "");

			}, 5000);
}

var logout = function () {
			$.post("/logout", function () {
				$("#user").html('');
				$(".unauthenticated").show();
				$("#authentication-btn").html(`
					<a href="/oauth2/authorization/google" class="btn btn-dark fw-bold">
						<i class="bi bi-google px-2"></i> LOGIN
					</a>
				`);
				$(".authenticated").hide();
			})
			return true;
		}
		
	function timeSince(date) {
            date = Date.now() - date;
var seconds = Math.floor((new Date() - date) / 1000);

var interval = Math.floor(seconds / 31536000);

if (interval > 1) {
  return interval + " years";
}
interval = Math.floor(seconds / 2592000);
if (interval > 1) {
  return interval + " months";
}
interval = Math.floor(seconds / 86400);
if (interval > 1) {
  return interval + " days";
}
interval = Math.floor(seconds / 3600);
if (interval > 1) {
  return interval + " hours";
}
interval = Math.floor(seconds / 60);
if (interval > 1) {
  return interval + " minutes";
}
return Math.floor(seconds) + " seconds";
} 