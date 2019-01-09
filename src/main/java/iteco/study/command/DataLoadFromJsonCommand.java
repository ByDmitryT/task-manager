package iteco.study.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import iteco.study.entity.Data;
import iteco.study.entity.Project;
import iteco.study.entity.Task;

import java.io.*;

public class DataLoadFromJsonCommand extends AbstractCommand {

    private final static String FILE_NAME = "data.json";

    @Override
    public void execute() throws Exception {
        final File file = new File(FILE_NAME);
        final FileInputStream fileInputStream = new FileInputStream(file);
        final ObjectMapper objectMapper = new ObjectMapper();
        final String json = inputStreamToString(fileInputStream);
        final Data data = objectMapper.readValue(json, Data.class);
        for (final Project project : data.getProjects()) {
            bootstrap.getProjectService().addProject(project);
        }
        for (final Task task : data.getTasks()) {
            bootstrap.getTaskService().addTask(task);
        }
        fileInputStream.close();
        System.out.println("OK");
    }

    @Override
    public String command() {
        return "load_data_from_json";
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
