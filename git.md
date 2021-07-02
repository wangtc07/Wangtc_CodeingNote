[目錄 | 連猴子都能懂的Git入門指南 | 貝格樂（Backlog）](https://backlog.com/git-tutorial/tw/contents/)

---
# SSH
## 產生公私鑰
```bash
TCde-MacBook-Pro:~ tcwang$ ssh-keygen -t rsa -C "wangtc07-github-key"
Generating public/private rsa key pair.
Enter file in which to save the key (/Users/tcwang/.ssh/id_rsa): 
Created directory '/Users/tcwang/.ssh'.
Enter passphrase (empty for no passphrase): 
Enter same passphrase again: 
Your identification has been saved in /Users/tcwang/.ssh/id_rsa.
Your public key has been saved in /Users/tcwang/.ssh/id_rsa.pub.
The key fingerprint is:
SHA256:2PCf026ll/Rarm5KuUh9cIFaXPKMDXtUtvao1c5kkwY wangtc07-github-key
The key's randomart image is:
+---[RSA 3072]----+
|            o o.o|
|           . % ..|
|      .     *E*o |
|       =   o .o+o|
|      . S . . ++=|
|         . + *+=.|
|          = *+.o+|
|         . =oo+o.|
|          ..+=+o.|
+----[SHA256]-----+
TCde-MacBook-Pro:~ tcwang$ 
```



![](https://i.imgur.com/eF8OFAy.png)

![](https://i.imgur.com/KMfwH7s.png)
