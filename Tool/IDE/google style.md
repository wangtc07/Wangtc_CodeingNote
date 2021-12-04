google-java-format 是一個重新格式化Java源代碼以符合 Google Java Style 的插件。
一個 google-java-format 可從插件庫下載 也可以在IDE的File→Settings–>Plugins中下載。單擊Marketplace選項卡，搜索google-java-format插件，然後單擊Install按鈕。
默認情況下，該插件將被禁用。要在當前項目中啟用它，請轉到File→Settings…→google-java-format Settings（或IntelliJ IDEA→Preferences…→Other Settings→google-java-format Settings在macOS上）並選中Enable google-java-format復選框（當您安裝完畢重啟idea以後，將顯示通知，讓你激活這個插件）。

要在新項目中默認啟用它，請使用File→Other Settings→Default Settings…。

啟用後，它將替換通常的Reformat Code操作，該操作可以從Code菜單中觸發，也可以使用Ctrl-Alt-L（默認情況下）鍵盤快捷鍵觸發。

不幸的是，此插件未處理導入順序。要修復導入順序，請下載 IntelliJ Java Google樣式文件， 然後將其導入，File→Settings→Editor→Code Style.