package behavioral.state;

public class Main {
    public static void main(String[] args) {
        Day currentDay = new Monday();
        WeekSchedule schedule = new WeekSchedule();
        schedule.setDay(currentDay);

        for (int i = 0; i < 7; i++) {
            schedule.whatToDo();
            schedule.nextDay();
        }
    }
}
