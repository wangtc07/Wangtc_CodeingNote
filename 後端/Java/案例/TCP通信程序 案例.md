# 案例需求
- 客戶端:數據來自於文本文件，接收服務器反饋 
- 服務器:接收到的數據寫入文本文件，給出反饋 
	- 代碼用線程進行封裝，為每一個客戶端開啟一個線程
- 案例分析
	- 創建客戶端對象，創建輸入流對象指向文件，每讀入一行數據就給服務器輸出一行數據，
		- 輸出結束後使用`shutdownOutput()`方法告知服務端傳輸結束 
	- 創建服務器對象，創建輸出流對象指向文件，每接受一行數據就使用輸出流輸出到文件中，傳輸結束後。使用輸出流給客戶端反饋信息
	- 客戶端接受服務端的回饋信息

# Server
```java
/**
 * 數據寫到文本文件
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        // ServerSocket (int port)
        ServerSocket serverSocket = new ServerSocket(10000);

        while (true){
            // Socket	accept() 監聽客戶端
            Socket socket = serverSocket.accept();

            // 為每一個客戶端開啟一個線程
            new Thread(new ServerThread(socket)).start();
        }

    }
}
```

```java
public class ServerThread implements Runnable {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    // 接收數據，寫到文本文件
    @Override
    public void run() {
        // 解決文件名衝突
        int count = 0;
        File file = new File("./TCP/Demo_6_" + count  );
        while (file.exists()){
            count++;
            file = new File("./TCP/Demo_6_" + count + ".txt" );
        }
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            BufferedWriter bw = new BufferedWriter(new FileWriter("./TCP/Demo_6.txt"));
            // 解決文件名衝突
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            // 給出反饋
            BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                ) {
            String line ;
            while ((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();
                System.out.println(line);
            }

            bwServer.write("文件上傳成功");
            bwServer.newLine();
//            bwServer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```


# Client
```java
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10000);

        // 鍵盤輸入
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 封裝文本文件
        BufferedReader br = new BufferedReader(new FileReader("./TCP/Demo_5_Client.txt"));

        // 封裝輸出流對象
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line ;
        while ((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
//        System.out.println("====");

        // 自定義結束標記
//        bw.write("886");
//        bw.newLine();
//        bw.flush();
		// 取代自定義結束標記
        socket.shutdownOutput();

        // 接收反饋
        BufferedReader brClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String data = brClient.readLine();  // 等待讀取數據
        System.out.println("server back: " + data);

        // 釋放資源
        br.close();
        socket.close();
    }
}
```