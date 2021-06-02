set timeout 10
spawn sudo mysql_secure_installation

expect "Enter password for user root:"
send "root\r"
expect "Press y|Y for Yes, any other key for No:"
send "No\r"
expect "Change the password for root ? ((Press y|Y for Yes, any other key for No) :"
send "No\r"
expect "Remove anonymous users? (Press y|Y for Yes, any other key for No) :"
send "No\r"
expect "Disallow root login remotely? (Press y|Y for Yes, any other key for No) :"
send "No\r"
expect "Remove test database and access to it? (Press y|Y for Yes, any other key for No) :"
send "No\r"
expect "Reload privilege tables now? (Press y|Y for Yes, any other key for No) :"
send "Yes\r"
expect eof






