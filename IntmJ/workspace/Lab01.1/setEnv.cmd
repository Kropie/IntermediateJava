@rem The JAVA_HOME environment variable points to the Java home directory.
@rem If you do not have the full Java JDK on your classpath, AND if you 
@rem do not have the JAVA_HOME environment variable set, then you can use this command file
@rem to set up an open command prompt so that Java is usable from the command line.
@rem We include appropriate versions for several different environments.  You'll need to 
@rem find the one for your environment, and modify it as needed (e.g. to use the correct version number
@rem and installation location).

@rem Uncomment and configure JAVA_HOME for your environment

@rem *** This is correct for JDK 1.8.0_101 - change if using another version ***
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_101

@rem *** This is correct for JDK 1.7.0_67 - change if using another version ***
@rem set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_67

@rem *** For RAD uncomment the next two lines *** 
@rem set RAD_HOME=C:\Program Files\IBM\SDP
@rem set JAVA_HOME=%RAD_HOME%\jdk

REM The next line sets your path up to include the Java tools
set PATH=%JAVA_HOME%\bin;%PATH%

REM The following unsets the CLASSPATH since we want the default CLASSPATH for this simple lab
set CLASSPATH=
