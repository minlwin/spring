document.addEventListener('DOMContentLoaded', () => {
	
	// Fetch Event to Upload Button
	document.getElementById('uploadBtn').addEventListener('click', () => {
		document.getElementById('uploadInput').click()
	})
	
	// Submit Form when file input value changes
	document.getElementById('uploadInput').addEventListener('change', () => {
		document.getElementById('uploadForm').submit()
	})
	
	// Show Upload Modal Dialog
	var modalDialog = document.getElementById('uploadMessageModel')
	
	if(modalDialog) {
		var modal = new bootstrap.Modal(modalDialog)
		modal.show()
	}
})