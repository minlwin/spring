document.addEventListener('DOMContentLoaded', () => {
	const logoutBtn = document.getElementById('logoutBtn')
	const logoutForm = document.getElementById('logoutForm')
	
	if(logoutBtn && logoutForm) {
		logoutBtn.addEventListener('click', () => {
			logoutForm.submit()
		})
	}
})