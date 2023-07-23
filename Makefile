.PHONY: test
test:
	lein test

checks: check-format check-namespaces check-style

check-format:
	lein cljfmt check

check-style:
	lein kibit

check-namespaces:
	lein eastwood

format:
	lein cljfmt fix

grapviz:
	lein run -m sicp.extra.graph.render-all
