FROM java:8

LABEL maintainer="969795191@qq.com"

#RUN wget http://apache-mirror.rbc.ru/pub/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz \
#    && tar xzvf apache-maven-3.3.9-bin.tar.gz \
#    && cp -R apache-maven-3.3.9 /usr/local/bin
#RUN export PATH=apache-maven-3.3.9/bin:$PATH
#RUN export PATH=/usr/local/bin/apache-maven-3.3.9/bin:$PATH
#RUN ln -s /usr/local/bin/apache-maven-3.3.9/bin/mvn /usr/local/bin/mvn
#RUN ls -l /usr/local/bin
#RUN echo $PATH

#RUN mvn clean install
COPY /target/springboot-mybatisplus.jar .

CMD ["java", "-jar", "springboot-mybatisplus.jar"]