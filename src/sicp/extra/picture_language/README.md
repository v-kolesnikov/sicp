# [SICP](https://github.com/justCxx/sicp)

## [Extra modules](../README.md)

### Picture language

#### How to run examples

##### Using `lein run`
Use following command to run selected sketch:

`lein run -m sicp.extra.picture-language.examples.rodger`

When you close sketch JVM won't exit, so you need to do it manually e.g. using Ctrl+C combination.

##### Using lein REPL

Start REPL:

```shell
lein repl
```

Require selected sketch to run it:

```clojure
(require 'sicp.extra.picture-language.examples.rodger)
```

And show it:

```clojure
(sicp.extra.picture-language.examples.rodger/show-sketch)
```
