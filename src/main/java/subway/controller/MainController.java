package subway.controller;

import subway.domain.Menu.MainMenu;
import subway.view.InputView;

import java.util.HashMap;

import static subway.domain.Menu.MainMenu.*;

public class MainController {
    private final InputView inputView = new InputView();
    private static final HashMap<MainMenu, SubwayController> controllers = new HashMap<>();

    public MainController() {
        controllers.put(STATION_MENU, new StationController());
        controllers.put(LINE_MENU, new LineController());
        controllers.put(SECTION_MENU, new SectionController());
        controllers.put(PRINT_MAP, new MapController());
    }

    public void start() {
        readMenu();
    }

    private void readMenu() {
        while (true) {
            try {
                MainMenu mainMenu = inputView.readMainMenu();
                if (mainMenu == QUIT) {
                    break;
                }
                runController(mainMenu);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void runController(MainMenu mainMenu) {
        SubwayController controller = controllers.get(mainMenu);
        controller.start();
    }
}
