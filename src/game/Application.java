package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.HuntsmanSpider;
import game.actors.Player;
import game.items.*;
import game.grounds.Puddle;
import game.grounds.*;
import game.maps.FactorySpaceshipParking;
import game.maps.Polymorphia;
import game.maps.Refactorio;
import game.maps.Travelable;
import game.plants.InheritreeSapling;
import game.plants.InheritreeSprout;
import game.plants.MatureInheritree;
import game.plants.YoungInheritree;
import game.spawners.SuspiciousAstronautSpawner;
import game.utils.FancyMessage;
import game.weapons.DragonSlayerSword;
import game.weapons.MetalPipe;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new InheritreeSapling(), new MatureInheritree(), new YoungInheritree(),
                new InheritreeSprout());


        List<String> polymorphiaASCIIMap = Arrays.asList(
                "...~~~~.........~~~...........",
                "...~~~~.......................",
                "...~~~........................",
                "..............................",
                ".............#####............",
                ".............#___#.......,...~",
                ".............#___#..........~~",
                ".............##_##.........~~~",
                ".................~~......,.~~~",
                "................~~~~.......~~~",
                ".............~~~~~~~........~~",
                "......~.....~~~~~~~~.........~",
                ".....~~~...~~~~~~~~~..........",
                ".....~~~~~~~~~~~~~~~~........~",
                ".....~~~~~~~~~~~~~~~~~~~....~~");

        List<String> factorySpaceshipParkingASCIIMap = Arrays.asList(
                ".......",
                ".#####.",
                ".#___#.",
                ".#___#.",
                ".##_##.",
                ".......",
                ".......",
                ".......",
                ".......",
                ".......");

        List<String> refactorioASCIIMap = Arrays.asList(
                "..........................~~~~",
                "..........................~~~~",
                "..........................~~~~",
                "~..........................~..",
                "~~...........#####............",
                "~~~..........#___#............",
                "~~~..........#___#............",
                "~~~..........##_##............",
                "~~~..................~~.......",
                "~~~~................~~~~......",
                "~~~~...............~~~~~......",
                "..~................~~~~.......",
                "....................~~........",
                ".............~~...............",
                "............~~~~..............");

        Polymorphia polymorphiaMap = new Polymorphia(groundFactory, polymorphiaASCIIMap);
        FactorySpaceshipParking factorySpaceshipParkingMap = new FactorySpaceshipParking(groundFactory, factorySpaceshipParkingASCIIMap);
        Refactorio refactorioMap = new Refactorio(groundFactory, refactorioASCIIMap);

        world.addGameMap(polymorphiaMap);
        world.addGameMap(factorySpaceshipParkingMap);
        world.addGameMap(refactorioMap);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        ComputerTerminal computerTerminal = new ComputerTerminal();
        computerTerminal.addToStock(new EnergyDrink());
        computerTerminal.addToStock(new DragonSlayerSword());
        computerTerminal.addToStock(new ToiletPaperRoll());
        computerTerminal.addToStock(new Theseus());
        computerTerminal.addToStock(new AIDevice());

        computerTerminal.addTravelDestination(polymorphiaMap);
        computerTerminal.addTravelDestination(factorySpaceshipParkingMap);
        computerTerminal.addTravelDestination(refactorioMap);

        polymorphiaMap.at(15,5).setGround(computerTerminal);
        factorySpaceshipParkingMap.at(3,2).setGround(computerTerminal);
        factorySpaceshipParkingMap.at(3,8).addActor(new HumanoidFigure()); // DO NOT CHANGE THIS, THIS ADDS THE HUMANOID FIGURE TO THE PARKING LOT
        refactorioMap.at(15,5).setGround(computerTerminal);

        polymorphiaMap.at(0,0).addActor(new HuntsmanSpider());
        polymorphiaMap.at(0,1).setGround(new Wall());
        polymorphiaMap.at(1,0).setGround(new Wall());
        polymorphiaMap.at(1,1).setGround(new Wall());


//        gameMap.at(0,0).addItem(new MetalSheet());
//        gameMap.at(1,1).addItem(new LargeBolt());
//
//        gameMap.at(8, 8).addActor(new HuntsmanSpider());
//        gameMap.at(1,3).addActor(new HuntsmanSpider());
//
//        gameMap.at(13,8).addItem(new MetalPipe());
//        gameMap.at(15,8).addItem(new JarOfPickles());
//        gameMap.at(15,7).addItem(new PotOfGold());
//        gameMap.at(15,7).addItem(new PotOfGold());
//
//        gameMap.at(10,8).setGround(new Crater(new SuspiciousAstronautSpawner()));

        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, polymorphiaMap.at(15, 6));

        player.addBalance(300);

        world.run();

        for (String line: FancyMessage.YOU_ARE_FIRED.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

