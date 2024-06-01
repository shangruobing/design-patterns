package memento;

import java.time.LocalDateTime;

/**
 * @author Ruobing Shang 2022-10-10 10:01
 */
public class DatabaseMemento implements Memento {
    private final Database database;
    private final LocalDateTime date;
    private final int state;

    public DatabaseMemento(Database database, int state) {
        this.database = database;
        this.state = state;
        this.date = LocalDateTime.now();
    }

    @Override
    public void restore() {
        database.setState(state);
    }

    @Override
    public String toString() {
        return "Memento{" +
                "database=" + database +
                ", date=" + date +
                ", history=" + state +
                '}';
    }
}
