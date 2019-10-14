package es.ulpgc.miguel.second_session.Map;

import java.util.ArrayList;

import es.ulpgc.miguel.second_session.R;
import es.ulpgc.miguel.second_session.dataModels.Zone;

public class MapModel implements MapContract.Model {

  public static String TAG = MapModel.class.getSimpleName();

  private ArrayList<Zone> zoneArrayList;

  private Zone canarias, andalucia, extremadura, murcia, mancha, valencia, baleares, cataluna, aragon, navarra, vasco, rioja, cantabria, asturias, galicia, madrid, leon;

  public MapModel() {
    canarias = new Zone("Canarias", R.raw.canarias,2.9700, 687.3551, 255.6541, 785.2787);
    andalucia = new Zone("Andalucía",R.raw.andalucia,290.6105, 618.4091, 471.3845, 668.3699);
    extremadura = new Zone("Extremadura", R.raw.extremadura,271.6342, 501.5003, 329.5618, 569.4473);
    murcia = new Zone("Región de Murcia", R.raw.murcia,491.3596, 599.4239, 528.3134, 623.4052);
    mancha = new Zone("Castilla La Mancha", R.raw.mancha,374.5056, 501.5004, 500.3483, 558.4559);
    valencia = new Zone("Valencia", R.raw.valencia,530.3109, 504.4980, 578.2510, 599.4239);
    baleares = new Zone("Baleares", R.raw.baleares,627.1898, 482.5152, 757.0275, 558.4559);
    cataluna = new Zone("Cataluña", R.raw.cataluna,529.2272, 354.6151, 677.1274, 432.5543);
    aragon = new Zone("Aragón", R.raw.aragon,511.3346, 354.6151, 567.2647, 435.5519);
    navarra = new Zone("Navarra", R.raw.navarra,478.3758, 326.6370, 504.3433, 350.6183);
    vasco = new Zone("Vasco", R.raw.vasco,443.4195, 303.6550, 465.3920, 327.6362);
    rioja = new Zone("Rioja", R.raw.rioja, 437.4270, 352.6167, 472.3833, 365.6066);
    cantabria = new Zone("Cantabria", R.raw.cantabria, 381.4969, 294.6620, 407.4644, 309.6502);
    asturias = new Zone("Asturias", R.raw.asturias, 283.6192, 281.6721, 346.5405, 303.6550);
    galicia = new Zone("Galicia", R.raw.galicia, 188.7378, 281.6721, 268.6379, 363.6081);
    madrid = new Zone("Madrid", R.raw.madrid, 392.4831, 450.5402, 424.4432, 473.5222);
    leon = new Zone("Castilla y León", R.raw.leon, 298.6005, 341.6253, 411.4594, 415.5676);

    zoneArrayList = new ArrayList<>();
    zoneArrayList.add(canarias);
    zoneArrayList.add(andalucia);
    zoneArrayList.add(extremadura);
    zoneArrayList.add(murcia);
    zoneArrayList.add(mancha);
    zoneArrayList.add(valencia);
    zoneArrayList.add(baleares);
    zoneArrayList.add(cataluna);
    zoneArrayList.add(aragon);
    zoneArrayList.add(navarra);
    zoneArrayList.add(vasco);
    zoneArrayList.add(rioja);
    zoneArrayList.add(cantabria);
    zoneArrayList.add(asturias);
    zoneArrayList.add(galicia);
    zoneArrayList.add(madrid);
    zoneArrayList.add(leon);
  }

  @Override
  public Zone getZone(double x, double y) {
    int length = zoneArrayList.size();
    for (int i = 0; i < length; i++) {
      if (x >= zoneArrayList.get(i).getX0() && x <= zoneArrayList.get(i).getX1()) {
        if (y >= zoneArrayList.get(i).getY0() && y <= zoneArrayList.get(i).getY1()) {
          return zoneArrayList.get(i);
        }
      }
    }
    return null;
  }
}
