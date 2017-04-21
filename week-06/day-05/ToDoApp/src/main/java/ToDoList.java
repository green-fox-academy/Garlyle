import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToDoList {
  public static int TODO_ID = 0;

  private HashMap<Integer, ToDo> listOfTasks;

  public ToDoList()
  {
    listOfTasks = new HashMap<>();
    loadTasks();
  }

  public void printTasks() {
    if (listOfTasks.size() == 0)
    {
      System.out.println("No todos for today! :)");
    } else {
      for (Map.Entry<Integer, ToDo> entry : listOfTasks.entrySet()) {
        System.out.println(entry.getKey() + " - " + entry.getValue());
      }
    }
  }

  public void loadTasks() {
    try {
      CSVReader reader = new CSVReader(new FileReader("tasks.csv"), ';');
      List<String[]> lines = reader.readAll();
      for (String[] line : lines) {
        int id = Integer.parseInt(line[0]);
        if (id > TODO_ID) {
          TODO_ID = id;
        }
        String description = line[1];
        LocalDateTime createdAt = LocalDateTime.parse(line[2]);
        LocalDateTime completedAt;
        if (!line[3].equals("null")) {
          completedAt = LocalDateTime.parse(line[3]);
        } else {
          completedAt = null;
        }
        listOfTasks.put(id, new ToDo(description, createdAt, completedAt));
      }
    } catch (Exception ex) {
      if (ex instanceof FileNotFoundException) {
        System.out.println("tasks.csv not found");
      } else {
        ex.printStackTrace();
      }
    }
  }

  public void saveTasks() {
    try {
      CSVWriter writer = new CSVWriter(new FileWriter("tasks.csv"), ';', CSVWriter.NO_QUOTE_CHARACTER);
      for (Map.Entry<Integer, ToDo> entry : listOfTasks.entrySet()) {
        String[] line = new String[4];
        line[0] = entry.getKey().toString();
        line[1] = entry.getValue().getTask();
        line[2] = entry.getValue().createdAt.toString();
        if (entry.getValue().completedAt == null) {
          line[3] = "null";
        } else {
          line[3] = entry.getValue().completedAt.toString();
        }

        writer.writeNext(line);
      }
      writer.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void addTask(String task) {
    TODO_ID++;
    listOfTasks.put(TODO_ID, new ToDo(task));
  }

  public void removeTask(int index) {
    listOfTasks.remove(index);
  }

  public void checkTask(int index) {
    listOfTasks.get(index).check();
  }

  public void updateTask(int index, String newDescription) {
    listOfTasks.get(index).setTask(newDescription);
  }
}
