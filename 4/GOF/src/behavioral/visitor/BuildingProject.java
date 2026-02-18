package behavioral.visitor;

class BuildingProject implements BuildingElement {
    private final BuildingElement[] elements;

    public BuildingProject() {
        elements = new BuildingElement[] {
                new Foundation(), new Walls(), new Roof()
        };
    }

    @Override
    public void beDesigned(Architect architect) {
        for (BuildingElement element : elements) {
            element.beDesigned(architect);
        }
    }
}