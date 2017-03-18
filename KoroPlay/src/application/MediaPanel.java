package application;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;

public class MediaPanel extends HBox {
	Slider time =new Slider();
	Slider vol =new Slider();
	Button playButton = new Button("||");
	Label volume = new Label("Volume: ");
	MediaPlayer player;
	public  MediaPanel(MediaPlayer play) {
		player=play;
		
		setAlignment(Pos.CENTER);
		setPadding(new Insets(5,10,5,10));
		HBox.setHgrow(time, Priority.ALWAYS);
		vol.setPrefWidth(70);
		vol.setMinWidth(30);
		vol.setValue(100);
		
	playButton.setPrefSize(30,30);
		getChildren().add(playButton);
		
		getChildren().add(time);
		getChildren().add(volume);
		getChildren().add(vol);
		
		
	}

	
}
