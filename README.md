<img src="https://github.githubassets.com/images/icons/emoji/unicode/1f4d6.png?v8" width="32px"
/>  BibleReader
===============

<a href="https://twitch.tv/veganaiZe/"><img src="https://user-images.githubusercontent.com/7102064/206958552-d4773c34-95c3-4069-b7f6-52aa12287742.png" width="16px"
/> _Join me improving this on twitch!_</a>

Compile
-------

_Setup MSVC / GRAALVM Enviroment_
```
"C:\Program Files (x86)\Microsoft Visual Studio\2019\BuildTools\VC\Auxiliary\Build\vcvars64.bat"

SET GRAALVM_HOME=c:\graalvm
SET PATH=%GRAALVM_HOME%\bin;%PATH%
SET JAVA_HOME=%GRAALVM_HOME%
```

_Compile Java Files_
```
mkdir out
cd out
javac -source 1.4 -Xmaxerrs 1 -Xlint:-options ../src/*.java
jar cvfe BibleReader.jar Main -C ../src .
```

_Create Native Binary (.EXE)_
```
native-image -jar BibleReader.jar -H:IncludeResources=".*txt$"
```
