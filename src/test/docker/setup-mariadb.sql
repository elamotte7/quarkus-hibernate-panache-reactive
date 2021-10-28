CREATE DATABASE IF NOT EXISTS `csn_ficen_personne`;

CREATE USER 'quarkus'@'%' IDENTIFIED BY 'quarkus';

GRANT ALL PRIVILEGES ON `csn_ficen_personne`.* TO 'quarkus'@'%';

SET GLOBAL max_allowed_packet = 1024 * 1024 * 256;
