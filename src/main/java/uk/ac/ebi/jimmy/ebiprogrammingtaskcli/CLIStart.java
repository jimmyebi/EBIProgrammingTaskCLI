package uk.ac.ebi.jimmy.ebiprogrammingtaskcli;
import uk.ac.ebi.jimmy.ebiprogrammingtaskcli.logic.Processor;

public class CLIStart {

    public static void main(String[] args){

        Processor processorObj = new Processor();
        
        // read from std input
        processorObj.readStdInput();
        
        // process data
        processorObj.startProcess();
        
        System.out.print(processorObj.getStorage().getRangedResult());
    }
}
