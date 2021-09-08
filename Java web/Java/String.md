# StringBuffer
[StringBuffer](https://www.apiref.com/java11-zh/java.base/java/lang/StringBuffer.html)
==A thread-safe==, mutable sequence of characters.
線程安全，可變的字符序列
```java
public StringBuffer delete(int start, int end)
```
刪除此序列的子字符串中的字符。 子字符串從指定的start開始，如果不存在這樣的字符，則擴展到索引end - 1處的字符或序列的末尾。 如果start等於end ，則不進行任何更改。

# StringBuilder
A mutable sequence of characters.
可變的字符序列
- ==單一執行緒下==，用`StringBuilder`效能好很多
	> This class is designed for use as a ==drop-in replacement== for `StringBuffer` in places where the string buffer was being used by a single thread (as is generally the case).
	> 此類設計用作`StringBuffer`==替代品==，用於單個線程使用字符串緩沖區的位置（通常情況下）。 在可能的情況下，建議使用此類優先於`StringBuffer`因為在大多數實現中它會更快。