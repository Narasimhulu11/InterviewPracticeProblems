package interviews.das.tesco;

import java.util.Collection;
import java.util.List;

public class ShiftPlanAnalysis {
    public static void main(String[] args) {
        Colleague colleague = new Colleague(1,"mnsd");
        Shift shift1= new Shift(8,10);
        Shift shift2= new Shift(10,12);
        Shift shift3= new Shift(14,19);
        Department bakeryDepartment= new Department(1,"Bakery");
        Department groceriesDepartment= new Department(2,"Groceries");
        TaskMaster taskMaster= new TaskMaster();
        Task firsTask= new Task(shift1,bakeryDepartment);
        Task secondTask = new Task(shift2,groceriesDepartment);
        Task thirdTask = new Task(shift3,bakeryDepartment);

        taskMaster.assingTask(colleague,firsTask);
        taskMaster.assingTask(colleague,secondTask);
        taskMaster.assingTask(colleague,thirdTask);

        // getCollegueShiftPlan {{collegue}}

        List<Shift> shiftList= taskMaster.getCollegueShiftPlans(colleague);

        for(Shift merge: shiftList){
            System.out.println(merge.getStartDate()+" "+merge.getEndDate());
        }


    }
}
