package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		File file=new File("/music.mp3");
		 final String source=file.toURI().toString();
		Player player = new Player(source);
				Scene scene = new Scene(player,720,480, Color.BLACK);
				primaryStage.setScene(scene);
				primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
