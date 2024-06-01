package templatemethod;

/**
 * @author Ruobing Shang 2022-10-14 15:52
 */
public class JsonDataMiner extends DataMiner {
    @Override
    public void extractData() {
        System.out.println("Extracting JSON...");
    }

    @Override
    public void parseData() {
        System.out.println("Parsing JSON...");
    }
}
