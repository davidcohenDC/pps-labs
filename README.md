# PPS labs

[![Build](https://github.com/davidcohenDC/pps-labs/actions/workflows/build.yml/badge.svg)](https://github.com/davidcohenDC/pps-labs/actions/workflows/build.yml)
[![Release](https://img.shields.io/github/v/release/davidcohenDC/pps-labs)](https://github.com/davidcohenDC/pps-labs/releases/latest)
[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

My labs for the Programming Paradigms and Development course (PPS) of the
master's degree in Computer Science and Engineering at the University of
Bologna. The first two are in Java with JUnit 5, the other five in Scala 3.
There is a single sbt build at the root, so `sbt test` compiles everything
and runs the 145 tests.

Each folder is one lab: the scaffolding handed out in class and my commits on
top of it.

## The labs

- **[01-tdd-java](01-tdd-java)**: test-driven development. A bank account
  that gets an ATM and fees, and three circular lists (a basic one, one with a
  cyclic iterator, one driven by a strategy), all written test first;
- **[02-catch-the-pawn](02-catch-the-pawn)**: a knight chasing a pawn on a
  grid. The starting point was a working Swing program with the logic in one
  class; I split it into model, engine and logics with factories and covered
  every part with JUnit 5. The second exercise is a small Minesweeper with
  recursive reveal;
- **[03-scala-functions](03-scala-functions)**: first steps in Scala.
  Currying, composition, recursion, sum and product types, pattern matching on
  binary trees, optionals, and the same things in Java 8 for comparison;
- **[04-lists-and-streams](04-lists-and-streams)**: an immutable `List` and a
  lazy `Stream` written from scratch, plus the lambda and laziness exercises
  built on them;
- **[05-polyglot-warehouse](05-polyglot-warehouse)**: a `Warehouse` and a
  `SecondDegreePolynomial` on top of my own `List` and `Option`, and three
  exercises where a Java Swing GUI drives logic written in Scala;
- **[06-collections](06-collections)**: the standard library. A `List` with
  `zipRight`, `partition`, `span`, `reduce` and `takeRight`; a conference
  reviewing system on a `Map` of scores; timings of `Seq`, `Set` and `Map`
  operations on a million elements, saved in `results.txt`;
- **[07-solitaire-parser](07-solitaire-parser)**: a peg solitaire solver that
  returns every board it reaches as a `LazyList`, a parser assembled from
  stackable traits, a `Combiner` type class with `given` instances, and
  connect three.

## Run it

You need JDK 17 and [sbt](https://www.scala-sbt.org/).

```sh
git clone https://github.com/davidcohenDC/pps-labs.git
cd pps-labs
sbt test
```

One lab at a time, using the project names in `build.sbt`:

```sh
sbt solitaireParser/test
sbt "catchThePawn/runMain e1.Main"      # the knight game, opens a window
```

Scala 3.2.2 and sbt 1.9.9 are pinned; sbt downloads them the first time. The
CI runs the same `sbt test` on every push, and each release on the
[releases page](https://github.com/davidcohenDC/pps-labs/releases/latest)
carries a zip of the sources.

## How it is organised

```
01-tdd-java/            basic-example/ and tdd/, each with src/ and test/
02-catch-the-pawn/      src/e1 (knight), src/e2 (minesweeper), test/
03-scala-functions/     src/u02, test/u02
04-lists-and-streams/   src/main/scala/u02, u03 and the tests
05-polyglot-warehouse/  src/main/java and src/main/scala/u04lab, tests
06-collections/         src/main/scala/u05lab/ex1..ex3, tests
07-solitaire-parser/    src/main/scala/u06lab/code, tests
build.sbt, project/     one multi-project build, JUnit 5 and JUnit 4 interfaces
```

## License

[MIT](LICENSE) © 2023 David Cohen
