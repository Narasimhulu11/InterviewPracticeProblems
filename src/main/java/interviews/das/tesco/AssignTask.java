package interviews.das.tesco;

import java.util.List;
import java.util.Map;

public interface AssignTask {
   Map<Colleague, List<Task>> assingTask(Colleague colleague,Task task);
}
