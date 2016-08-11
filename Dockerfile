from clojure

ADD project.clj /app/project.clj
WORKDIR /app
RUN lein deps
