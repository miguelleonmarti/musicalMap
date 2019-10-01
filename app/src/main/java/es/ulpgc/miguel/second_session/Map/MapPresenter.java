package es.ulpgc.miguel.second_session.Map;

import android.util.Log;

import java.lang.ref.WeakReference;

public class MapPresenter implements MapContract.Presenter {

  public static String TAG = MapPresenter.class.getSimpleName();

  private WeakReference<MapContract.View> view;
  private MapViewModel viewModel;
  private MapContract.Model model;
  private MapContract.Router router;

  public MapPresenter(MapState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<MapContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(MapContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(MapContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    MapState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model
      String data = model.fetchData();

      // set initial state
      viewModel.data = data;
    }

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public int getZone(double x, double y) {
    return model.getZone(x,y);
  }


}
