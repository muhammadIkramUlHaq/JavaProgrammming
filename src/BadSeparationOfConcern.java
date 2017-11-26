/**
 * Created with IntelliJ IDEA.
 * User: Ikram
 */
import org.springframework.data.repository.CrudRepository;
public class BadSeparationOfConcern extends CrudRepository<BadSeparationOfConcern, Long>{
        private Long id;
        private String task;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTask() {
            return task;
        }

        public void setTask(String task) {
            this.task = task;
        }

        public String createNewTask (String task) {
            setTask(task);
            this.save(toDoElement);
            return "Saved";
        }


        public String updateTask (Long taskId, String task) {
            String responseString = "";
            if (this.exists(taskId)) {
                BadSeparationOfConcern toDoElement = this.findOne(taskId);
                toDoElement.setTask(task);
                this.save(toDoElement);
                responseString = "Updated!";
            }
            else {
                responseString = "No Task with Given ID exist!";
            }
        return responseString;
        }

    public BadSeparationOfConcern getTask(Long taskId) {
        BadSeparationOfConcern toDoInstance = null;
        if (this.exists(taskId)){
            toDoInstance = this.findOne(taskId);
        }
        return toDoInstance;
    }

    public String deleteTask(Long taskId) {
        String responseString = "";
        if  (this.exists(taskId)){
            this.delete(taskId);
            responseString = "Deleted!";
        }
        else if (taskId == null) {
            responseString = deleteAllTask();
        }
        else {
            responseString = "Task with Given Id not Found!";
        }
        return responseString;
    }

    public Iterable<BadSeparationOfConcern> getAllTasks() {
        Iterable<BadSeparationOfConcern> iterateInstance = null;
        if  (this.count() > 0) {
            iterateInstance = this.findAll();
        }
        return  iterateInstance;
    }

    /**
     * This Method will delete all tasks for TODOList
     * @return
     */
    public String deleteAllTask() {
        String responseString ="";
        if (this.count() > 0){
            this.deleteAll();
            responseString = "Deleted All Tasks!";
        }
        else {
            responseString =  "No Task to be Deleted!";
        }
        return responseString;
    }

    public static void main(String[] args) {
        BadSeparationOfConcern badSeparationOfConcern = new BadSeparationOfConcern();
    }
}


