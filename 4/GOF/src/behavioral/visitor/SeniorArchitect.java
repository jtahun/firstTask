package behavioral.visitor;

class SeniorArchitect implements Architect {
    @Override
    public void design(Foundation f) {
        System.out.println("Фундамент: монолитная плита с усилением (проект Senior)");
    }

    @Override
    public void design(Walls w) {
        System.out.println("Стены: газобетон с утеплением (проект Senior)");
    }

    @Override
    public void design(Roof r) {
        System.out.println("Крыша: мансардная, металлочерепица (проект Senior)");
    }
}
