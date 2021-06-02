#!/bin/bash

export DEBAIN_FRONTEND="noninteractive"
sudo apt update
sudo apt install -y debconf-utils
sudo apt install -y expect

echo "mysql-server-5.7 mysql-server/root_password password root" | sudo debconf-set-selections
echo "mysql-server-5.7 mysql-server/root_password_again password root" | sudo debconf-set-selections

sudo apt install -y mysql-server-5.7
echo "mysql server 5.7 installed"

echo "changing bind address in mysql.conf"
sed -i 's/.*bind-address.*/bind-address=0.0.0.0/' /etc/mysql/mysql.conf.d/mysqld.cnf

mysql -uroot -proot -e "GRANT ALL ON *.* TO root@192.168.1.3 IDENTIFIED BY 'root' WITH GRANT OPTION"
sudo systemctl restart mysql



#secure mysql installation
ls -l /tmp
/usr/bin/expect -f /tmp/mysql-secure.sh

echo "cleaning up...."
rm -rf /tmp/mysql-secure.sh

echo "mysql secure installation finished"
