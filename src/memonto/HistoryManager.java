package memonto;

import java.util.ArrayList;

/**
 * @author Ruobing Shang 2022-10-10 10:03
 */
public class HistoryManager {
    private final ArrayList<Memento> history = new ArrayList<>();

    public void saveHistory(Memento memento) {
        history.add(memento);
    }

    public void showHistory() {
        for (Memento memento : history) {
            System.out.println(memento);
        }
    }

    public void undo() {
        if (history.size() <= 1) {
            System.out.println("HistoryManager doesn't has history.");
            return;
        }
        int index = history.size() - 1;
        history.get(index - 1).restore();
        history.remove(index);
    }
}
