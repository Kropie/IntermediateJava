@echo off

setlocal

rem TODO: change this to match your environment
set M2_HOME=C:\StudentWork\IntmJ\Software\maven

%M2_HOME%\bin\mvn %*

endlocal