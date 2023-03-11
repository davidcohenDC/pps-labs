package e2.model.box;

import e2.Pair;

import java.util.Optional;

public interface Box {

    boolean getFlag();

    void setFlag(boolean flag);

    Optional<Integer> getValue();

    boolean getTrigger();

    void setTrigger(boolean trigger);

}
