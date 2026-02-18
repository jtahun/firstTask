package behavioral.visitor;

class JuniorArchitect implements Architect {
    @Override
    public void design(Foundation f) {
        System.out.println("Фундамент: простой ленточный (проект Junior)");
    }

    @Override
    public void design(Walls w) {
        System.out.println("Стены: кирпичные, стандартные (проект Junior)");
    }

    @Override
    public void design(Roof r) {
        System.out.println("Крыша: двускатная, шифер (проект Junior)");
    }
}
