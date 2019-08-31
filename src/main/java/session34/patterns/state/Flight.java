package session34.patterns.state;

class Flight {
    private Weapon weapon = Weapon.AutoCannon;

    void upgrade(Weapon weapon) {
        this.weapon = weapon;
    }

    void fire() {
        weapon.fire();
    }
}

enum  Weapon {
    AutoCannon{
        @Override
        void fire() {
            // throw some projectile
        }
    },
    BeamLaser{
        @Override
        void fire() {
            // shoot out beam
        }
    };

  abstract void fire();
}
