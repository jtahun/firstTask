package behavioral.visitor;

class Foundation implements BuildingElement {
    @Override
    public void beDesigned(Architect architect) {
        architect.design(this);
    }
}
