//package e1.controller;
//
//import e1.controller.Logics;
//import e1.controller.LogicsImpl;
//import e1.model.elements.Pair;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.util.ArrayList;
//import java.util.List;a
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//class LogicsTest {
//
//    private static final int SIZE = 4;
//    private Logics logics;
//    private Pair<Integer,Integer> pawn;
//    private Pair<Integer,Integer> knight;
//
//    @BeforeEach
//    void setUp() {
//        this.logics = new LogicsImpl(SIZE);
//        Optional<Pair<Integer,Integer>> optionalPawn = getPawn();
//        Optional<Pair<Integer,Integer>> optionalKnight = getKnight();
//        if(optionalPawn.isPresent() && optionalKnight.isPresent()) {
//            this.knight = optionalKnight.get();
//            this.pawn = optionalPawn.get();
//        } else {
//            fail();
//        }
//    }
//    @Test
//    void testHasKnight() {
//        assertTrue(this.logics.hasKnight(this.knight.getX(), this.knight.getY()));
//    }
//
//    @Test
//    void testHasPawn() {
//        assertTrue(this.logics.hasPawn(this.pawn.getX(), this.pawn.getY()));
//    }
//
//
//    @Test
//    void testNoMultipleKnight() {
//        List<Boolean> heatMap = new ArrayList<>();
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                heatMap.add(this.logics.hasKnight(i,j));
//            }
//        }
//        long numberOfNights = heatMap.stream().filter(it -> it).count();
//        assertEquals(1,numberOfNights);
//    }
//
//    @Test
//    void testNoMultiplePawn() {
//        List<Boolean> heatMap = new ArrayList<>();
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                heatMap.add(this.logics.hasKnight(i,j));
//            }
//        }
//        long numberOfNights = heatMap.stream().filter(it -> it).count();
//        assertEquals(1,numberOfNights);
//    }
//
//    @Test
//    void testWrongHitDirection() {
//        int newX = Math.abs((SIZE-this.knight.getX()-1));
//        int newY = Math.abs((SIZE-this.knight.getX()-1));
//        this.logics.hit(newX,newY);
//        assertNotEquals(Optional.of(new Pair<>(newX,newY)),getKnight());
//    }
//
//
//    private Optional<Pair<Integer,Integer>> getKnight() {
//        Optional<Pair<Integer,Integer>> knight = Optional.empty();
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if(this.logics.hasKnight(i,j)) {
//                    knight = Optional.of(new Pair<>(i,j));
//                }
//            }
//        }
//        return knight;
//    }
//
//    private Optional<Pair<Integer,Integer>> getPawn() {
//        Optional<Pair<Integer,Integer>> pawn = Optional.empty();
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if(this.logics.hasPawn(i,j)) {
//                    pawn = Optional.of(new Pair<>(i,j));
//                }
//            }
//        }
//        return pawn;
//    }
//}