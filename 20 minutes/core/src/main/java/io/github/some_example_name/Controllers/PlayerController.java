package io.github.some_example_name.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import io.github.some_example_name.Main;
import io.github.some_example_name.Models.GameAssetManager;
import io.github.some_example_name.Models.Player;

//import static jdk.internal.org.jline.terminal.spi.SystemStream.Input;
//import static jdk.internal.org.jline.terminal.spi.TerminalProvider.Stream.Input;

public class PlayerController {
    private Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    public void update() {
        player.getPlayerSprite().draw(Main.getBatch());

        if (player.isPlayerIdle()) {
            idleAnimation();
        }
        handlePlayerInput();

    }

    public void handlePlayerInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.setPosY(player.getPosY() - player.getSpeed());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.setPosX(player.getPosX() - player.getSpeed())
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.setPosY(player.getPosY() + player.getSpeed());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.setPosX(player.getPosX() - player.getSpeed());
            player.getPlayerSprite().flip(true, false);
        }
    }

    //ضافح کردن تابع های هندل دیگه

    public void idleAnimation () { //انیمیشن
        Animation<Texture> animation = GameAssetManager.getGameAssetManger().getCharacter1_idle_animation();

        player.getPlayerSprite().setRegion(animation.getKeyFrame(player.getTime()));


        if(animation.isAnimationFinished(player.getTime())) {
            player.setTime(player.getTime() + Gdx.graphics.getDeltaTime());
        }
        else {
            player.setTime(0);
        }
        animation.setPlayMode(Animation.PlayMode.LOOP);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
