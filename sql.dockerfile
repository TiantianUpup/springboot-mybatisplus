FROM mysql/mysql-server

LABEL maintainer="969795191@qq.com"

COPY /sql/ /docker-entrypoint-initdb.d/