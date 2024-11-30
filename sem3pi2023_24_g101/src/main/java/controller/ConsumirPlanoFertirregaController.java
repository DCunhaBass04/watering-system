package controller;

public final class ConsumirPlanoFertirregaController {

    private static ConsumirPlanoFertirregaController instance;

    private ConsumirPlanoFertirregaController() {

    }

    public static ConsumirPlanoFertirregaController getInstance() {
        if (instance == null) {
            instance = new ConsumirPlanoFertirregaController();
        }
        return instance;
    }

}
