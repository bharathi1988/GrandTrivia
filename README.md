# Grand Trivia App

## Setup for DB Docker Volumes

### % docker volume create triviavolume

### % docker volume inspect triviavolume

### % docker run --name mysql_trivia_svc -v triviavolume:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=notsecure -d --rm mysql

### % docker exec -it mysql_trivia_svc sh -c "mysql -u root -p”

#### mysql> CREATE DATABASE triviadb;

#### mysql> show databases;

#### mysql> exit

### % docker stop mysql_trivia_svc

### docker run --name mysql_trivia_svc2 -v triviavolume:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=notsecure -d --rm mysql

### % docker exec -it mysql_trivia_svc2 sh -c "mysql -u root -p"

#### mysql> show databases;
