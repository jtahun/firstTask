package behavioral.responsobilityChain;

class AdvancedSupport extends SupportHandler {
    public AdvancedSupport(int level) {
        super(level);
    }

    @Override
    public void resolve(String issue) {
        System.out.println("Advanced Support: " + issue + " - требуется диагностика (продвинутый уровень)");
    }
}
