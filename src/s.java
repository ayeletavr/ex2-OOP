import java.awt.Image;
import oop.ex2.*;

/**
 * This spaceship moves in circles and always accelerate.
 * when the nearest ship is closest then 0.25 units, it attempts to turn its shield on.
 */

public class s extends SpaceShip {

    public void doAction(SpaceWars game) {
        SpaceShip closest_ship = game.getClosestShipTo(this);
        double closest_ship_angle = closest_ship.getPhysics().angleTo(closest_ship.getPhysics());
        getPhysics().move(true,1);
        getPhysics().move(true ,-1);
        if (this.getPhysics().distanceFrom(closest_ship.getPhysics()) < 0.25) {
            this.shieldOn();
        }
        if (this.currEnergy < this.maxEnergy) {
            currEnergy += 1;
        }
        this.roundsCounter += 1;

    }

    /**
     * Gets the image of this special ship. This method should return the image of the
     * ship with or without the shield. This will be displayed on the GUI at
     * the end of the round.
     *
     * @return the image of this ship.
     */
    public Image getImage() {
        if (this.shield) {
            return GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;
        }
        return GameGUI.ENEMY_SPACESHIP_IMAGE;
    }
}
