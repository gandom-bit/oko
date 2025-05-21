package io.github.some_example_name.Views;

//import static com.badlogic.gdx.graphics.g3d.particles.ParticleShader.AlignMode.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.some_example_name.Controllers.MainMenuController;
import io.github.some_example_name.Main;

public class MainMenuView implements Screen {
    //هر اسکینی باید یه استیج داشته باشد، هر استیج شمال چند اکتره مثل فیلدها
    private Stage stage;
    private final TextButton playButton; //یه دکمه ای که تکست روشه
    private final Label gameTitle; //متن روش مینویسیم
    private final TextField field; //یه فیلد که روش تکست مینویسیم
    public Table table; //برای بی نیازی از ارتفاع و عرض گذاشتن منوها

    private final MainMenuController controller;

    public MainMenuView(MainMenuController controller, Skin skin) {   // مشابهش باید تو همه ی منوها با همین ورودی ها باشه
        this.controller = controller; //همه ی اکتورهای libgdx این اسکین رو باید بگیرن
        this.playButton = new TextButton("Play", skin);
        this.gameTitle = new Label("this is a title", skin);
        this.field = new TextField("this is a field", skin);
        this.table = new Table();

        controller.setView(this);  //داخل کلاس کنترلر باید یه اینستنس از ویویی که قراره ازش استفاده کنیم بدیم تا به المان های اون ویوعه دسترسی داشته باشیم

    }

    @Override
    public void show() { //اولین چیزی که وقتی اسکرین میاد انجام میشه
        //تعریف table  و اینکه چی نشون بده
        //دو خط اول بای تو همه ی منوها باشه
        stage = new Stage(new ScreenViewport()); //با باز کردن هریک از ویو ها یه استیج جدید میسازه
        Gdx.input.setInputProcessor(stage); //تشخیص کلیک برای کار کردن دکمه ها


        table.setFillParent(true); //
        table.center();  //table رو میزاره وسط صفحه
        table.add(gameTitle); //لیبل رو اد میکنه
        table.row().pad(10, 0, 10, 0); //pad تعداد پیکسل فاصله رو میگیره
        table.add(field).width(600);
        table.row().pad(10, 0, 10, 0);
        table.add(playButton);

        stage.addActor(table); //اد کردن اکتور table  به استیج
        // میتونیم بدون اینکه اد کنیم به table  و بعدش به استیج، از همون ابتدا تو استیج بسازیمش

//        stage.addActor(playButton);
//        playButton.setPosition(); پوزیشن استاتیک تعریف میکنیم




    }

    @Override
    public void render(float v) { // هر فریم یه بار انجام میشه
        ScreenUtils.clear(0, 0, 0, 1); //بکگراند با رنگ انتخابی میزاره
        Main.getBatch().begin();
        Main.getBatch().end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));  //????
        stage.draw(); //رندر کردن اسکرین
        controller.handleMainMenuButtons();
    }

    @Override
    public void resize(int i, int i1) { //موقعی که ریسایز میکنیم
    }

    @Override
    public void pause() { // موقعی که استپ میکنیم

    }

    @Override
    public void resume() { //بعد استپ ادامه میزنیم

    }

    @Override
    public void hide() { //موقعی که  مینیمایز میکنیم

    }

    @Override
    public void dispose() { //موقعی که صفحه رو میبندیم

    }

    public TextButton getPlayButton() {
        return playButton;
    }

    public TextField getField() {
        return field;
    }
}
