package interviews.das.tesco;

public class Task {
    private Shift assignedShift;
    private Department assignedDepartment;

    public Task() {
    }

    public Task( Shift assignedShift, Department assignedDepartment) {
        this.assignedShift = assignedShift;
        this.assignedDepartment = assignedDepartment;
    }

    public Shift getAssignedShift() {
        return assignedShift;
    }

    public void setAssignedShift(Shift assignedShift) {
        this.assignedShift = assignedShift;
    }

    public Department getAssignedDepartment() {
        return assignedDepartment;
    }

    public void setAssignedDepartment(Department assignedDepartment) {
        this.assignedDepartment = assignedDepartment;
    }
}
