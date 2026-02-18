package behavioral.responsobilityChain;

class ExpertSupport extends SupportHandler {
    public ExpertSupport(int level) {
        super(level);
    }

    @Override
    public void resolve(String issue) {
        System.out.println("Expert Support: " + issue + " - срочное вмешательство! (экспертный уровень)");
    }
}
