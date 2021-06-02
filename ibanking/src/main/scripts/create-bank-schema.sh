#!/bin/bash

mysql -uroot -proot < /tmp/bank-schema.sql

echo "cleaning up..."
rm -rf /tmp/bank-schema.sql
echo "database created"