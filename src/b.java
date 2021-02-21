import java.awt.Image;
import oop.ex2.*;

/**
 * This ship attempts to collide with other ships.
 * It will always accelerate, and will constantly turn towards the closest ship.
 * If it gets within a distance of 0.19 units (inclusive) from another ship, it will attempt to turn on its shield.
 */

public class b extends SpaceShip {
    /**
     * Does the actions of this runner ship for this round.
     * This is called once per round by the SpaceWars game driver.
     * @param game the game object to which this ship belongs.
     */
    public void doAction(SpaceWars game) {
        SpaceShip closest_ship = game.getClosestShipTo(this);
        double closest_ship_angle = closest_ship.shipPhysics.angleTo(closest_ship.getPhysics());
        if (closest_ship_angle > 0) {
            getPhysics().move(true, 1);
        }
        if (closest_ship_angle < 0) {
            getPhysics().move(true, -1);
        }
        getPhysics().move(true,0);
        if (this.getPhysics().distanceFrom(closest_ship.getPhysics()) < 0.19){
            this.shieldOn();
        }
        if (this.currEnergy < this.maxEnergy) {
            currEnergy += 1;
        }
        this.roundsCounter += 1;


    }
    /**
     * Gets the image of this basher ship. This method should return the image of the
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
