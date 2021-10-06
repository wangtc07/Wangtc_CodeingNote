> 為了更清晰的表達如何加鎖和釋放鎖，JDK5以後提供了一個新的鎖對象Lock

- `Lock` 中提供的方法
	- `void	lock()`
	- `void	unlock()`


- Lock是接口不能直接實例化，這裡採用它的實現類`ReentrantLock`來實例化

```java
public class SellTicket implements Runnable {

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            // 如果在釋放所之前發生異常，鎖就沒辦法被解開
            /*
            lock.lock();
			執行代碼
            lock.unlock();
             */

            // 發生異常的話，最後都會釋放鎖
            try {
                lock.lock();
				執行代碼
            } finally {
                lock.unlock();
            }
        }
    }
}
```