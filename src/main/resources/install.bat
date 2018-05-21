@echo off
::运行安装脚本
set Directory=%~dp0
set Directory=%Directory:~0,-1%
for %%d in (%Directory%) do set ParentDirectory=%%~dpd
echo ParentDirectory=%ParentDirectory%
echo CurrentDirectory=%cd%
set CLASSPATH=%CLASSPATH%;%CurrentDirectory%;%ParentDirectory%\lib\*;
echo %CLASSPATH%

rem echo %CLASSPATH%
java cn.smartx.tools.Installer

