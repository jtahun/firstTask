package net.proselyte.gofpatterns.behavioral.interpreter;

public class TerminalExpression implements Expression{
    private final String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpreter(String context) {
        return context.contains(data);
    }
}
