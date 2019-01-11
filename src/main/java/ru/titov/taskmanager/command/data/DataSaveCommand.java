package ru.titov.taskmanager.command.data;

import ru.titov.taskmanager.command.AbstractCommand;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataSaveCommand extends AbstractCommand {

    private final static String FILE_NAME = "data.bin";

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws IOException {
        System.out.println("[SAVE DATA]");
        final File file = new File(FILE_NAME);
        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(bootstrap.getProjectService().getAll());
        objectOutputStream.writeObject(bootstrap.getTaskService().getAll());
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "data-save";
    }

    @Override
    public String description() {
        return "save data to file";
    }
}
