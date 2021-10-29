CREATE DATABASE IF NOT EXISTS `personne`;

CREATE USER 'quarkus'@'%' IDENTIFIED BY 'quarkus';

GRANT ALL PRIVILEGES ON `personne`.* TO 'quarkus'@'%';

SET GLOBAL max_allowed_packet = 1024 * 1024 * 256;
