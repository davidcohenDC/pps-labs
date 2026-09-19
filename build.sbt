// One build for the seven labs. Every folder keeps the layout it had in class:
// plain src/ and test/ for the first three, the sbt layout for the others.
import com.github.sbt.junit.jupiter.sbt.Import.JupiterKeys

ThisBuild / scalaVersion := "3.2.2"
ThisBuild / javacOptions ++= Seq("--release", "17")
ThisBuild / scalacOptions ++= Seq("-deprecation", "-feature")

val junit4 = "com.github.sbt" % "junit-interface" % "0.13.3" % Test
val junit5 = Seq(
  libraryDependencies += "com.github.sbt.junit" % "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test,
  testOptions += Tests.Argument(jupiterTestFramework, "-v")
)

// Java-only labs written as IntelliJ projects: sources in src/, tests in test/.
def javaLab(dir: String, sources: Seq[String], tests: Seq[String]) =
  Project(dir.drop(3).replace('-', '_'), file(dir))
    .settings(junit5)
    .settings(
      autoScalaLibrary := false,
      crossPaths := false,
      Compile / unmanagedSourceDirectories := sources.map(s => baseDirectory.value / s),
      Test / unmanagedSourceDirectories := tests.map(t => baseDirectory.value / t)
    )

lazy val tddJava = javaLab("01-tdd-java",
  Seq("basic-example/src", "tdd/src"), Seq("basic-example/test", "tdd/test"))

lazy val catchThePawn = javaLab("02-catch-the-pawn", Seq("src"), Seq("test"))

lazy val scalaFunctions = (project in file("03-scala-functions"))
  .settings(junit5)
  .settings(
    Compile / unmanagedSourceDirectories := Seq(baseDirectory.value / "src"),
    Test / unmanagedSourceDirectories := Seq(baseDirectory.value / "test")
  )

lazy val listsAndStreams = (project in file("04-lists-and-streams")).settings(libraryDependencies += junit4)
lazy val polyglotWarehouse = (project in file("05-polyglot-warehouse")).settings(libraryDependencies += junit4)
lazy val collections = (project in file("06-collections")).settings(libraryDependencies += junit4)
lazy val solitaireParser = (project in file("07-solitaire-parser")).settings(libraryDependencies += junit4)

lazy val root = (project in file("."))
  .aggregate(tddJava, catchThePawn, scalaFunctions, listsAndStreams, polyglotWarehouse, collections, solitaireParser)
  .settings(name := "pps-labs", publish / skip := true)
