const input = document.querySelector('.taggyTag')
const addTagButton = document.querySelector('button')

addTagButton.addEventListener('click', () => {
	fetch(`/api/reviews/${window.location.pathname.split('/')[2]}/tags/add`, {
		method: 'post',
		body: JSON.stringify({
			tagName: input.value,
		}),
	})
		.then(res => res.json())
		.then(data => console.log(data))
})
