package iteco.study.command.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import iteco.study.command.AbstractCommand;
import iteco.study.entity.Data;
import iteco.study.entity.Project;
import iteco.study.entity.Task;

import java.io.*;

public class DataLoadFromXmlCommand extends AbstractCommand {

    private final static String FILE_NAME = "data.xml";

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[LOAD DATA FROM XML]");
        final File file = new File(FILE_NAME);
        final FileInputStream fileInputStream = new FileInputStream(file);
        final ObjectMapper objectMapper = new XmlMapper();
        final String json = inputStreamToString(fileInputStream);
        final Data data = objectMapper.readValue(json, Data.class);
        for (final Project project : data.getProjects()) {
            bootstrap.getProjectService().addProject(project);
        }
        for (final Task task : data.getTasks()) {
            bootstrap.getTaskService().addTask(task);
        }
        fileInputStream.close();
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "load-data-from-xml";
    }

    @Override
    public String description() {
        return "load data from xml file";
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
