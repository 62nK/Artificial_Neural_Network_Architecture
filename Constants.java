public interface Constants {

    /** Neural Network **/
    // Neuron Configuration
    int LAYER_COUNT = 3;
    int INPUT_LAYER_NEURON_COUNT = 4;
    int HIDDEN_LAYER_NEURON_COUNT = 8;
    int OUTPUT_LAYER_NEURON_COUNT = 2;

    /** FLAGS **/
    // Functioning Mode
    boolean TRAINING_MODE = false;
    boolean CATEGORIZING_MODE = !TRAINING_MODE;
    // IO
    boolean RESTORE = true; // Restore
    boolean SAVE = TRAINING_MODE;  // Save final state of synapses
    // Debug: std output messages
    boolean DEBUG = true;

    // Training
    int EPOCHS = 10000;
    double LEARNING_RATE = 0.1; // -1 for learning rate = 1/(1+epoch#)

    // IO
    String PATH = "src/cfg/";
    String FILENAME = "ANNconfig.cfg";
}
