docker run -d -p 3306:3306 --name mysqltest mysqlserver:1
docker exec -i mysqltest sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD"' < customer.sql
