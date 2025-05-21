package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.some_example_name.Controllers.MainMenuController;
import io.github.some_example_name.Models.GameAssetManager;
import io.github.some_example_name.Views.MainMenuView;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game { //قابلیت های مختلف برای ست و گت کردن
    private static Main main;
    private static SpriteBatch batch; //توش اسپرایت ها نگه داری میشه


  //  private Texture image;
   // private int x= 0;
    @Override
    public void create() {//اولین بار که صفحه ران میشه این اجرا میشه
        main = this;
        batch = new SpriteBatch();
      //  image = new Texture("libgdx.png"); // عکس هایی که تو assets میخواییم بزاریم رو بازی
        main.setScreen(new MainMenuView(new MainMenuController(), GameAssetManager.getSkin()));
    }

    @Override
    public void render() { //هر فریم یه دور یه چیزیو اجرا میکنه
        super.render();

//        if(Gdx.input.isKeyPressed(Input.Keys.W)){
//           x += 3;
//        }
    }

    @Override
    public void dispose() { //برای رفتن به یه صفحه ی دیگه و اینکه چه کاری انجام بده اینجا تعریف میکنیم
        batch.dispose();
        //image.dispose();
    }

    public static Main getMain() {
        return main;
    }

    public static void setMain(Main main) {
        Main.main = main;
    }

    public static SpriteBatch getBatch() {
        return batch;
    }

    public static void setBatch(SpriteBatch batch) {
        Main.batch = batch;
    }
}
