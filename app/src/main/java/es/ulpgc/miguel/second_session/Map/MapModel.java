package es.ulpgc.miguel.second_session.Map;

import java.util.ArrayList;

public class MapModel implements MapContract.Model {

  public static String TAG = MapModel.class.getSimpleName();

  private ArrayList<Zones> zonesArrayList;

  private Zones canarias, andalucia, extremadura, murcia, mancha, valencia, baleares, cataluna, aragon, navarra, vasco, rioja, cantabria, asturias, galicia, madrid, leon;

  public MapModel() {
    canarias = new Zones("Canarias", 2.9700, 687.3551, 255.6541, 785.2787);
    andalucia = new Zones("Andalucía", 290.6105, 618.4091, 471.3845, 668.3699);
    extremadura = new Zones("Extremadura", 271.6342, 501.5003, 329.5618, 569.4473);
    murcia = new Zones("Región de Murcia", 491.3596, 599.4239, 528.3134, 623.4052);
    mancha = new Zones("Castilla La Mancha", 374.5056, 501.5004, 500.3483, 558.4559);
    valencia = new Zones("Valencia", 0, 0, 0, 0);
    baleares = new Zones("Baleares", 0, 0, 0, 0);
    cataluna = new Zones("Cataluña", 529.2272, 354.6151, 677.1274, 432.5543);
    aragon = new Zones("Aragón", 0, 0, 0, 0);
    navarra = new Zones("Navarra", 0, 0, 0, 0);
    vasco = new Zones("Vasco", 0, 0, 0, 0);
    rioja = new Zones("Rioja", 0, 0, 0, 0);
    cantabria = new Zones("Cantabria", 0, 0, 0, 0);
    asturias = new Zones("Asturias", 0, 0, 0, 0);
    galicia = new Zones("Galicia", 188.7378, 281.6721, 268.6379, 363.6081);
    madrid = new Zones("Madrid", 0, 0, 0, 0);
    leon = new Zones("Castilla y León", 298.6005, 341.6253, 411.4594, 415.5676);

    zonesArrayList = new ArrayList<>();
    zonesArrayList.add(canarias);
    zonesArrayList.add(andalucia);
    zonesArrayList.add(extremadura);
    zonesArrayList.add(murcia);
    zonesArrayList.add(mancha);
    zonesArrayList.add(valencia);
    zonesArrayList.add(baleares);
    zonesArrayList.add(cataluna);
    zonesArrayList.add(aragon);
    zonesArrayList.add(navarra);
    zonesArrayList.add(vasco);
    zonesArrayList.add(rioja);
    zonesArrayList.add(cantabria);
    zonesArrayList.add(asturias);
    zonesArrayList.add(galicia);
    zonesArrayList.add(madrid);
    zonesArrayList.add(leon);
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public String getZone(double x, double y) {
    int length = zonesArrayList.size();
    for (int i = 0; i < length; i++) {
      if (x >= zonesArrayList.get(i).getX0() && x <= zonesArrayList.get(i).getX1()) {
        if (y >= zonesArrayList.get(i).getY0() && y <= zonesArrayList.get(i).getY1()) {
          return zonesArrayList.get(i).getName();
        }
      }
    }
    return "No se ha registrado esta zona";
  }
}
