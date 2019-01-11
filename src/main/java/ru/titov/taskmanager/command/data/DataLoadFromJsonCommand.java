package ru.titov.taskmanager.command.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.entity.Data;
import ru.titov.taskmanager.entity.Project;
import ru.titov.taskmanager.entity.Task;

import java.io.*;

public class DataLoadFromJsonCommand extends AbstractCommand {

    private final static String FILE_NAME = "data.json";

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[LOAD DATA FROM JSON]");
        final File file = new File(FILE_NAME);
        final FileInputStream fileInputStream = new FileInputStream(file);
        final ObjectMapper objectMapper = new ObjectMapper();
        final String json = inputStreamToString(fileInputStream);
        final Data data = objectMapper.readValue(json, Data.class);
        for (final Project project : data.getProjects()) {
            bootstrap.getProjectService().add(project);
        }
        for (final Task task : data.getTasks()) {
            bootstrap.getTaskService().add(task);
        }
        fileInputStream.close();
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "data-load-from-json";
    }

    @Override
    public String description() {
        return "load data from json file";
    }

    private String inputStreamToString(final InputStream is) throws IOException {
        final StringBuilder sb = new StringBuilder();
        String line;
        final BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

}
