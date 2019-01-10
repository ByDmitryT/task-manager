package iteco.study.command.data;

import iteco.study.command.AbstractCommand;
import iteco.study.entity.Project;
import iteco.study.entity.Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class DataLoadCommand extends AbstractCommand {

    private final static String FILE_NAME = "data.bin";

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[LOAD DATA]");
        final File file = new File(FILE_NAME);
        final FileInputStream fileInputStream = new FileInputStream(file);
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        final List projects = (List) objectInputStream.readObject();
        for (final Object project : projects) {
            if (project instanceof Project) {
                bootstrap.getProjectService().addProject((Project) project);
            }
        }
        final List tasks = (List) objectInputStream.readObject();
        for (final Object task : tasks) {
            if (task instanceof Task) {
                bootstrap.getTaskService().addTask((Task) task);
            }
        }
        objectInputStream.close();
        fileInputStream.close();
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "load-data";
    }

    @Override
    public String description() {
        return "load data from file";
    }
}
