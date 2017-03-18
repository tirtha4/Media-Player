package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		//Creating file object for media source
		File file=new File("D:/music.mp3");
		// Change URI to string format in file
		 final String source=file.toURI().toString();
			Player player = new Player(source);
				Scene scene = new Scene(player,720,480);
				primaryStage.setScene(scene);
				primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
