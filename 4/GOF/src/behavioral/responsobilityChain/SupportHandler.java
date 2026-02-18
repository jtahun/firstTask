package behavioral.responsobilityChain;

abstract class SupportHandler {
    private final int level;
    private SupportHandler nextHandler;

    public SupportHandler(int level) {
        this.level = level;
    }

    public void setNextHandler(SupportHandler handler) {
        this.nextHandler = handler;
    }

    public void handleRequest(String issue, int issueLevel) {
        if (issueLevel >= level) {
            resolve(issue);
        }
        if (nextHandler != null) {
            nextHandler.handleRequest(issue, issueLevel);
        }
    }

    public abstract void resolve(String issue);
}