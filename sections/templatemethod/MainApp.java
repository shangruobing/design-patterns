package templatemethod;

/**
 * @author Ruobing Shang 2022-10-14 15:56
 */
public class MainApp {
    public static void main(String[] args) {
        DataMiner jsonDataMiner = new JsonDataMiner();
        jsonDataMiner.mine();
        DataMiner xmlDataMiner = new XmlDataMiner();
        xmlDataMiner.mine();
    }
}
