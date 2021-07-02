> `flexbility`


## flex 排列方向
- `flex-direction`
	- 設定排列方向 預設row →
	- cloumn ↓

## flex item width
- 沒設定寬度
	- content decides width
- 有設定寬度
	- `flex-wrap`
		- 預設`nowrap` 👉 等於最大寬度 max width
		- 設定`wrap`   👉 固定寬度
- `flex-glow` 
	元件的伸展性 👉 flex的成長倍率
- `flex-shrink`
	元件的收縮性(flex-grow的反向)，預設值為`1`
- `flex-basis` 👉 min width
	最基本寬度需要多少 

## flex item height
- 沒設定高度
	- content decides hieght
- 有設定高度 👉 固定高度

## Positions in Flexbox
- `justify-content`
	跟 direction 平行的位置
	- `flex-start`
	- `flex-end`
	- `conter`
	- `space-between`
		- ![](https://i.imgur.com/Y86jRBU.png)

	- `space-around`
		- ![](https://i.imgur.com/ASWagxN.png)

	- `space-evenly`
		- ![](https://i.imgur.com/AB6dQjT.png)
- `align-items`
	跟 direction 垂直的位置
	- `flex-start`
		- ![](https://i.imgur.com/llh1Nld.png)

	- `flex-end`
		- ![](https://i.imgur.com/Fi7ZqE5.png)

	- `center`
		- ![](https://i.imgur.com/swkg1YU.png)
	- `stretch` 
		- item沒設定高度時的預設
		- item有設定高度時，以設定的高度為優先
		- ![](https://i.imgur.com/BnRv9o7.png)




---
reference
[圖解：CSS Flex 屬性一點也不難 | 卡斯伯 Blog - 前端，沒有極限](https://wcc723.github.io/css/2017/07/21/css-flex/)