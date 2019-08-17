package session34.tank;

import org.springframework.beans.factory.annotation.Autowired;

public interface Tank {}

interface Cannon {
    void reload(Round round);
}

interface ShellLoader {
    void load(Cannon cannon);
}

interface Round {
    void damage(Object target);
}

final class Caliber76Cannon implements Cannon{
    @Override
    public void reload(Round round) {}
}

final class PhotoCannon implements Cannon {
    @Override
    public void reload(Round round) {}
}

final class ManualShellLoader implements ShellLoader {
    @Override
    public void load(Cannon cannon) {
    }
}

final class AutoShellLoader implements ShellLoader {
    @Override
    public void load(Cannon cannon) {
    }
}

final class ArmorPiercingRound implements Round {
    @Override
    public void damage(Object target) {}
}

final class HighExplosiveRound implements Round {
    @Override
    public void damage(Object target) {}
}

final class EnergyPackage implements Round {
    @Override
    public void damage(Object target) {}
}

class Chassis implements Tank{
    private final Cannon cannon;
    private final ShellLoader loader;

    @Autowired
    Chassis(Cannon cannon, ShellLoader loader) {
        this.cannon = cannon;
        this.loader = loader;
    }

    void reload() {
        loader.load(cannon);
    }
}

class T34 implements Tank{
    private Cannon cannon = new Caliber76Cannon();
    private ShellLoader loader = new ManualShellLoader();
}

class FutureTank implements Tank{
    private Cannon cannon = new PhotoCannon();
    private ShellLoader loader = new AutoShellLoader();
}

