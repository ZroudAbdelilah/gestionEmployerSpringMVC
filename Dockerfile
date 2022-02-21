FROM tomcat:8.5.75-jdk8-openjdk-slim
WORKDIR /usr/local/tomcat

COPY ./target/buildemployer.war ./webapps/gestionemployer.war
CMD ["catalina.sh","run"]