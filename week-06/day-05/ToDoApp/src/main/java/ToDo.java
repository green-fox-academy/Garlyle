import java.time.LocalDateTime;

public class ToDo {
  private String taskDescription;
  LocalDateTime createdAt;
  LocalDateTime completedAt;

  final static String DONE = "[x] ";
  final static String UNDONE = "[ ] ";

  public ToDo(String description) {
    taskDescription = description;
    createdAt = LocalDateTime.now();
  }

  public ToDo(String description, LocalDateTime createdAt, LocalDateTime completedAt) {
    taskDescription = description;
    this.createdAt = createdAt;
    this.completedAt = completedAt;
  }

  @Override
  public String toString() {
    String s;
    if (completedAt == null) {
      s = DONE;
    } else {
      s = UNDONE;
    }
    s += taskDescription;

    return s;
  }

  public void setTask(String description) {
    this.taskDescription = description;
  }

  public String getTask() {
    return taskDescription;
  }

  public void check() {
    completedAt = LocalDateTime.now();
  }

  public LocalDateTime complitionTime() {
    if (completedAt == null) {
      return null;
    } else {
      int year = completedAt.getYear() - createdAt.getYear();
      int month = completedAt.getMonthValue() - createdAt.getMonthValue();
      int day = completedAt.getDayOfMonth() - createdAt.getDayOfMonth();
      int hour = completedAt.getHour() - createdAt.getHour();
      int minute = completedAt.getMinute() - createdAt.getMinute();
      return LocalDateTime.of(year, month, day, hour, minute);
    }
    }
}
