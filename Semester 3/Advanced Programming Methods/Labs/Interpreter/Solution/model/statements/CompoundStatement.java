package model.statements;

import model.ProgramState;
import model.adt.IStack;

public class CompoundStatement implements Statement {
    private final Statement first;
    private final Statement second;

    public CompoundStatement(Statement _first, Statement _second) {
        first = _first;
        second = _second;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IStack<Statement> stack =  state.getExeStack();
        stack.push(second);
        stack.push(first);
        return state;
    }

    @Override
    public String toString() {
        return String.format("%s;\n%s", first, second);
    }
}
