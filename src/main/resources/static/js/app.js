const input = document.querySelector('.taggyTag')
const addTagButton = document.querySelector('button')
const p = document.querySelector('.tags')

addTagButton.addEventListener('click', () => {
	const xhttp = new XMLHttpRequest()
	// Sets behavior for when the AJAX request is complete
	xhttp.onreadystatechange = function() {
		// Checks the ready state and http status code
		if (this.readyState == 4 && this.status == 200) {
			// Typical action to be performed when the document is ready:
			console.log(this.responseText)
			fetch(`/api/reviews/${window.location.pathname.split('/')[2]}/tags/add`, {
				method: 'post',
				body: JSON.stringify({
					tagName: input.value,
				}),
			})
			.then(res => res.json())
			.then(data => {
				data.forEach(tag =>{
					p.innerHTML = `
						<span>${tag.tagName}</span> 
					` + p.innerHTML; 
				})
			})
			// xhttp.responseText.forEach(tag =>{
			// 	p.innerHTML = `
			// 		<span>${tag.tagName}</span> 
			// 	` + p.innerHTML;
		}
	}
	xhttp.open('GET', `/api/reviews/${window.location.pathname.split('/')[2]}`, true)
	xhttp.send()
	})


fetch(`/api/reviews/${window.location.pathname.split('/')[2]}`, {
				method: 'get'
			})
			.then(res => res.json())
			.then(data => {
				data.forEach(tag =>{
					p.innerHTML = `
						<span>${tag.tagName}</span> 
					` + p.innerHTML; 
				})
			})
// Creates a new AJAX request


