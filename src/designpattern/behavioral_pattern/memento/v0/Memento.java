package designpattern.behavioral_pattern.memento.v0;

public class Memento {
    private String state;

    public Memento(Originator o) {
        state = o.getState();
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
