package io.github.some_example_name.Controllers;

import com.badlogic.gdx.graphics.Texture;
import io.github.some_example_name.Main;

public class WorldController {
    //سه تای اول رو میشد تو مدل World زد
    private PlayerController playerController;
    private Texture backgroundTexture;
    private float backgroundX = 0, backgroundY = 0;

    public WorldController(PlayerController playerController) {
        this.backgroundTexture = new Texture("background.png");
        this.playerController = playerController;
    }

    public void update() {
        backgroundX = playerController.getPlayer().getPosX();
        backgroundY = playerController.getPlayer().getPosY();
        Main.getBatch().draw(backgroundTexture, backgroundX, backgroundY);

    }
}
