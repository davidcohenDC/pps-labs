package a01a

import org.junit.Test
import u04lab.polyglot.a01a.{Logics, LogicsImpl}
import org.junit.Assert.*

class LogicsTest:

  // The boat is placed at random, so a single shot can only be a hit or a miss.
  @Test def testHit(): Unit =
    val logics = LogicsImpl(5, 3)
    val result = logics.hit(0, 0)
    assertTrue(result == Logics.Result.HIT || result == Logics.Result.MISS)
