package io.github.some_example_name.Controllers;

import io.github.some_example_name.Models.PreGame;
import io.github.some_example_name.Views.PreGameMenuView;

public class PreGameMenuController {
    private PreGameMenuView view;
    private PreGame preGame;
    public void setView(PreGameMenuView view) {
        this.view = view;
        this.preGame = preGame;
    }

    public void handlePreGameMenuButtons() {
        if (view != null) {

        }
        //for save
    }
}
