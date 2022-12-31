FROM mysql:8.0

ADD ./mysql-init-files /docker-entrypoint-initdb.d

EXPOSE 3306

CMD ["mysqld"]
