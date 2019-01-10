package iteco.study.api.controller;

import iteco.study.api.service.IProjectService;
import iteco.study.api.service.ITaskService;
import iteco.study.api.service.IUserService;
import iteco.study.command.AbstractCommand;

import java.util.Map;

public interface IBootstrap {

    void start();

    String nextLine();

    Integer nextInt();

    IProjectService getProjectService();

    ITaskService getTaskService();

    IUserService getUserService();

    Map<String, AbstractCommand> getCommandsMapping();

}
