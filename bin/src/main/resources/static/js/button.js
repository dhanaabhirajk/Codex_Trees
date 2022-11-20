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
		
		