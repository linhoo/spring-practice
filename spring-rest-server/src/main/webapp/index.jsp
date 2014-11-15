<html>
<head>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script>
		$.ajax({
			type: "GET",
			url: "spitters/haa/spittles",
			dataType: "json",
			success: function(data) {
				console.log(data);
			},
			error: function(html) {
				alert("error");
			}
		});
	</script>
</head>
<body>
<h2>Hello World!</h2>
</body>
</html>
