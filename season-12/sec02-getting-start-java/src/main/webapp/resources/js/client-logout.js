document.addEventListener('DOMContentLoaded', () => {
	const lotoutBtn = document.getElementById('logoutBtn')
	lotoutBtn.addEventListener('click', () => {
		document.location = `http://logout@${document.location.host}/`
	})
})