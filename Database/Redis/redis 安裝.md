# 安裝並啟動 Redis
1. 打開終端機輸入下面指令安裝 Homebrew（若安裝過請忽略）
	1. `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`
2. 使用 Homebrew 安裝 Redis
	1. `brew install redis`
3. 啟動 Redis
	1. 啟動 Server 終端機執行指令 `redis-server`
	2. 開一個 Terminal 啟動 Client 終端機執行指令 `redis-cli` （如果沒開新的 Terminal 直接做是不行的喔！）
4. 測試 Redis 基礎功能
	1. 
		```
		ping  
		set foo bar  
		get foo
		```
		
		
		
# 安裝及使用 Another Redis Desktop Manager

1. 使用 Homebrew 安裝
	1. `brew install --cask another-redis-desktop-manager`
2. 打開後迎面而來的是簡潔有力的畫面，點擊左上角「New Connection」建立新連線
![](https://miro.medium.com/max/1400/1*KHYTZm-_ffUBvkqDyayNxg.png)

3. 直接使用默認的設定即可，按下「OK」
![](https://miro.medium.com/max/1400/1*Fv84_PU7MCT7EeLMwseirA.png)

4. 最後進入 DB 確認剛剛建立的 key-value(foo-bar) 是否存在
> 如果 redis 沒有選擇 DB，預設都是 0

![](https://miro.medium.com/max/1400/1*Eq6Sf9YcSM_doiLAJIIxRw.png)