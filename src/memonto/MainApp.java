package memonto;

/**
 * @author Ruobing Shang 2022-10-10 10:08
 */
public class MainApp {
    public static void main(String[] args) {
        Database database = new Database();
        HistoryManager historyManager = new HistoryManager();

        database.setState(1);
        historyManager.saveHistory(database.save());
        database.setState(2);
        historyManager.saveHistory( database.save());
        database.setState(3);
        historyManager.saveHistory(database.save());

        historyManager.showHistory();
        historyManager.undo();
        historyManager.undo();
        System.out.println("Undo two operations");
        historyManager.showHistory();
    }
}
