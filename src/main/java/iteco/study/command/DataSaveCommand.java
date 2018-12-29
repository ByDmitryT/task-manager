package iteco.study.command;

import java.io.IOException;

public class DataSaveCommand extends AbstractCommand {
    @Override
    public void execute() throws IOException {
        bootstrap.getProjectTaskService().saveData();
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
