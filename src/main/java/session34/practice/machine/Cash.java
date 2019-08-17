package session34.practice.machine;

public enum Cash {
    ONE(1), FIVE(5), TEN(10);

    private final int denomination;

    private Cash(int denomination) {
        this.denomination = denomination;
    }

    public int getDenomination() {
        return denomination;
    }
}
