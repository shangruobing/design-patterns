package templatemethod;

/**
 * @author Ruobing Shang 2022-10-14 15:34
 */
public abstract class DataMiner {
    public final void mine() {
        extractData();
        parseData();
        analyzeData();
        sendReport();
    }

    public abstract void extractData();

    public abstract void parseData();

    public void analyzeData() {
        System.out.println("Analyzing...");
    }

    public void sendReport() {
        System.out.println("Reporting...");
    }
}
