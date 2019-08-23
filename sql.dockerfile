FROM mysql:5.7.17

LABEL maintainer="969795191@qq.com"

COPY /sql/test.sql /docker-entrypoint-initdb.d/