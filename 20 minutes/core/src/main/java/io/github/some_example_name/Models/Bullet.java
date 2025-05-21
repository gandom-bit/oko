package io.github.some_example_name.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bullet {  // مستطیل فرضی تعریف کنیم واسه انمیس ها هم همینطور
    private Texture bulletTexture = new Texture(GameAssetManager.GetGameAssetManager().getBullet());
    private Sprite bulletSprite = new Sprite(bulletTexture);
    private int damage = 5;
    private int x;
    private int y;


    public Bullet(int y, int x) {
        bulletSprite.setSize(20 , 20);
        this.y = y;
        this.x = x;

        bulletSprite.setX((float) Gdx.graphics.getWidth()/2);
        bulletSprite.setY((float) Gdx.graphics.getHeight()/2);
    }

    public Texture getBulletTexture() {
        return bulletTexture;
    }

    public Sprite getBulletSprite() {
        return bulletSprite;
    }

    public int getDamage() {
        return damage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
