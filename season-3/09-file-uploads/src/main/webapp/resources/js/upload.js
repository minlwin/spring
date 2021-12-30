document.addEventListener('DOMContentLoaded', () => {
	
	// Fetch Event to Upload Button
	document.getElementById('uploadBtn').addEventListener('click', () => {
		document.getElementById('uploadInput').click()
	})
	
	// Submit Form when file input value changes
	document.getElementById('uploadInput').addEventListener('change', () => {
		document.getElementById('uploadForm').submit()
	})
})