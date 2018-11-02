var xhttp = new XMLHttpRequest()
// Sets behavior for when the AJAX request is complete
xhttp.onreadystatechange = function() {
	// Checks the ready state and http status code
	if (this.readyState == 4 && this.status == 200) {
		// Typical action to be performed when the document is ready:
		console.log("This works?");
	}
}
/*
** Opens the request and sets the type of request,
** location of the data,
** and whether the request is asynchronous
*/

xhttp.open('GET', `/api/reviews/${window.location.pathname.split('/')[2]}`, true)
// Sends the request to the server
xhttp.send()


/*fetch(`/api/reviews/${window.location.pathname.split('/')[2]}`)
	.then(res => {
		console.log(res.status)
		res.json()
	})
	.then(data => {
		const body = document.body
		const p = document.querySelector(".tags")
		data.tags.forEach(tag => {
			p.innerText += tag.tagName + ', ';
		})
		
		body.innerHTML += p.innerHTML

	})*/