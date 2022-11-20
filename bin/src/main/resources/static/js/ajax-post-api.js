
var frm = $('#postform');
frm.submit(function(e) {

		e.preventDefault();
		$.ajax({
			type : frm.attr('method'),
			url : frm.attr('action'),
			data : frm.serialize(),
			success : function(data) {
				if(data.error!=null){
					showSnackbar(data.error);
				}else{
					showSnackbar(data.data);
				}
			},
			error : function(data) {
				showsnackbar(data.error)
			},
		});
	});
