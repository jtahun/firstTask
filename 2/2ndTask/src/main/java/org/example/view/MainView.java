package ru.igor.crud.view;

import ru.igor.crud.controller.LabelController;
import ru.igor.crud.controller.PostController;
import ru.igor.crud.controller.WriterController;
import ru.igor.crud.view.console.ConsoleInput;
import ru.igor.crud.view.console.ConsoleOutput;
import ru.igor.crud.view.console.MenuPrinter;

public class MainView {
    private final ConsoleInput in;
    private final ConsoleOutput out;
    private final MenuPrinter menu;

    private final WriterView writerView;
    private final PostView postView;
    private final LabelView labelView;

    public MainView(ConsoleInput in, ConsoleOutput out,
                    WriterController writerController,
                    PostController postController,
                    LabelController labelController) {
        this.in = in;
        this.out = out;
        this.menu = new MenuPrinter(out);

        this.writerView = new WriterView(in, out, menu, writerController);
        this.postView = new PostView(in, out, menu, postController);
        this.labelView = new LabelView(in, out, menu, labelController);
    }

    public void start() {
        while (true) {
            menu.printMain();
            int c = in.readInt("Выберите пункт: ");
            switch (c) {
                case 1 -> writerView.loop();
                case 2 -> postView.loop();
                case 3 -> labelView.loop();
                case 0 -> {
                    out.println("Выход.");
                    return;
                }
                default -> out.println("Неизвестная команда.");
            }
        }
    }
}
