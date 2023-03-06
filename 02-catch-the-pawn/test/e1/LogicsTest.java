package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
class LogicsTest {

    private static final int SIZE = 4;
    private Logics logics;
    private Pair<Integer,Integer> pawn;
    private Pair<Integer,Integer> knight;

    @BeforeEach
    void setUp() {
        this.logics = new LogicsImpl(SIZE);
        Optional<Pair<Integer,Integer>> optionalPawn = getPawn();
        Optional<Pair<Integer,Integer>> optionalKnight = getKnight();
        if(optionalPawn.isPresent() && optionalKnight.isPresent()) {
            this.knight = optionalKnight.get();
            this.pawn = optionalPawn.get();
        } else {
            fail();
        }
    }
    @Test
    void testHasKnight() {
        assertTrue(this.logics.hasKnight(this.knight.getX(), this.knight.getY()));
    }

    @Test
    void testHasPawn() {
        assertTrue(this.logics.hasPawn(this.pawn.getX(), this.pawn.getY()));
    }


    @Test
    void testHasKnightCorrectly() {
        List<Boolean> heatMap = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                heatMap.add(this.logics.hasKnight(i,j));
            }
        }
        long numberOfNights = heatMap.stream().filter(it -> it).count();
        assertEquals(1,numberOfNights);
    }

    @Test
    void testHasPawnCorrectly() {
        List<Boolean> heatMap = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                heatMap.add(this.logics.hasKnight(i,j));
            }
        }
        long numberOfNights = heatMap.stream().filter(it -> it).count();
        assertEquals(1,numberOfNights);
    }

    @Test
    void testHit() {
//        assertTrue(this.logics.hit(this.pawn.getX(),this.pawn.getY()));
//        assertFalse(this.logics.hit(this.knight.getX(),this.knight.getY()));
    }


    private Optional<Pair<Integer,Integer>> getKnight() {
        Optional<Pair<Integer,Integer>> knight = Optional.empty();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(this.logics.hasKnight(i,j)) {
                    knight = Optional.of(new Pair<>(i,j));
                }
            }
        }
        return knight;
    }

    private Optional<Pair<Integer,Integer>> getPawn() {
        Optional<Pair<Integer,Integer>> pawn = Optional.empty();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(this.logics.hasPawn(i,j)) {
                    pawn = Optional.of(new Pair<>(i,j));
                }
            }
        }
        return pawn;
    }
}