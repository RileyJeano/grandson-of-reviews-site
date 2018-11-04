const addTagButton = document.querySelector('button')
const p = document.querySelector('.tags')
const original = p.innerHTML;
const input = document.querySelector('.taggyTag')

addtag(input, ${window.location.pathname.split('/')[2]});

fetch(`/api/reviews/${window.location.pathname.split('/')[2]}`, {
 				method: 'get'
 			})
 			.then(res => res.json())
 			.then(data => {
 				data.forEach(tag =>{
 					p.innerHTML = p.innerHTML + `
						<a href = "/tag/${tag.id}" class="a${tag.id}">${tag.tagName}</a> <button class="button${tag.id}">X</button>
					`;
 					document.querySelector(`.button${tag.id}`).addEventListener('click', () => {
 						fetch(`/api/review/${window.location.pathname.split('/')[2]}/tags/remove`, {
 							method: 'POST',
 							body:	JSON.stringify({
								tagName: tag.tagName
 							})
 						}).then(() => {
 							document.querySelector(`.a${tag.id}`).remove();
 							document.querySelector(`.button${tag.id}`).remove();
 						})
 					})
 				})
 			})

