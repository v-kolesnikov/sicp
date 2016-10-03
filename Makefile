APP_HOME := '/sicp'
TAG := v-kolesnikov/sicp
TEST_COMMAND := lein trampoline test
REPL_PORT := 48789

include docker.mk

grapviz:
	lein run -m sicp.extra.graph.render-all

format:
	lein cljfmt fix

checks: check-format check-namespaces check-style

check-format:
	lein cljfmt check

check-style:
	lein kibit

check-namespaces:
	lein eastwood

.PHONY: test
