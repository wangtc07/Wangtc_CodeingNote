```js
$('input[type=radio][name="cardColor"]').on('change', function () {
	switch ($(this).val()) {
		case 'template1':
			console.log('$(this).val(): ', $(this).val());
			break;
		default:
			break;
	}
})
```