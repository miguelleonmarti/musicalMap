package es.ulpgc.miguel.second_session.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

    // listeners
    map.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View view, MotionEvent event) {
        int songURI = presenter.getZone(event.getX(), event.getY());

        if (songURI != -1) {
          mediaPlayer = MediaPlayer.create(getApplicationContext(), songURI);
          if (mediaPlayer.isPlaying()) {
            mediaPlayer.reset();
            // mediaPlayer.stop(); TODO: COMPROBAR EL MÉTODO
          }
          mediaPlayer.start();
        }

        return true;
      }
    });

    map.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Log.d("d", String.valueOf(v.getX()));
      }
    });

    // do the setup
    MapScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(MapContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(MapViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data

  }
}
