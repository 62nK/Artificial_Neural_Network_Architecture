import architecture.NeuralNetwork;
import architecture.InputTargetPair;
import java.util.ArrayList;

public class TestANN implements Constants {

    public static void main(String[] args) {

        // Objects
        NeuralNetwork artificialNeuralNetwork;

        // Input
        ArrayList<InputTargetPair> trainingSet = new ArrayList<>();
        {
            trainingSet.add(new InputTargetPair(new double[]{-10, -10, -10, -10}, new double[]{0, 1}));
            trainingSet.add(new InputTargetPair(new double[]{-10, -10, -10, 10}, new double[]{0, 1}));
            trainingSet.add(new InputTargetPair(new double[]{-10, -10, 10, -10}, new double[]{0, 1}));
            trainingSet.add(new InputTargetPair(new double[]{-10, -10, 10, 10}, new double[]{1, 0}));
            trainingSet.add(new InputTargetPair(new double[]{-10, 10, -10, -10}, new double[]{0, 1}));
            trainingSet.add(new InputTargetPair(new double[]{-10, 10, -10, 10}, new double[]{1, 0}));
            trainingSet.add(new InputTargetPair(new double[]{-10, 10, 10, -10}, new double[]{1, 0}));
            trainingSet.add(new InputTargetPair(new double[]{-10, 10, 10, 10}, new double[]{1, 0}));
            trainingSet.add(new InputTargetPair(new double[]{10, -10, -10, -10}, new double[]{0, 1}));
            trainingSet.add(new InputTargetPair(new double[]{10, -10, -10, 10}, new double[]{1, 0}));
            trainingSet.add(new InputTargetPair(new double[]{10, -10, 10, -10}, new double[]{1, 0}));
            trainingSet.add(new InputTargetPair(new double[]{10, -10, 10, 10}, new double[]{1, 0}));
            trainingSet.add(new InputTargetPair(new double[]{10, 10, -10, -10}, new double[]{1, 0}));
            trainingSet.add(new InputTargetPair(new double[]{10, 10, -10, 10}, new double[]{1, 0}));
            trainingSet.add(new InputTargetPair(new double[]{10, 10, 10, -10}, new double[]{1, 0}));
            trainingSet.add(new InputTargetPair(new double[]{10, 10, 10, 10}, new double[]{1, 0}));
        }
        ArrayList<InputTargetPair> testSet = new ArrayList<>();
        {
            testSet.add(new InputTargetPair(new double[]{10, 10, -10, -10}, new double[]{1, 0}));
            testSet.add(new InputTargetPair(new double[]{-10, 10, 10, -10}, new double[]{1, 0}));
            testSet.add(new InputTargetPair(new double[]{10, 10, 10, 10}, new double[]{1, 0}));
            testSet.add(new InputTargetPair(new double[]{-10, -10, -10, -10}, new double[]{0, 1}));
            testSet.add(new InputTargetPair(new double[]{-10, -10, 10, -10}, new double[]{0, 1}));
            testSet.add(new InputTargetPair(new double[]{10, 10, 10, 10}, new double[]{1, 0}));

        }
        ArrayList<double[]> inputs = new ArrayList<>();
        {
            inputs.add(new double[]{-10, -10, -10, -10});
            inputs.add(new double[]{-10, 10, -10, 10});
            inputs.add(new double[]{10, 10, 10, 10});
        }

        // Restore Neurons
        if(RESTORE) artificialNeuralNetwork = new NeuralNetwork(NeuralNetwork.readANNFromFile(PATH+FILENAME));
        else artificialNeuralNetwork = new NeuralNetwork(LAYER_COUNT, INPUT_LAYER_NEURON_COUNT, HIDDEN_LAYER_NEURON_COUNT, OUTPUT_LAYER_NEURON_COUNT);;
        if(DEBUG) System.out.println(artificialNeuralNetwork.toString("Architecture"));

        // Train
        if(TRAINING_MODE) {
            artificialNeuralNetwork.train(EPOCHS, LEARNING_RATE, trainingSet);
            if(DEBUG) System.out.println("Training set error("+trainingSet.size()+"):"+artificialNeuralNetwork.getNetworkError());
            artificialNeuralNetwork.test(testSet);
            if(DEBUG) System.out.println("Test set error("+testSet.size()+"):"+artificialNeuralNetwork.getNetworkError());
        }

        // Categorize
        if(CATEGORIZING_MODE) {
            for(double[] input: inputs){
                artificialNeuralNetwork.feedForward(input);
                double[] output = artificialNeuralNetwork.getOutput();
                if(DEBUG) {
                    System.out.println(artificialNeuralNetwork.outputToString());
                    if (output[0] > output[1])
                        System.out.println("Bright");
                    else
                        System.out.println("Dark");
                }
            }
        }

        // Save Neural Network
        if(SAVE) artificialNeuralNetwork.writeANNToFile(PATH+FILENAME);
        if(DEBUG) System.out.println(artificialNeuralNetwork.toString("Architecture"));

    }

}