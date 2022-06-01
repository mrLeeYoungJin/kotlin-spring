# kotlin-spring
kotlin-spring

## mysql

````
docker run --name mysql -p 3306:3306 -v /Users/mrlee/workspace/dev/data/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=test1234 -d mysql --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
````