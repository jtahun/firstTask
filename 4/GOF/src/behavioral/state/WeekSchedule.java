package behavioral.state;


class WeekSchedule {
    private Day currentDay;

    public void setDay(Day day) {
        this.currentDay = day;
    }

    public void nextDay() {
        if (currentDay instanceof Monday) {
            setDay(new Tuesday());
        } else if (currentDay instanceof Tuesday) {
            setDay(new Wednesday());
        } else if (currentDay instanceof Wednesday) {
            setDay(new Thursday());
        } else if (currentDay instanceof Thursday) {
            setDay(new Friday());
        } else if (currentDay instanceof Friday) {
            setDay(new Saturday());
        } else if (currentDay instanceof Saturday) {
            setDay(new Sunday());
        } else if (currentDay instanceof Sunday) {
            setDay(new Monday());
        }
    }

    public void whatToDo() {
        currentDay.whatToDo();
    }
}