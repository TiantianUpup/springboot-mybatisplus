FROM mysql/mysql-server

LABEL maintainer="969795191@qq.com"

COPY rbac.sql /docker-entrypoint-initdb.d/