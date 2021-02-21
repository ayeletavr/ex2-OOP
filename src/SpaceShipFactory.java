import oop.ex2.*;

public class SpaceShipFactory {
    public static SpaceShip[] createSpaceShips(String[] args) {
        SpaceShip[] spaceships = new SpaceShip[args.length];
        for (int i=0; i<args.length; i++) {
            if (args[i].equals("h")) {
                spaceships[i] = new h();
            }
            if (args[i].equals("r")) {
                spaceships[i] = new r();
            }
            if (args[i].equals("a")) {
                spaceships[i] = new a();
            }
            if (args[i].equals("b")) {
                spaceships[i] = new b();
            }
            if (args[i].equals("d")) {
                spaceships[i] = new d();
            }
            if (args[i].equals("s")) {
                spaceships[i] = new s();
            }
        }
        return spaceships;
    }
    }
