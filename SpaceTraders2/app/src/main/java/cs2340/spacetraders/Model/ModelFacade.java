package cs2340.spacetraders.Model;

class ModelFacade {
    private static final ModelFacade ourInstance = new ModelFacade();

    static ModelFacade getInstance() {
        return ourInstance;
    }

    private ModelFacade() {
    }
}
