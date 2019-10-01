package es.ulpgc.miguel.second_session.Map;

import java.lang.ref.WeakReference;

interface MapContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(MapViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void getZone(double x, double y);
  }

  interface Model {
    String fetchData();

    String getZone(double x, double y);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(MapState state);

    MapState getDataFromPreviousScreen();
  }
}
