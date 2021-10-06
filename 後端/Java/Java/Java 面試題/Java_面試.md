[Java面試題整理. 本文主要針對Java常見面試考題進行彙整，未來會持續增加題目並且更新回答完整性。… | by Liu Cheng Lee | 技術學習 | Medium](https://medium.com/%E7%A7%91%E6%8A%80%E7%A0%94%E7%A9%B6%E9%99%A2/java%E9%9D%A2%E8%A9%A6%E9%A1%8C%E6%95%B4%E7%90%86-ed44d4b10437)


# 面向對象
- 面向過程注重步驟及順序
- 面向對象
	- 注重對象，易於復用和維護
	- 封裝
		- 將描述同個物件的屬性和行為，封裝到一個類中，並且可控制資訊的公開程度，使物件的設計者跟使用這分開
	- 繼承
		- 子類繼承父類，子類可以擁有父類的屬性、方法
	- 多態
		- 父類引用子類對象，使用父類作為參數，使用具體的子類做操作，提高程序擴展性，但不能使用子類特有方法

# JDK , JRE , JVM
jdk > jre > jvm
- JDK
	- java開發工具
- JRE
	- java運行時環境
- JVM
	- java虛擬機

# == equals
- `==` 
	- 基本型別 比較的是值是否相同
	- 引用型別 比較內存中的值
- `equals`
	- 默認使用 `==`
	- String覆寫後的equals方法，比較的是內容值
	- 多用於複寫

# ++ --
- `++i` `--i` 前置 先做加減法
- `i++` `i--` 後置 後做加減法

# 為什麼要有包裝型別？
- 讓基本資料型別也具有物件的特徵
	- 如我們在使用集合型別 `Collection` 時就一定要使用包裝型別而非基本型別
	  因為容器都是裝object的，這是就需要這些基本型別的包裝器類了。

# String StringBuffer StringBuilder
- String
	- final修飾
- StringBuffer
	- 在原對象操作
	- 線程安全
- StringBuilder
	- 在原對象操作
	- 線程不安全
性能:  StringBuilder > StringBuffer > String

# 重載 重寫
- 重載
	- 同一類中，方法名相同，參數類型、個數、順序不同
- 重寫 `@override`
	- 發生在父子類中
	- `@override` 返回值、異常範圍要小於父類

# 接口 抽象類
- 接口
	- 只能存在public abstract方法
	- 成員變量只能是 `public static final`
	- 多實現
	- 約束行為的有無，不對實現行為進行限制
- 抽象類
	- 可以存在普通成員函數
	- 成員變量可以是各種類型
	- 單繼承
	- 目的: 代碼的復用
	- 不允許實例化

# List Set Map
[Collection (notion.so)](https://www.notion.so/wangtc07/Collection-8b5b77df44674b31b0720e6eeb6b2fa7#6bd33eac70d54a05a7c32a8ddee7b4ee)
- `List`
	- 有序，按照對象進入的順序
	- 可重複
	- ArrayList : 插入、刪除速度慢，走訪速度快
		- 基於陣列
	- LinkedList : 插入、刪除速度快，走訪速度慢，雙向連結
		- 基於鏈表
- `Set`
	- 無序
	- 不可重複
	- `HashSet` : 無順序性，查找速度快
	- `LinkedHashSet` : 有順序性
	- `TreeSet` : 有排序性(依字母，自然排序)
- `Map` 有鍵值對，在Map中保證了key與value之間的一對一對應關係 
	- `HashMap`
		- 無序的
		- 不支持線程的同步
			- 如果需要同步，可以用 Collections的 `synchronizedMap()` 方法使HashMap具有同步的能力，或者使用 `ConcurrentHashMap` 。 
	- `LinkedHashMap`
		- 有序的
	- `TreeMap`
		- 有排序性(依字母，自然排序)



# HashSet如何確保數據唯一性
- 先比較hash值，相同的話再比較數據
![](https://i.imgur.com/psxVcgW.png)

# hashCode
- hashCode
	- Object 定義
	- 返回int型整數(索引)
	- 儲存鍵值對，能快速地依照key找出value

# static都有哪些用法?
- static可使用在**變數**、**方法**(不含建構子)、**區塊**、**內部類別**
- 在載入class時會會先載入static
- 在class內被static宣告的的成員只會有一個
- 不依附在物件上，可直接使用(不需要通過new實例化)


# final 在 Java 中有什麼作用？
- 可用在 類別、方法、變數
  代表不能再被繼承、override、修改
	- final修飾的類不可以被繼承
	- final修飾的方法不可以被重寫
	- final修飾的變數不可以被改變



# 異常
- 所有異常都來自 `Throwable`
- `Throwable` 下子類
	- `Exception` 不會導致程序停止
		- `RunTimeException` 運行時異常
		- `CheckedExecption`
	- `Error` 程序無法處理的錯誤，程序會被迫停止

# 線程的生命週期、狀態
- 狀態
	- 創建 new
	- 就緒 Runnable
		- 線程創建後，其他線程調用該對象的 `start` 方法，等待獲取cpu的使用權
	- 運行 Running
	- 阻塞 Blocked
		- 線程因某種原因放棄CPU使用權，暫時停止運行，直到線程進入就緒狀態，才有機會轉到運行狀態
	- 死亡 Daed

# 線程 sleep() wait() join() yield()
[sleep() wait() join() yield()](https://www.bilibili.com/video/BV1Eb4y1R7zd?p=21&spm_id_from=pageDriver)
- 鎖池 使用線程安全
	- 所有需要競爭同步鎖的線程，都會放在鎖池中。線程得到同步鎖後，會進入就緒狀態，其他線程則停留在鎖池中等待。
- 等待池
	- 調用 `wait()` 方法後，線程會放入等待池中，不會去競爭同步鎖。調用 `notify()` `notifyAll()` 後，才會開始競爭同步鎖
- `sleep()`
	- Thread 類的本地方法
	- 不會釋放鎖
- `wait()`
	- Object 類的方法
	- 會釋放鎖，且加入到等待池中

# 為什麼有些java類要實現Serializable介面
- 為了網路進行傳輸或者持久化
- 什麼是序列化
	- 將物件的狀態資訊**轉換為可以儲存或傳輸的形式的過程**

# 泛型常用特點
