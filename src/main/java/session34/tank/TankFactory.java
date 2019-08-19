package session34.tank;

public final class TankFactory {
    public static Tank produceTank(String params) {
        final Tank tank;
        if ("T34".endsWith(params)) {
            tank = new Chassis(
                    new Caliber76Cannon(),
                    new ManualShellLoader()
            );
        } else if ("Future".endsWith(params)) {
            tank = new Chassis(
                    new PhotoCannon(),
                    new AutoShellLoader()
            );
        } else {
            throw new IllegalArgumentException(
                    "Cannot produce tank:" + params);
        }
        return tank;
    }
}
