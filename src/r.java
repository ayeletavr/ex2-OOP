import java.awt.Image;
import oop.ex2.*;

/** This class represents the runner spaceship. This spaceship attempts to run away from the fight.
 * It will always accelerate, and will constantly turn away from the closest ship.
 * If the nearest ship is closer than 0.25 units, and if its angle to the runner is less than 0.23 radians,
 * the runner feels threatened and will attempt to teleport.
 */

public class r extends SpaceShip {

    /**
     * Does the actions of this runner ship for this round.
     * This is called once per round by the SpaceWars game driver.
     * @param game the game object to which this ship belongs.
     */
    public void doAction(SpaceWars game) {
        SpaceShip closest_ship = game.getClosestShipTo(this);
        double closest_ship_angle = closest_ship.getPhysics().angleTo(closest_ship.getPhysics());
        if (this.getPhysics().distanceFrom(closest_ship.getPhysics()) < 0.25 &&
                this.getPhysics().angleTo(closest_ship.getPhysics()) < 0.23){
            this.teleport();
        }
        //isAccelerates = true;
        if (closest_ship_angle > 0) {
            getPhysics().move(true, -1);
        }
        if (closest_ship_angle < 0) {
            getPhysics().move(true, 1);
        }
        getPhysics().move(true ,0);
        if (this.currEnergy < this.maxEnergy){
            currEnergy += 1;
        }
        this.roundsCounter += 1;
    }

    /**
     * Gets the image of this runner ship. This method should return the image of the
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
