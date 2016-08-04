Initial Setup

WINDOWS:
1) Download JDK
Go to http://java.sun.com/javase/downloads/index.jsp
Select the appropriate JDK Version (Accept License Agreement)

Choose the following install location:  C:\Program Files\Java\jdk1.8.0_77

2) Set the system variables
Right click on MyComputer -> Properties -> Advanced ->  Environment Variables
Under System Variables set the following:
JAVA_HOME - C:\Program Files\Java\jdk1.8.0_77
Path - at the end - append: %JAVA_HOME%\bin;

Set JAVA_HOME variable tutorial:  https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html

3) Install Eclipse EE (Mars)
Go to http://www.eclipse.org/downloads/packages/release/Mars/2
Choose: Eclipse IDE for Java EE Developers - the appropiate version (32 bit or 64 bit)
Click Download
Extract the zip to D:\Programs\Eclipse-EE\Mars


4) Workspace setup
Create the following folder: D:\Workspaces\JavaEE\Internship
When you open Eclipse select the above folder as Workspace Location

5) Explore
Create Java Project
Packages
Perspectives
Run/Debug
Import/Export
Run Configurations - Arguments
Install New Software - EGit, Objectaid (http://www.objectaid.com/installation)



For OS X: http://www.mkyong.com/java/how-to-set-java_home-environment-variable-on-mac-os-x/
For Linux: http://linuxpitstop.com/install-eclipse-ide-on-ubuntu-linux-15-04/