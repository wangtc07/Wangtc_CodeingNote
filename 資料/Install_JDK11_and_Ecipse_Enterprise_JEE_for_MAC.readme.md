1.  According to following steps to download and install openjdk 11

[open terminal: /Applications/Utilities/Terminal]
----------------------------------------------------
$ curl -C - https://download.java.net/java/ga/jdk11/openjdk-11_osx-x64_bin.tar.gz -O openjdk-11_osx-x64_bin.tar.gz
$ tar xf openjdk-11_osx-x64_bin.tar.gz
$ sudo mv jdk-11.jdk /Library/Java/JavaVirtualMachines/
$ java -version
openjdk version "11" 2018-09-25
OpenJDK Runtime Environment 18.9 (build 11+28)
OpenJDK 64-Bit Server VM 18.9 (build 11+28, mixed mode)
----------------------------------------------------

2. Download Eclipse IDE for Enterprise Java and Web Developers at 
   https://www.eclipse.org/downloads/packages/
    
   click "macOS x86_64" under "Eclipse IDE for Enterprise Java and Web Developers"
   to download "Eclipse IDE for Enterprise Java and Web Developers"
   
3. Install Eclipse 
   click "eclipse-jee-2021-03-R-macosx-cocoa-x86_64.dmg" at 下載項目
   
4. Open Finder
   click Eclipse under Applications
   right-click, choose "顯示套件內容"
   make a copy of Contents/Eclipse/eclipse.ini
   open Contents/Eclipse/eclipse.ini
   replace the following line beneath -vm
   "../Eclipse/plugins/org.eclipse.justj.openjdk.hotspot.jre.full.macosx.x86_64_15.0.2.v20210201-0955/"
   with
  "/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/home"

5. save eclipse.ini
6. launch your Eclipse IDE for Enterprise Java and Web Developers   
            