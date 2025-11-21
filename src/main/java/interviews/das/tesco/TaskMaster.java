package interviews.das.tesco;

import java.util.*;
import java.util.stream.Collectors;

public class TaskMaster implements AssignTask,ColleagueShiftPlanService {

    Map<Colleague, List<Task>> colleagueTasks= new HashMap<>();

    @Override
    public Map<Colleague, List<Task>> assingTask(Colleague colleague, Task task) {
       if(colleagueTasks.containsKey(colleague)){
           List<Task> assignedTasks=new ArrayList<>();
                   assignedTasks.addAll(colleagueTasks.get(colleague));
                   assignedTasks.add(task);
           colleagueTasks.put(colleague,assignedTasks);
       }else {
           colleagueTasks.put(colleague,Arrays.asList(task));
       }
       return  colleagueTasks;
    }

    public Map<Colleague, List<Task>> getColleagueTasks() {
        return colleagueTasks;
    }

    public void setColleagueTasks(Map<Colleague, List<Task>> colleagueTasks) {
        this.colleagueTasks = colleagueTasks;
    }

    public List<Task> getColleagueTasks(Colleague givenColleague) {
       return  colleagueTasks.get(givenColleague);
    }


    @Override
    public List<Shift> getCollegueShiftPlans(Colleague colleague) {
        if(colleagueTasks.isEmpty()){
            return  null;//throw Error
        }
        if(colleagueTasks.containsKey(colleague)){
            List<Task> tasks= colleagueTasks.get(colleague);
            List<Shift> shifts= tasks.stream().map(task-> task.getAssignedShift()).collect(Collectors.toList());
            List<Shift> mergedShift= getMergedShiftplans(shifts);
            return mergedShift;
        }else{
            return null; //Error colleague not found
        }

    }

    private List<Shift> getMergedShiftplans(List<Shift> shifts) {

        Collections.sort(shifts,Comparator.comparing(Shift::getStartDate));
        List<Shift> mergedShifts= new ArrayList<>();
        int i=0;
        int j=1;
        while(j<shifts.size()){
            if(shifts.get(i).getEndDate()== shifts.get(j).getStartDate()){
               Shift temp=shifts.get(i);
                mergedShifts.add(i,new Shift(temp.getStartDate(), shifts.get(j).getEndDate()));
            }else{
                mergedShifts.add(i,new Shift(shifts.get(j).getStartDate(), shifts.get(j).getEndDate()));
                i++;
            }
            j++;
        }

        return mergedShifts;
    }
}


