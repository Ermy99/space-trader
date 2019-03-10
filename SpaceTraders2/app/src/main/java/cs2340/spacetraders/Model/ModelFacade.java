package cs2340.spacetraders.Model;

class ModelFacade {
    private static ModelFacade singletonInstance = new ModelFacade();

    static ModelFacade getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new ModelFacade();
        }
        return singletonInstance;
    }

    private ModelFacade() {
    }
}
