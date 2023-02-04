document.addEventListener('DOMContentLoaded', () => {
	document.getElementById('uploadBtn').addEventListener('click', () => {
		document.getElementById('uploadInput').click()
	})
	
	document.getElementById('uploadInput').addEventListener('change', () => {
		document.getElementById('uploadForm').submit()
	})
})