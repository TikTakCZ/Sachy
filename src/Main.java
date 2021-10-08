import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    // Konstruktory
    ScenaHryAScenaMenu scena_hry_a_scena_menu = new ScenaHryAScenaMenu();

    // Hlavni okno aplikace
    public static Stage novy_hlavni_okno_aplikace = new Stage();

    @Override
    public void start(Stage hlavni_okno_aplikace) {
        novy_hlavni_okno_aplikace = hlavni_okno_aplikace;

        // Vlastnosti okna
        novy_hlavni_okno_aplikace.setTitle("Šachy");
        novy_hlavni_okno_aplikace.setWidth(525);
        novy_hlavni_okno_aplikace.setHeight(550);
        novy_hlavni_okno_aplikace.getIcons().add(new Image("ikona_okna.png"));
        novy_hlavni_okno_aplikace.setResizable(false);

        // Nastavení menu scény
        novy_hlavni_okno_aplikace.setScene(scena_hry_a_scena_menu.nastaveniMenuSceny());

        novy_hlavni_okno_aplikace.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
