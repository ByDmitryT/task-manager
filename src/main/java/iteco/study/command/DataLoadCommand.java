package iteco.study.command;

import java.io.IOException;

public class DataLoadCommand extends AbstractCommand {
    @Override
    public void execute() throws IOException, ClassNotFoundException {
        bootstrap.getProjectTaskService().loadData();
        System.out.println("OK");
    }

    @Override
    public String command() {
        return "load_data";
    }

    @Override
    public String description() {
        return "load data from file";
    }
}
