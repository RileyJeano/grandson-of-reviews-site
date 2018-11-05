const{ addTag, addTagHtml } = require('../js/dom.js')

describe("should add a tag", () => {
	test("add the tag to the p element", () => {
		const input = document.createElement('input');
		input.setAttribute('type', 'text');
		input.setAttribute('name', 'tagName');
		input.value = "tagName";
		const button = document.createElement('button');
		const p = document.createElement('p');
		const tag = {
			'id': '1',
			'tagName': 'name'
		}

		addTagHtml(tag, p)
		console.log(tag.id);
		expect(tag.tagName).toEqual(p.querySelector('a').innerText)
	})
	test("adding the tag from an input to the server", () => {
		const input = document.createElement('input');
		input.setAttribute('type', 'text');
		input.setAttribute('name', 'tagName');
		input.value = "tagName";
		const button = document.createElement('button');
		const p = document.createElement('p');
		const xhttp = new XMLHttpRequest()
		xhttp.open('POST', 'http://localhost:8080/api/reviews/7/tag/add', false)
		xhttp.send(JSON.stringify({
			tagName: 'tagname'
		}
			))

		let result = '';
		xhttp.open('GET', 'http://localhost:8080/api/reviews/7', false)
		xhttp.send()
		JSON.parse(xhttp.responseText).forEach(tag => {
					console.log(tag.tagName)
					result = tag.tagName;
				})
		

 		expect(input.value).toEqual(result);
		
	})
})