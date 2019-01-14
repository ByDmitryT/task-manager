package ru.titov.taskmanager.command.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.entity.Data;

import java.io.File;
import java.io.FileOutputStream;

public class DataSaveToJsonCommand extends AbstractCommand {

    private final static String FILE_NAME = "data.json";

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[SAVE DATA TO JSON]");
        final File file = new File(FILE_NAME);
        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final ObjectMapper objectMapper = new ObjectMapper();
        final Data data = new Data();
        data.setProjects(bootstrap.getProjectService().getAll());
        data.setTasks(bootstrap.getTaskService().getAll());
        data.setUsers(bootstrap.getUserService().getAll());
        objectMapper.writeValue(fileOutputStream, data);
        fileOutputStream.close();
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "data-save-to-json";
    }

    @Override
    public String description() {
        return "save data to json file";
    }
}
