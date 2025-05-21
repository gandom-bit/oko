package io.github.some_example_name.Controllers;

import io.github.some_example_name.Models.Player;
import io.github.some_example_name.Models.Weapon;
import io.github.some_example_name.Views.GameView;

public class GameController {
    private GameView view;
    //از همه ی کنترلر ها یه اینستنس نگه میداریم تو این کلاس
    private PlayerController playerController;
    private WorldController worldController;
    private WeaponController weaponController;

    public void setView(GameView view) {
        this.view = view;
        playerController = new PlayerController(new Player());
        worldController = new WorldController(playerController);
        weaponController = new WeaponController(new Weapon());
    }

    public void updateGame(){ // کنترلر ها رو آپدیت میکنیم
        if (view != null) {
            worldController.update();
            playerController.update();
            weaponController.update();
        }
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public WeaponController getWeaponController() {
        return weaponController;
    }
}
