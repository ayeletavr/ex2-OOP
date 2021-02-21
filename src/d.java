import java.awt.Image;
import oop.ex2.*;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Its pilot had too much to drink, and now it is moving randomly, with no connection to the other ships around.
 * Also, since its pilot reaction is very slow, it attempt to turn its shield on when distance from the closest ship is 0.05 units.
 * Its always accelerate.
 * DON'T DRINK AND FLY!
 */

public class d extends SpaceShip {

    /**
     * Does the actions of this drunkard ship for this round.
     * This is called once per round by the SpaceWars game driver.
     * @param game the game object to which this ship belongs.
     */
    public void doAction(SpaceWars game) {
        SpaceShip closest_ship = game.getClosestShipTo(this);
        int rn = ThreadLocalRandom.current().nextInt(-1,1);
        getPhysics().move(true, rn);
        if (this.getPhysics().distanceFrom(closest_ship.getPhysics()) < 0.05){
            this.shieldOn();
        }
        if (this.currEnergy < this.maxEnergy) {
            currEnergy += 1;
        }
        this.roundsCounter += 1;

    }

    /**
     * Gets the image of this drunkard ship. This method should return the image of the
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
