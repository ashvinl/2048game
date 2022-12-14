package y2020_loghashankar_ashvin_period_1_individual_project;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Game extends Application{
	Scene game;
	Scene gameOver;
	Scene endScene;
	Stage stage;
	GridPane g;
	Model m;
	Media sound;
	Group end;
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		stage.setTitle("2048");
		stage.setResizable(false);
		stage.sizeToScene();
		
		Group title = new Group();
		Scene titleScene = new Scene(title, 400,400);
		
		String path = getClass().getClassLoader().getResource("resources/title.jpg").toString();
		Image img = new Image(path);
		ImageView imgView = new ImageView(img);
		title.getChildren().add(imgView);
		
		Button playButton = new Button("Play");
		playButton.setPrefSize(60, 40);
		playButton.setLayoutX(200 - playButton.getPrefWidth()/2);
		playButton.setLayoutY(300);
		title.getChildren().add(playButton);
		playButton.setOnMouseClicked(new PlayHandler());
		
		stage.setScene(titleScene);
		//title scene node thing:
		
		m = new Model();
		g = new GridPane();
		game = new Scene(g);
		game.setOnKeyPressed(new Mover());
		update();
		stage.show();
		
		
		end = new Group();
		endScene = new Scene(end, 400, 400);
		
		String path2 = getClass().getClassLoader().getResource("resources/end.jpg").toString();
		Image img2 = new Image(path2);
		ImageView imgView2 = new ImageView(img2);
		end.getChildren().add(imgView2);
		
		Button returnButton = new Button("Return to Menu!");
		returnButton.setPrefSize(200, 40);
		returnButton.setLayoutX(200 - returnButton.getPrefWidth()/2);
		returnButton.setLayoutY(240);
		end.getChildren().add(returnButton);
		returnButton.setOnMouseClicked(new ReturnHandler());
		
		String pathMusic = getClass().getClassLoader().getResource("resources/bop.mp3").toString();
		sound = new Media(pathMusic);
	}
	
	public void update() {
		for(int i = 0; i < 4; i++){
			for(int j = 0; j<4; j++) {
				int num = m.getValue(i, j);
				if(num == 0) {
					String path = getClass().getClassLoader().getResource("resources/zero.jpg").toString();
					Image img = new Image(path);
					ImageView imgView = new ImageView(img);
					g.setConstraints(imgView, j, i);
					g.getChildren().add(imgView);
				}
				else if(num == 2) {
					String path = getClass().getClassLoader().getResource("resources/two.jpg").toString();
					Image img = new Image(path);
					ImageView imgView = new ImageView(img);
					g.setConstraints(imgView, j, i);
					g.getChildren().add(imgView);
				}
				else if(num == 4) {
					String path = getClass().getClassLoader().getResource("resources/four.jpg").toString();
					Image img = new Image(path);
					ImageView imgView = new ImageView(img);
					g.setConstraints(imgView, j, i);
					g.getChildren().add(imgView);
				}
				else if(num == 8) {
					String path = getClass().getClassLoader().getResource("resources/eight.jpg").toString();
					Image img = new Image(path);
					ImageView imgView = new ImageView(img);
					g.setConstraints(imgView, j, i);
					g.getChildren().add(imgView);
				}
				else if(num == 16) {
					String path = getClass().getClassLoader().getResource("resources/sixteen.jpg").toString();
					Image img = new Image(path);
					ImageView imgView = new ImageView(img);
					g.setConstraints(imgView, j, i);
					g.getChildren().add(imgView);
				}
				else if(num == 32) {
					String path = getClass().getClassLoader().getResource("resources/thirtytwo.jpg").toString();
					Image img = new Image(path);
					ImageView imgView = new ImageView(img);
					g.setConstraints(imgView, j, i);
					g.getChildren().add(imgView);
				}
				else if(num == 64) {
					String path = getClass().getClassLoader().getResource("resources/sixtyfour.jpg").toString();
					Image img = new Image(path);
					ImageView imgView = new ImageView(img);
					g.setConstraints(imgView, j, i);
					g.getChildren().add(imgView);
				}
				else if(num == 128) {
					String path = getClass().getClassLoader().getResource("resources/onetwoeight.jpg").toString();
					Image img = new Image(path);
					ImageView imgView = new ImageView(img);
					g.setConstraints(imgView, j, i);
					g.getChildren().add(imgView);
				}
				else if(num == 256) {
					String path = getClass().getClassLoader().getResource("resources/twofivesix.jpg").toString();
					Image img = new Image(path);
					ImageView imgView = new ImageView(img);
					g.setConstraints(imgView, j, i);
					g.getChildren().add(imgView);
				}
				else if(num == 512) {
					String path = getClass().getClassLoader().getResource("resources/fivetwelve.jpg").toString();
					Image img = new Image(path);
					ImageView imgView = new ImageView(img);
					g.setConstraints(imgView, j, i);
					g.getChildren().add(imgView);
				}
				else if(num == 1024) {
					String path = getClass().getClassLoader().getResource("resources/onezerotwofour.jpg").toString();
					Image img = new Image(path);
					ImageView imgView = new ImageView(img);
					g.setConstraints(imgView, j, i);
					g.getChildren().add(imgView);
				}
				else if(num == 2048) {
					String path = getClass().getClassLoader().getResource("resources/finaltile.jpg").toString();
					Image img = new Image(path);
					ImageView imgView = new ImageView(img);
					g.setConstraints(imgView, j, i);
					g.getChildren().add(imgView);
				}
			}
		}
	}

	private class Mover implements EventHandler<KeyEvent>{

		@Override
		public void handle(KeyEvent event) {
			if(event.getCode() == KeyCode.LEFT) {
				m.moveLeft();
				update();
			}
			else if(event.getCode() == KeyCode.RIGHT) {
				m.moveRight();
				update();
			}
			else if(event.getCode() == KeyCode.UP) {
				m.moveUp();
				update();
			}
			else if(event.getCode() == KeyCode.DOWN) {
				m.moveDown();
				update();
			}
			if(m.isGameOver()) {
				Text t = new Text("Your score is " + m.calculateScore());
				t.setFill(Color.RED);
				t.setLayoutX(150);
				t.setLayoutY(330);
				end.getChildren().add(t);
				stage.setScene(endScene);
			}
			MediaPlayer effect = new MediaPlayer(sound);
			effect.play();
			effect.setStartTime(new Duration(0));
		}
		
	}
	
	private class PlayHandler implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			stage.setScene(game);
		}
		
	}
	
	private class ReturnHandler implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			try {
				start(stage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
