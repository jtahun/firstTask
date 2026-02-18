package behavioral.visitor;

class Walls implements BuildingElement {
    @Override
    public void beDesigned(Architect architect) {
        architect.design(this);
    }
}