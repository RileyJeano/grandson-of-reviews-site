const{ addTag } = require('./js/dom.jsS')

describe("should add a tag", () => {
	test("adding the tag from an input to the server", => {
		const input = document.createElement('input');
		input.setAttribute('type', 'text');
		input.setAttribute('name', 'tagName');
		input.value = "tagName";

		addTag(input, 7);
		const result;
		fetch('api/reviews/7', {method: 'get'})
			.then(res => res.json())
 			.then(data => {
 				result = data;
 			})
		expect(input.value).toEqual( )
		
	})
})