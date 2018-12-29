package iteco.study.api.service;

import java.io.IOException;

public interface IProjectTaskService {

    void saveData() throws IOException;

    void loadData() throws IOException, ClassNotFoundException;
}
