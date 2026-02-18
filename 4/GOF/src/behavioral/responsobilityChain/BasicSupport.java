package behavioral.responsobilityChain;

class BasicSupport extends SupportHandler {
    public BasicSupport(int level) {
        super(level);
    }

    @Override
    public void resolve(String issue) {
        System.out.println("Basic Support: " + issue + " - проблема решена (базовый уровень)");
    }
}

