package e2.model.box;

public class Mine extends AbstractBox{

    @Override
    void triggerBehaviour() {
        this.flag = false;
    }
}
