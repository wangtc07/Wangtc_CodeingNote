# solustion
tsconfig.json 加上 `baseUrl` , `paths` 配置

tsconfig.json
```json

{

	"compilerOptions": {

		"baseUrl": "./",

		"paths": {

		"@/*": ["src/*"]

	}

},

```

vite.config.ts
```js
/** 最初 */
resolve: {
	alias: {
	  '@': path.resolve(__dirname, 'src'),
	},
},
	
	
/** ok */

alias: {

	'@': path.resolve(__dirname, 'src'),

},

// /** ok */

resolve: {

	alias: [

	{ find: '@', replacement: '/src' },

	{ find: /^@(?=\/)/, replacement: path.resolve(__dirname, './src') },

],

},
	
	
```