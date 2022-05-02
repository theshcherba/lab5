package utility.parser;

import classesandenums.Coordinates;

public class Validator {
    public int checkCoordinateX(Float x) {
        if (Coordinates.checkValidX(x)) return 1;
        return 0;
    }

    public int checkCoordinateY(Float y) {
        if (Coordinates.checkValidY(y)) return 1;
        return 0;
    }


    public int checkName(String name) {
        if (!name.equals("0") && !name.equals("")) return 1;
        return 0;
    }

    public int checkRealHero(Boolean realHero) {
        if (realHero != null) return 1;
        return 0;
    }

    public int checkSoundtrackName(String soundtrackName) {
        if (soundtrackName != null) return 1;
        return 0;
    }

    public int checkWeaponType(String weaponType) {
        try {
            .valueOf(weaponType);
            return 1;
        }
        catch (IllegalArgumentException e) {
            return 0;
        }
    }

    public int checkCar(String car) {
        if (car != null) return 1;
        return 0;
    }
}
