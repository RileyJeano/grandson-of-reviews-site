
fetch(`/api/reviews/${window.location.pathname.split('/')[2]}`)
	.then(res => res.json())
	.then(data => {
		const body = document.body
		const p = document.querySelector(".tags")
		data.tags.forEach(tag => {
			p.innerText += tag.tagName + ', ';
		})
		
		body.innerHTML += p.innerHTML

	})