FROM java:8

LABEL maintainer="969795191@qq.com"

COPY /target/springboot-mybatisplus.jar .

CMD ["java", "-jar", "springboot-mybatisplus.jar"]