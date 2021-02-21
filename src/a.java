import java.awt.Image;
import oop.ex2.*;

/**
 * This ship pursues other ships and tries to fire at them.
 * It will always accelerate, and turn towards the nearest ship.
 * When its angle to the nearest ship is less then 0.21 radians, it will try to fire.
 */

public class a extends SpaceShip {
    /**
     * Does the actions of this runner ship for this round.
     * This is called once per round by the SpaceWars game driver.
     * @param game the game object to which this ship belongs.
     */
    public void doAction(SpaceWars game) {
        SpaceShip closest_ship = game.getClosestShipTo(this);
        double closest_ship_angle = closest_ship.getPhysics().angleTo(closest_ship.getPhysics());
        if (closest_ship_angle > 0) {
            getPhysics().move(true, 1);
        }
        if (closest_ship_angle < 0) {
            getPhysics().move(true, -1);
        }
        getPhysics().move(true,0);
        if (this.getPhysics().distanceFrom(closest_ship.getPhysics()) < 0.21){
            this.fire(game);
        }
        if (this.currEnergy < this.maxEnergy) {
            currEnergy += 1;
        }
        this.roundsCounter += 1;

    }

    /**
     * Gets the image of this aggressive ship. This method should return the image of the
     * ship with or without the shield. This will be displayed on the GUI at
     * the end of the round.
     *
     * @return the image of this ship.
     */
    public Image getImage() {
        if (this.shield){
            return GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;
        }
        return GameGUI.ENEMY_SPACESHIP_IMAGE;
    }
}
