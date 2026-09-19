package e2.model.box;

import e2.Pair;

import java.util.Optional;

public abstract class AbstractBox implements Box{

    protected Pair<Integer,Integer> position;
    protected boolean flag = false;
    protected Integer value;
    protected boolean trigger = false;

    public AbstractBox() {
    }

    @Override
    public boolean getFlag() {
        return this.flag;
    }

    @Override
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public Optional<Integer> getValue() {
        return Optional.ofNullable(this.value);
    }

    @Override
    public boolean getTrigger() {
        return this.trigger;
    }

    @Override
    public void setTrigger(boolean trigger) {
        this.trigger = trigger;
        this.triggerBehaviour();
    }

    abstract void triggerBehaviour();
}
