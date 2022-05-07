-   查詢 PID

```
// 查詢 Port:3000 狀態 
sudo lsof -i:3000 
```

在終端機輸入此指令後應該會出現下列格式資訊，其中 32952 為你的 PID。

```
COMMAND   PID     USER   FD   TYPE             DEVICE SIZE/OFF NODE NAME
vpnkit  32952    yilin   22u  IPv4 0xa7d3c3f8be099a63      0t0  TCP *:3000 (LISTEN)
vpnkit  32952    yilin   23u  IPv6 0xa7d3c3f8aa7a227b      0t0  TCP localhost:3000 (LISTEN)
```

-   清除 PID

使用 kill + PID 就能將此排程從背景釋放，就能解決 Port 被佔用的問題了！

```
kill 32952
```