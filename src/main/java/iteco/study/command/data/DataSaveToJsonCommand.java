package iteco.study.command.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import iteco.study.command.AbstractCommand;
import iteco.study.entity.Data;

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
        data.setProjects(bootstrap.getProjectService().getProjects());
        data.setTasks(bootstrap.getTaskService().getTasks());
        objectMapper.writeValue(fileOutputStream, data);
        fileOutputStream.close();
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "save-data-to-json";
    }

    @Override
    public String description() {
        return "save data to json file";
    }
}
