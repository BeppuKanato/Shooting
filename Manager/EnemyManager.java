package Manager;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;

import Character.Enemy;

public class EnemyManager {
    private static EnemyManager instance;

    private List<Enemy> enemys = new ArrayList<Enemy>();

    private EnemyManager () {

    }

    public EnemyManager GetInstance () {
        if (instance == null) {
            instance = new EnemyManager();
        }
        return instance;
    }

    public void DrawEnemys () {
        for (Enemy enemy : enemys) {
            enemy.DrowChar();
        }
    }

    public void EnemyMove () {
        for (Enemy enemy : enemys) {
            enemy.CharMove();
        }
    }

    public void CharShoot (Pane root) {
        for (Enemy enemy : enemys) {
            enemy.CharShoot(root);
        }
    }
}
