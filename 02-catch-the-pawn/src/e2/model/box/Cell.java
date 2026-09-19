package e2.model.box;


public class Cell extends AbstractBox{

    public Cell(int counter) {
        this.value = counter;
    }

    @Override
    void triggerBehaviour() {
        this.flag = false;
    }
}
