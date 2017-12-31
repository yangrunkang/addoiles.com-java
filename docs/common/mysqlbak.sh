#!/bin/bash
db_user="root"
db_passwd="aliyunmysql.#7vh"
db_name="addoiles"
# the directory for story your backup file.you shall change this dir
backup_dir="/usr/services/mysqlbak"
# date format for backup file (dd-mm-yyyy)
time="$(date +"%Y%m%d%H%M%S")"
echo 'back up addoiles....'
mysqldump -u$db_user  -p$db_passwd $db_name  > "$backup_dir/$db_name"_"$time.sql"
# tar
cd ..
tar -czf "$db_name"_"$time.tar.gz" "$db_name"_"$time.sql"
rm -rf "$db_name"_"$time.sql"
