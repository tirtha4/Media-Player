
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
	MediaPanel panel;
	public  Player(String file) {
		media= new Media(file);
		player = new MediaPlayer(media);

		view = new MediaView(player);
	// Setting mediaView dimension w.r.t the media(video)
		view.setTranslateX(view.getFitWidth()  / 2 + 50); 
		view.setTranslateY(view.getFitHeight() / 2 - 13);
		view.setScaleX(0.90); view.setScaleY(0.95);
	    //Setting pane location
	    pane=new Pane();
		pane.getChildren().add(view);
		
        	setCenter(pane);


		panel=new MediaPanel(player);
		setStyle("-fx-background-color:BLACK");
		setBottom(panel);
		panel.setStyle("-fx-background-color:#ffffff");
		player.play();
	}

	//public MediaPlayer(Media media2) {
		// TODO Auto-generated constructor stub
//	}

}
