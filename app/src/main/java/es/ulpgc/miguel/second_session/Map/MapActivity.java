package es.ulpgc.miguel.second_session.Map;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import es.ulpgc.miguel.second_session.R;

public class MapActivity
    extends AppCompatActivity implements MapContract.View {

  public static String TAG = MapActivity.class.getSimpleName();

  private MapContract.Presenter presenter;

  // declaring the buttons
  private ImageView map;

  // media player
  private MediaPlayer mediaPlayer;

  @SuppressLint("ClickableViewAccessibility")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_map);

    // finding buttons
    map = findViewById(R.id.map);

    // listener
    map.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View view, MotionEvent event) {
        presenter.getZone(event.getX(), event.getY());
        return true;
      }
    });

    // do the setup
    MapScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  public void injectPresenter(MapContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(MapViewModel viewModel) {
    if (viewModel.getSongUri() != -1) {
      if (mediaPlayer == null) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), viewModel.getSongUri());
        mediaPlayer.start();
        Toast.makeText(this, viewModel.getName(), Toast.LENGTH_SHORT).show();
      } else {
        mediaPlayer.release();
        mediaPlayer = null;
        mediaPlayer = MediaPlayer.create(getApplicationContext(), viewModel.getSongUri());
        mediaPlayer.start();
        Toast.makeText(this, viewModel.getName(), Toast.LENGTH_SHORT).show();
      }
    } else {
      mediaPlayer.release();
      mediaPlayer = null;
    }
  }
}
