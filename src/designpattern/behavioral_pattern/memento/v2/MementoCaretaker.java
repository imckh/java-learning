package designpattern.behavioral_pattern.memento.v2;

import designpattern.behavioral_pattern.memento.v1.ChessmanMemento;

import java.util.ArrayList;
import java.util.List;

public class MementoCaretaker {
    //定义一个集合来存储多个备忘录
    private List<ChessmanMemento> mementolist = new ArrayList<>();

    public ChessmanMemento getMemento(int i) {
        return (ChessmanMemento) mementolist.get(i);
    }

    public void setMemento(ChessmanMemento memento) {
        mementolist.add(memento);
    }
}
