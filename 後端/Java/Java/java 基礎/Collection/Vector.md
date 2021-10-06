- `Vector`類實現了可增長的對象數組。
- 該類被改進以實現List接口，使其成為Java Collections Framework的成員。
- `Vector`是同步的。
	-  如果不需要線程安全實現，建議使用`ArrayList`
- 代替 `Vector`
	-  使用 `Collections` 的 `synchronizedList​(List<T> list)` 方法，對 `ArrayList` 進行同步

