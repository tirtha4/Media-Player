package application;



import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class MediaPanel extends HBox {
	// Creating panel components
	Slider time =new Slider();
	Slider vol =new Slider();
	Button playButton = new Button("||");
	Label volume = new Label("Volume: ");
	MediaPlayer player;
	
	public  MediaPanel(MediaPlayer play) {
		player=play;
		
		// Specifying dimension & location of components
		//player.getMedia().getWidth()
		setAlignment(Pos.CENTER);
	
		setPadding(new Insets(5,10,5,10));
		HBox.setHgrow(time, Priority.ALWAYS);
		vol.setPrefWidth(70);
		vol.setMinWidth(30);
		vol.setValue(100);
		
	playButton.setPrefSize(30,30);

	// Adding components to node
		getChildren().add(playButton);
		getChildren().add(time);
		getChildren().add(volume);
		getChildren().add(vol);
		
		// ------Defining Functions------
		playButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e) {
				Status status = player.getStatus();
				
				if(status == Status.PLAYING) {
					if(player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())) {
						player.seek(player.getStartTime());
						player.play();
					}
					else {
						player.pause();
						playButton.setText("PLAY");
					}
				}
				
				if (status == Status.PAUSED || status == Status.HALTED || status==Status.STOPPED){
					player.play();
					playButton.setText("||");
				
			}
			
		}
		
	});
		//Set listener to get updates of current time
		player.currentTimeProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable obs) {
				updateValues();
			}
		});
		// listener for the time slider
		time.valueProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable obs) {
			if(time.isPressed() ) {
				player.seek(player.getMedia().getDuration().multiply(time.getValue()/100));
			}
		}
	});
		//listener for volume slider
		vol.valueProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable obs) {
			if(vol.isPressed() ) {
				player.setVolume(vol.getValue()/100);
		}
	}
});
		
		
	}
	// updateValue sets the current time of the player while running.
		protected void updateValues() {
			Platform.runLater(new Runnable(){
				public void run() {
						 time.setValue(player.getCurrentTime().toMillis()/player.
								 getTotalDuration().toMillis()*100);
				}
			});
		}
		
  }




