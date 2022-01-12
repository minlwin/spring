window.addEventListener('load', () => {
	console.log('Start JS')
	
	document.getElementById('streamTrigger').addEventListener('click', async () => {
		console.log('Start Loading Stream data ...')
		
		const output = document.getElementById('output')
		output.innerText = ''
		
		const response = await fetch('http://localhost:8080/stream')
		const reader = response.body.pipeThrough(new TextDecoderStream).getReader()
		
		while(true) {
			
			const {value, done} = await reader.read()
			
			if(done) {
				break
			}
			
			console.log(value)
			
			let item = document.createElement('li')
			item.innerText = value
			
			output.appendChild(item)
		}
	})
	
	document.getElementById('sseTrigger').addEventListener('click', () => {
		console.log('Connect Event Source ...')
		
		const output = document.getElementById('output')
		output.innerText = ''
		
		var eventSource = new EventSource('http://localhost:8080/sse')
		eventSource.onmessage = message => {
			let item = document.createElement('li')
			item.innerText = message.data
			
			output.appendChild(item)
		}
		
		eventSource.onerror = error => {
			console.log(error)
			eventSource.close()
		}
		
	})
})