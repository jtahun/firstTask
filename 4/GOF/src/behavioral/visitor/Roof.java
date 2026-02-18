package behavioral.visitor;

class Roof implements BuildingElement {
    @Override
    public void beDesigned(Architect architect) {
        architect.design(this);
    }
}