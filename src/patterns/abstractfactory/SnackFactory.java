package patterns.abstractfactory;

public interface SnackFactory {
    String getSnack();
}

class PopcornFactory implements SnackFactory {
    @Override
    public String getSnack() {
        return "Popcorn";
    }
}

class DrinkFactory implements SnackFactory {
    @Override
    public String getSnack() {
        return "Soft Drink";
    }
}
