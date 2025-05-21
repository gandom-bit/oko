package io.github.some_example_name.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameAssetManager {
   private GameAssetManager gameAssetManager;
    private static Skin skin;
//    private Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json")); // ادرس فایل جیسونه رو میدیم

    public GameAssetManager getGameAssetManager() {
        if (gameAssetManager == null) {
            gameAssetManager = new GameAssetManager();
        }
        return gameAssetManager;
    }


    public static Skin getSkin() {
        if (skin == null) {
            skin = new Skin(Gdx.files.internal("skin/quantum-horizon-ui.json"));
        }
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }
}
