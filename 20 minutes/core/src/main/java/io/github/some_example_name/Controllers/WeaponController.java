package io.github.some_example_name.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import io.github.some_example_name.Main;
import io.github.some_example_name.Models.Bullet;
import io.github.some_example_name.Models.Weapon;

import java.util.ArrayList;
import java.util.Vector;

public class WeaponController {
    private Weapon weapon;
    private ArrayList<Bullet> bullets = new ArrayList<>();  //اینو بهتره پاک کنیم و به جاش کنترلرشو بسازیم بعد اینجا انستنسشو پاس بدیم فقط

    public WeaponController (Weapon weapon){
        this.weapon = weapon;
    }

    public void update(){
        weapon.getSmgSprite().draw(Main.getBatch());
        updateBullets();
    }

    public void handleWeaponRotation(int x, int y){
        Sprite weaponSprite = weapon.getSmgSprite();
        float weaponCenterX = (float) Gdx.graphics.getWidth()/2;
        float weaponCenterY = (float) Gdx.graphics.getHeight()/2;

        float angle = (float) Math.atan2(y - weaponCenterY, x - weaponCenterX);

        weaponSprite.setRotation((float) (3.14 - angle * MathUtils.radiansToDegrees));
    }

    public void handleWeaponShoot(int x, int y){  //هندل کردن صفر شدن تیر
        bullets.add(new Bullet(x, y));
        weapon.setAmmo(weapon.getAmmo() - 1);
    }

    public void updateBullets(){
        for(Bullet b : bullets){
            b.getSprite().draw(Main.getBatch());
            Vector2 direction = new Vector2(  //شوت کردن گلوله
                Gdx.graphics.getWidth()/2f - b.getX(),
                   Gdx.graphics.getHeight()/2f - b.getY()
            ).nor();

            b.getSprite().setX(b.getSprite().getX() - direction.x * 5); //5 سرعتشه
            b.getSprite().setY(b.getSprite().getY() - direction.y * 5);

        }
    }


    //handleReaload...

}
