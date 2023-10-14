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

    public static EnemyManager GetInstance () {
        if (instance == null) {
            instance = new EnemyManager();
        }
        return instance;
    }

    public void AddEnemys (Enemy enemy) {
        enemys.add(enemy);
    }

    public void DrawEnemys () {
        for (Enemy enemy : enemys) {
            enemy.DrowChar();
        }
    }

    public void EnemysMove (long timer) {
        for (Enemy enemy : enemys) {
            enemy.CharMove(timer);
        }
    }

    public void EnemysShoot (Pane root) {
        for (Enemy enemy : enemys) {
            enemy.CharShoot(root);
        }
    }
}
