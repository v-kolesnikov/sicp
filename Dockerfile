from clojure:lein-2.7.1
MAINTAINER Vasily Kolesnikov re.vkolesnikov@gmail.com

ENV APP_HOME /sicp
WORKDIR /sicp

ADD project.clj $APP_HOME/project.clj
RUN lein deps

USER root
CMD bash
