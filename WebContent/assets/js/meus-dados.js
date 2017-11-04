function previewFile() {
	var preview = document.querySelector('img');
	var file = document.querySelector('input[type=file]').files[0];
	var reader = new FileReader();

	reader.addEventListener("load", function() {
		preview.src = reader.result;
	}, false);

	if (file) {
		reader.readAsDataURL(file);
	}
}

var openFile = function(event) {
	var input = event.target;
	var reader = new FileReader();
	reader.onload = function() {
		var dataURL = reader.result;
		var output = document.getElementById('output');
		output.src = dataURL;
		var campo = document.getElementById('stringFoto');
		campo.value = dataURL;
	};
	reader.readAsDataURL(input.files[0]);
};
