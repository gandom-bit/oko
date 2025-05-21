package io.github.some_example_name.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Weapon {  //اسلحه های دیگه رو هم بیاریم
    private final Texture smgTexture = new Texture(GameAssetManager.getGameAssetManager().getSmg());
    private Sprite SmgSprite = new Sprite(smgTexture);
    private int ammo = 30;

    public Weapon() {
        smgSprite.setX((float) Gdx.graphics.getWidth() / 2);
        smgSprite.setY((float) Gdx.graphics.getHeight() / 2);
        smgSprite.setSize(50, 50);
    }

    public Sprite getSmgSprite() {
        return SmgSprite;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}
