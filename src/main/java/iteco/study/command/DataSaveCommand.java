package iteco.study.command;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataSaveCommand extends AbstractCommand {

    private final static String FILE_NAME = "data.bin";

    @Override
    public void execute() throws IOException {
        final File file = new File(FILE_NAME);
        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(bootstrap.getProjectService().getProjects());
        objectOutputStream.writeObject(bootstrap.getTaskService().getTasks());
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("OK");
    }

    @Override
    public String command() {
        return "save_data";
    }

    @Override
    public String description() {
        return "save data to file";
    }
}
