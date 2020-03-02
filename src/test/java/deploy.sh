yum -y update
yum -y install java nginx redis mariadb mariadb-server
systemctl start  nginx
systemctl enable nginx
systemctl start  redis
systemctl enable redis
systemctl start  mariadb
systemctl enable mariadb
mysql_secure_installation

DROP DATABASE IF EXISTS `push`;
CREATE DATABASE IF NOT EXISTS `qicaiqianbao` DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;

scp ssl/* root@h5.qicaiqianbao.vip:/etc/nginx/conf.d/

mysql: /etc/my.conf lower_case_table_names=1
nginx: /etc/nginx/nginx.conf root
redis: /etc/redis.conf pass
mysqladmin -uroot -p shutdown


