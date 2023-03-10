package e1.view;

import e1.controller.engine.EngineFactoryImpl;
import e1.controller.logics.CatchThePawnLogics;
import e1.controller.logics.Logics;
import e1.model.components.board.Board;
import e1.model.components.board.BoardImpl;
import e1.model.components.pawn.Pawn;
import e1.model.elements.position.CartesianPosition;
import e1.model.elements.position.CartesianPositionImpl;
import e1.model.utils.PAWN_TYPE;
import javax.swing.*;
import javax.swing.border.Border;
import java.io.Serial;
import java.util.*;
import java.util.Map.Entry;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    
    @Serial
    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton, CartesianPosition<Integer>> buttons = new HashMap<>();
    private final Logics logics;

    private final Board board;

    private final static int SIZE = 5;

    private Optional<Pawn> selectedPawn = Optional.empty();
    
    public GUI() {

        this.board = new BoardImpl(new EngineFactoryImpl().catchThePawn().generate());
        this.logics = new CatchThePawnLogics(PAWN_TYPE.PAWN, PAWN_TYPE.KNIGHT);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*SIZE, 100*SIZE);
        
        JPanel panel = new JPanel(new GridLayout(SIZE,SIZE));
        this.getContentPane().add(BorderLayout.CENTER,panel);
        
        ActionListener al = (e)->{
            final JButton bt = (JButton)e.getSource();
            final CartesianPosition<Integer> pos = buttons.get(bt);
            if(selectedPawn.isEmpty()) {
                Optional<Pawn> catchedPawn =  this.board.getPawnByPosition(pos);
                if(catchedPawn.isPresent()) {
                    this.selectedPawn = catchedPawn;
                }
                this.draw();
            } else {
                Optional<Pawn> eatedPawn =  this.board.movePawn(selectedPawn.get(),pos);
                if(eatedPawn.isPresent()) {
                    if (this.logics.hit(eatedPawn.get())) {
                        System.exit(0);
                    } else {
                        this.draw();
                    }
                }
                this.selectedPawn = Optional.empty();
            }
        };
                
        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                final JButton jb = new JButton(" ");
                jb.addActionListener(al);
                this.buttons.put(jb,new CartesianPositionImpl(i,j));
                panel.add(jb);
            }
        }
        this.draw();
        this.setVisible(true);
    }
    
    private void draw() {
    	for (Entry<JButton,CartesianPosition<Integer>> entry: this.buttons.entrySet()) {
            Optional<Pawn> pawn = this.board.getPawnByPosition(entry.getValue());
            if(pawn.isPresent()) {
                String str = pawn.get().getType() == PAWN_TYPE.PAWN ? "*" :
                        pawn.get().getType() == PAWN_TYPE.KNIGHT ? "K" : " ";
                entry.getKey().setText(str);
            } else {
                entry.getKey().setText(" ");
            }
    	}
    }
}
