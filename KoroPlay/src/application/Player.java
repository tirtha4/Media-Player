
package application;


import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane {
	
	Media media;
	MediaPlayer player;
	MediaView view;
	Pane pane ;
	public  Player(String file) {
		media= new Media(file);
		player = new MediaPlayer(media);
		view = new MediaView(player);
		pane=new Pane();
		pane.getChildren().add(view);
		setCenter(pane);
		player.play();
	}
//	public MediaPlayer(Media media2) {
		// TODO Auto-generated constructor stub
//	}

}
