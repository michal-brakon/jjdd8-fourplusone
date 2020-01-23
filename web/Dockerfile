FROM jboss/wildfly

RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#70365 --silent

USER root

ADD target/four-plus-one.war /opt/jboss/wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0","-bmanagement", "0.0.0.0"]

RUN cd /opt
RUN yum -y install wget
RUN wget https://download.java.net/java/GA/jdk13/5b8a42f3905b406298b72d750b6919f6/33/GPL/openjdk-13_linux-x64_bin.tar.gz
RUN tar -xvf openjdk-13_linux-x64_bin.tar.gz
RUN echo "JAVA_HOME=/opt/jboss/jdk-13" >> /opt/jboss/wildfly/bin/standalone.conf


