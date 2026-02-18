package behavioral.visitor;

interface Architect {
    void design(Foundation foundation);
    void design(Walls walls);
    void design(Roof roof);
}
