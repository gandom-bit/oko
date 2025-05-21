package io.github.some_example_name.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.some_example_name.Controllers.GameController;
import io.github.some_example_name.Main;

public class GameView implements Screen , InputProcessor {
    private Stage stage;
    private GameController controller;

    public GameView(GameController controller, Skin skin) {
        this.controller = controller;
        Gdx.input.setInputProcessor(this);
    }

//با فشردن هرکلیدی ران میشه
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    //با دیگه فشار نداد کلید ران میشه
    @Override
    public boolean keyUp(int i) {
        return false;
    }

    //یه چیزی تایپ کنیم ران میشه
    @Override
    public boolean keyTyped(char character) {
        return false;
    }


    //برای تیر زدن  درواقع برای موس
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        controller.getWeaponController().handleWeaponShoot(screenX, screenY)
        return false;
    }

    //برای موس
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved((int screenX, int screenY) { //حرکت دادن کرسر
        controller.getWeaponController().handleWeaponRotation((int screenX, int screenY);
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) { //چرخوندن تفنگ تو بازی
        return false;
    }




    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0,0,0,1);
        Main.getBatch().begin();
        controller.updateGame();
        Main.getBatch().end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
