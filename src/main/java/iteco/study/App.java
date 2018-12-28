package iteco.study;

import iteco.study.api.controller.IBootstrap;
import iteco.study.controller.Bootstrap;

public class App {
    public static void main(String[] args) {
        final IBootstrap bootstrap = new Bootstrap();
        bootstrap.start();
    }
}
