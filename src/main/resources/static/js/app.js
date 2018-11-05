const addTagButton = document.querySelector('button');
const p = document.querySelector('.tags');
const original = p.innerHTML;
const input = document.querySelector('.taggyTag');
reviewId = window.location.pathname.split('/')[2];

addTag(input, reviewId, addTagButton, p, original);

fetch(`/api/reviews/${window.location.pathname.split('/')[2]}`, {
 				method: 'get'
 			})
 			.then(res => res.json())
 			.then(data => {
 				data.forEach(tag =>{
 					addTagHtml(tag, p, reviewId)
 					})
 				addDeleteButtonsEvent(p, reviewId);
 				})


 			

