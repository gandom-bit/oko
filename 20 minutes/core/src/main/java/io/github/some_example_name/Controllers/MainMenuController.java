package io.github.some_example_name.Controllers;

import io.github.some_example_name.Main;
import io.github.some_example_name.Models.GameAssetManager;
import io.github.some_example_name.Views.MainMenuView;
import io.github.some_example_name.Views.PreGameMenuView;

public class MainMenuController {
     private MainMenuView view;

    public void setView(MainMenuView view) {
        this.view = view;
    }

    public void handleMainMenuButtons() {
        if (view != null) { //اولی برای وقتی که رو اون دکمه خاص کلیک میکنیم
            if (view.getPlayButton().isChecked() && view.getField().getText().equals("Hannane")) { // دومی برای اینکه چک کنیم چیز که تو تکست فیلد نوشته میشه رشته موردنظر ما هست  یا نه(که در واقع این باید تو جیسون پیاده سازی بشه)
                Main.getMain().getScreen().dispose();  //اعمال روی اسکرینی که الان روشیم و کامل از بین بردن آبجکتش
               Main.getMain().setScreen(new PreGameMenuView(new PreGameMenuController(), GameAssetManager.getSkin())); // بعدش ست کردن اسکرین منوی جدید
            }
        }
    }
}
