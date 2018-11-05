

function addTag(input, reviewId, addTagButton, p, original) {
	
	addTagButton.addEventListener('click', function() {
		
		const xhttp = new XMLHttpRequest()
		
		// Sets behavior for when the AJAX request is complete
		xhttp.onreadystatechange = function() {
			
			// Checks the ready state and http status code
			if (this.readyState == 4 && this.status == 200) {
				
				//Resets the original p element
				p.innerHTML = original;

				JSON.parse(this.responseText).forEach(tag => {
					addTagHtml(tag, p, reviewId)
				})
				addDeleteButtonsEvent(p, reviewId)
			}
		}
		xhttp.open('POST', `/api/reviews/${window.location.pathname.split('/')[2]}/tags/add`, true)
		const body = JSON.stringify({
					tagName: input.value
				})
		xhttp.send(body)
	})
}

function addTagHtml(tag, p) {

	p.innerHTML = p.innerHTML + `
		<a href = "/tag/${tag.id}" class="a${tag.id}">${tag.tagName}</a> <button class="delete" data-num="${tag.id}">X</button>
	`;
}

function addDeleteButtonsEvent(p, reviewid) {
	console.log(p.querySelectorAll('.delete'))
	p.querySelectorAll('.delete').forEach(button => {
		button.addEventListener('click', () => {
			const a = p.querySelector(`.a${button.getAttribute('data-num')}`)
			fetch(`/api/review/${reviewId}/tags/remove`, {

				method: 'POST',
				body:	JSON.stringify({
					tagName: a.innerText
				})
			}).then(() => {
				a.remove();
				button.remove();
			})
		})
	})
}
module.exports = {
	addTag,
	addTagHtml
}