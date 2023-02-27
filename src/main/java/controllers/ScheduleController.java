package controllers;

import classes.Artist;
import classes.Festival;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class ScheduleController {

    private ScheduleMakerController scheduleMakerController = new ScheduleMakerController();

    private ArrayList<Rectangle2D> blocksToDraw = new ArrayList<>();
    private ArrayList<String> artistNames = new ArrayList<>();
    private int xBlock = 0;
    private int yBlock = 0;

    @FXML
    public Canvas canvasSchedule;
    @FXML
    void onImportButton() {
        Festival festivalObject = null;

        try {                                           //try importing file, showing error when unsuccessfull
            festivalObject = Serializer.DeserializeFestival();
            NotificationPromptController.notification(false, "Successfully import festival file :)");
        } catch (Exception e) {
            NotificationPromptController.notification(true, "Unable to import festival file :(");
        }

        ArrayList<Artist> allArtists = festivalObject.getArtists();
//        System.out.println(allArtists.size());
        ArtistArrayListController.artists.addAll(allArtists);
//        scheduleMakerController.refreshList();
//        scheduleMakerController.setArtists(allArtists);
//        System.out.println(ArtistArrayListController.artists.size());
//        scheduleMakerController.artists.add
//        scheduleMakerController.updateListView();

        calculateBlockToDraw(allArtists);

        draw(new FXGraphics2D(canvasSchedule.getGraphicsContext2D()));
    }

    public void calculateBlockToDraw(ArrayList<Artist> allArtists) {

        String startTimeHours;
        String startTimeMinutes;

        for (Artist artist : allArtists) {

            if (artist.getPodium().equals("Main stage")) {
                xBlock = 0;
                yBlock = 0;

                startTimeHours = artist.getSetStartingTime();
                startTimeHours = startTimeHours.substring(0, 2);

                startTimeMinutes = artist.getSetStartingTime();
                startTimeMinutes = startTimeMinutes.substring(3,5);

                if (Integer.parseInt(startTimeHours) == 10) {
                    yBlock = 0;
                }
                else {
                    if (Integer.parseInt(startTimeHours) == 0 || Integer.parseInt(startTimeHours) == 1 || Integer.parseInt(startTimeHours) == 2 || Integer.parseInt(startTimeHours) == 3) {

                        if (Integer.parseInt(startTimeHours) == 0){
                            yBlock = 14*29;
                        }

                        if (Integer.parseInt(startTimeHours) == 1){
                            yBlock = 15*29;
                        }

                        if (Integer.parseInt(startTimeHours) == 2){
                            yBlock = 16*29;
                        }

                        if (Integer.parseInt(startTimeHours) == 3){
                            yBlock = 17*29;
                        }
                    }
                    else {
                        for (int i = 10; i < Integer.parseInt(startTimeHours); i++) {
                            yBlock += 29;
                        }
                    }
                }

                if (Integer.parseInt(startTimeMinutes) == 30){
                    yBlock += 14;
                }

                if (artist.getSetDurationInMinutes() == 30){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock + 1, yBlock, 98, 15));
                    artistNames.add(artist.getName());
                }

                if (artist.getSetDurationInMinutes() == 60){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock + 1, yBlock, 98, 30));
                    artistNames.add(artist.getName());
                }

                if (artist.getSetDurationInMinutes() == 90){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock + 1, yBlock, 98, 45));
                    artistNames.add(artist.getName());
                }

                if (artist.getSetDurationInMinutes() == 120){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock + 1, yBlock, 98, 60));
                    artistNames.add(artist.getName());
                }
            }

            if (artist.getPodium().equals("Stage 2")) {
                xBlock = 0;
                yBlock = 0;
                xBlock += 100;

                startTimeHours = artist.getSetStartingTime();
                startTimeHours = startTimeHours.substring(0, 2);

                startTimeMinutes = artist.getSetStartingTime();
                startTimeMinutes = startTimeMinutes.substring(3,5);

                if (Integer.parseInt(startTimeHours) == 10) {
                    yBlock = 0;
                }
                else {
                    if (Integer.parseInt(startTimeHours) == 0 || Integer.parseInt(startTimeHours) == 1 || Integer.parseInt(startTimeHours) == 2 || Integer.parseInt(startTimeHours) == 3) {

                        if (Integer.parseInt(startTimeHours) == 0){
                            yBlock = 14*29;
                        }

                        if (Integer.parseInt(startTimeHours) == 1){
                            yBlock = 15*29;
                        }

                        if (Integer.parseInt(startTimeHours) == 2){
                            yBlock = 16*29;
                        }

                        if (Integer.parseInt(startTimeHours) == 3){
                            yBlock = 17*29;
                        }
                    }
                    else {
                        for (int i = 10; i < Integer.parseInt(startTimeHours); i++) {
                            yBlock += 29;
                        }
                    }
                }

                if (Integer.parseInt(startTimeMinutes) == 30){
                    yBlock += 14;
                }

                if (artist.getSetDurationInMinutes() == 30){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock, yBlock, 100, 15));
                }

                if (artist.getSetDurationInMinutes() == 60){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock, yBlock, 100, 30));
                }

                if (artist.getSetDurationInMinutes() == 90){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock, yBlock, 100, 45));
                }

                if (artist.getSetDurationInMinutes() == 120){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock, yBlock, 100, 60));
                }
            }

            if (artist.getPodium().equals("Stage 3")) {
                xBlock = 0;
                yBlock = 0;
                xBlock += 200;

                startTimeHours = artist.getSetStartingTime();
                startTimeHours = startTimeHours.substring(0, 2);

                startTimeMinutes = artist.getSetStartingTime();
                startTimeMinutes = startTimeMinutes.substring(3,5);

                if (Integer.parseInt(startTimeHours) == 10) {
                    yBlock = 0;
                }
                else {
                    if (Integer.parseInt(startTimeHours) == 0 || Integer.parseInt(startTimeHours) == 1 || Integer.parseInt(startTimeHours) == 2 || Integer.parseInt(startTimeHours) == 3) {

                        if (Integer.parseInt(startTimeHours) == 0){
                            yBlock = 14*29;
                        }

                        if (Integer.parseInt(startTimeHours) == 1){
                            yBlock = 15*29;
                        }

                        if (Integer.parseInt(startTimeHours) == 2){
                            yBlock = 16*29;
                        }

                        if (Integer.parseInt(startTimeHours) == 3){
                            yBlock = 17*29;
                        }
                    }
                    else {
                        for (int i = 10; i < Integer.parseInt(startTimeHours); i++) {
                            yBlock += 29;
                        }
                    }
                }

                if (Integer.parseInt(startTimeMinutes) == 30){
                    yBlock += 14;
                }

                if (artist.getSetDurationInMinutes() == 30){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock, yBlock, 100, 15));
                }

                if (artist.getSetDurationInMinutes() == 60){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock, yBlock, 100, 30));
                }

                if (artist.getSetDurationInMinutes() == 90){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock, yBlock, 100, 45));
                }

                if (artist.getSetDurationInMinutes() == 120){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock, yBlock, 100, 60));
                }
            }

            if (artist.getPodium().equals("Stage 4")) {
                xBlock = 0;
                yBlock = 0;
                xBlock += 300;

                startTimeHours = artist.getSetStartingTime();
                startTimeHours = startTimeHours.substring(0, 2);

                startTimeMinutes = artist.getSetStartingTime();
                startTimeMinutes = startTimeMinutes.substring(3,5);

                if (Integer.parseInt(startTimeHours) == 10) {
                    yBlock = 0;
                }
                else {
                    if (Integer.parseInt(startTimeHours) == 0 || Integer.parseInt(startTimeHours) == 1 || Integer.parseInt(startTimeHours) == 2 || Integer.parseInt(startTimeHours) == 3) {

                        if (Integer.parseInt(startTimeHours) == 0){
                            yBlock = 14*29;
                        }

                        if (Integer.parseInt(startTimeHours) == 1){
                            yBlock = 15*29;
                        }

                        if (Integer.parseInt(startTimeHours) == 2){
                            yBlock = 16*29;
                        }

                        if (Integer.parseInt(startTimeHours) == 3){
                            yBlock = 17*29;
                        }
                    }
                    else {
                        for (int i = 10; i < Integer.parseInt(startTimeHours); i++) {
                            yBlock += 29;
                        }
                    }
                }

                if (Integer.parseInt(startTimeMinutes) == 30){
                    yBlock += 14;
                }

                if (artist.getSetDurationInMinutes() == 30){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock, yBlock, 98, 15));
                }

                if (artist.getSetDurationInMinutes() == 60){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock, yBlock, 98, 30));
                }

                if (artist.getSetDurationInMinutes() == 90){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock, yBlock, 98, 45));
                }

                if (artist.getSetDurationInMinutes() == 120){
                    blocksToDraw.add(new Rectangle2D.Double(xBlock, yBlock, 98, 60));
                }
            }
        }
    }

    public void draw(FXGraphics2D graphics) {

        graphics.setStroke(new BasicStroke(2));

        Color[] colors = {Color.red, Color.blue, Color.GREEN, Color.YELLOW};

        int i = 0;

        for (Rectangle2D block : blocksToDraw) {

            graphics.setPaint(colors[i]);
            graphics.fill(block);
            if (i == 0 || i == 1) {
                graphics.setPaint(Color.white);
            } else {
                graphics.setPaint(Color.black);
            }
            graphics.drawString(artistNames.get(blocksToDraw.indexOf(block)), (int) block.getX(), ((int) block.getY() + 10));
            i++;

            if (i == 4){
                i = 0;
            }
        }
    }
}
