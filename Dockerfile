FROM jenkins/jenkins:2.118-alpine

#get rid of admin password setup
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
#automatically installing all plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

COPY groovy/01-securityRealm.groovy /var/jenkins_home/init.groovy.d/01-securityRealm.groovy
COPY groovy/02-authorizationStrategy.groovy /var/jenkins_home/init.groovy.d/02-authorizationStrategy.groovy
