# IS-E

Hallo Zusammen (dieses Readme wird laufend erweitert). 

- Ihr solltet nach dem Clonen den SQL-Connector zum Projekt hinzufuegen.
- Der Tomcat-Server befindet sich aber mit der entsprechende Config. (Tomcat 9 wird hier verwendet, falls ihr Probleme hab ladet ihr
  am besten von [diesem Link.] (http://www-eu.apache.org/dist/tomcat/tomcat-9/v9.0.0.M6/bin/apache-tomcat-9.0.0.M6.zip)



##Einstellung


%CATALINA_HOME%\bin\startup.bat
%CATALINA_HOME%\bin\shutdown.bat

cd C:\apache-tomcat-9.0.0.M1\webapps\reisen\WEB-INF\classes

set CLASSPATH=C:\Users\Daos\Downloads\apache-tomcat-9.0.0.M6\lib\mysql-connector-java-5.1.39-bin.jar;C:\Users\Daos\Downloads\apache-tomcat-9.0.0.M6\lib\servlet-api.jar;

javac ise\*.java
javac ise\servlets\*.java





///////////////////////
1- JRE_HOME       jre Verzeichnis eingeben ---> (Am Ende kein "\")
2- JAVA_HOME      jdk Verzeichnis eingeben
3- CATALINA_HOME  Tomcat-Verzeichnis


----1ste CMD
set CLASSPATH=C:\Users\Daos\Downloads\apache-tomcat-9.0.0.M6\lib\mysql-connector-java-5.1.39-bin.jar;C:\Users\Daos\Downloads\apache-tomcat-9.0.0.M6\lib\servlet-api.jar;
----------Immer Einstellen, bei jeder Fenster-Eroeffnung------ (import der Jars)


javac ise\*.java
javac ise\servlets\*.java

----2te CMD
%CATALINA_HOME%\bin\startup.bat
%CATALINA_HOME%\bin\shutdown.bat


----Compilieren bei jeder Code-Aenderung

javac -Asd.java
java Asd
