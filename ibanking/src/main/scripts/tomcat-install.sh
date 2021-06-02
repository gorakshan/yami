#!/bin/bash

sudo apt update
sudo apt install -y openjdk-8-jdk

sudo mkdir -p /u01/data
cd /u01/data
if [ -f /u01/data/apache-tomcat-9.0.37 ]
then
    echo "already tomcat installed"
else
    sudo wget https://mirrors.estointernet.in/apache/tomcat/tomcat-9/v9.0.37/bin/apache-tomcat-9.0.37.tar.gz
    sudo gunzip apache-tomcat-9.0.37.tar.gz
    sudo tar -xvf apache-tomcat-9.0.37.tar
    sudo rm apache-tomcat-9.0.37.tar
fi
#sudo /u01/data/apache-tomcat-9.0.37/bin/startup.sh