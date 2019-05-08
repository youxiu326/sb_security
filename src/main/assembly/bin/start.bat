@echo off

set LIB_JARS=""
cd ..\lib
for %%i in (*) do set LIB_JARS=lib\%%i
cd ..

if ""%1"" == ""debug"" goto debug

java -Xms64m -Xmx1024m -XX:MaxPermSize=64M -jar %LIB_JARS% --spring.config.location=conf/ 

:debug
set debugPort=8000
echo Debug listner port %debugPort%
java -Xms64m -Xmx512m -XX:MaxPermSize=64M -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=%debugPort%,server=y,suspend=n -jar %LIB_JARS% --spring.config.location=conf/ 