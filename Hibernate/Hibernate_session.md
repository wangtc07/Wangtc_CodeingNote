# Session

- `save()` 
	- 把一個新的物件儲存
	- 會立即觸發 sql指令
- `persist()` 
	- 需要先開啟交易，才能使用
	- 將物件持久化，但不保證 id 立即填入，會推遲到 `flish()` 後
- `merge()` 
	- 回傳一個_狀態為持久層的新的物件_
	- 作為參數_傳入的物件_，狀態還是_分離狀態_

- `update()` 
	- 把 detached 狀態的物件儲存，僅對 detached 狀態有效
	- 物件狀態 👉 persistent

- `flash()`
	- 同步 Session 跟 資料庫的紀錄

- `get()` `load()`
	- `load()` 沒找到會拋異常，`get()` 返回 null

> get和load方法都是根據id去獲得對應數據的，但是獲得機制不同：
> 如果使用get方法，hibernate會去確認該id對應的數據是否存在，它首先會去session中去查詢(session緩存其實就hibernate的一級緩存)，
> 如果沒有，再去二級緩存中去查詢，如果再沒有，就去數據庫中查詢，仍然沒有找到的話，就返回null <br>
> 而使用load方法的話，hibernate會認定該id對應的數據一定存在，
> 它也會先去session緩存中去查找，如果沒有找到，hibernate會根據lazy屬性值來確定是否使用延遲加載。
> 如果lazy=‘true’ ，就使用延遲加載，返回該代理對象，等到真正訪問到該對象的屬性時才會去二級緩存中查詢，
> 如果沒有，再去數據庫中查詢，
> 如果還沒有，就拋出org.hibernate.ObjectNotFoundException異常。
如果lazy='false' 則不使用延遲加載，這是load的訪問機制就和get一樣了。