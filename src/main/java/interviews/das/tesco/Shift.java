package interviews.das.tesco;

public class Shift {

    private int startDate;
    private int endDate;

    public Shift(int startDate, int endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Shift() {
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }
}
