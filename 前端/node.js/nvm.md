```ad-info
title:nvm
Node.js 的版本管理器
[nvm-sh/nvm: Node Version Manager - POSIX-compliant bash script to manage multiple active node.js versions (github.com)](https://github.com/nvm-sh/nvm#install--update-script)
````

# 安裝
## Install & Update Script

To **install** or **update** nvm, you should run the [install script](https://github.com/nvm-sh/nvm/blob/v0.39.0/install.sh). To do that, you may either download and run the script manually, or use the following cURL or Wget command:
```bash
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash
```
```bash
wget -qO- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash
```

- 安裝

	```bash
	nvm install [版本號]
	```

- 切換版本

	```bash
	nvm use 8
	```

- 移除版本

	```bash
	nvm uninstall 8
	```