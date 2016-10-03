VOLUME := $(CURDIR):$(APP_HOME)
RUN := run --rm -v $(VOLUME)

# Docker image and container
build:
	docker build -t $(TAG) .

clean:
	docker rmi $(TAG)

run:
	docker $(RUN) $(TAG) $(COMMAND)

run-it:
	docker $(RUN) -it $(TAG) $(COMMAND)

# Application
bash:
	docker $(RUN) -it $(TAG) bash

repl:
	docker $(RUN) -it -p $(REPL_PORT):$(REPL_PORT) $(TAG) lein repl :start :host 0.0.0.0 :port $(REPL_PORT)

test:
	docker $(RUN) $(TAG) $(TEST_COMMAND)

.PHONY: test
