import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.collections.*;

public class App extends Application
{
public void start(Stage stage) throws Exception
{
// ボタンを生成／設定します
Button[] btn = new Button[3];
btn[0] = new Button("ボタン１");
btn[1] = new Button("ボタン２");
btn[2] = new Button("ボタン３");
// レイアウトを生成／設定します
FlowPane flowpane = new FlowPane();
ObservableList<Node> lst = flowpane.getChildren();
lst.addAll(btn);
// シーンを生成／設定します
Scene scene = new Scene(flowpane);
// ステージを設定します
stage.setScene(scene);
stage.setTitle("レイアウト");
// ステージを表示します
stage.show();
}
public static void main(String[] args)
{
launch(args);
}
}
