import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    Window window;

    private long totalClicks = 0;
    private int clickAmount = 1;
    private int clickUpgradePrice = 10;
    private int autoClickAmount = 5;
    private int autoClickUpgradePrice = 100;
    private int clickFactoryAmount = 500;
    private int clickFactoryPrice = 10000;
    private int superClickerAmount = 10000;
    private int superClickerPrice = 100000;

    Timer autoTimer;
    Timer factoryTimer;
    Timer superTimer;

    public Game(Window gameWindow) {

        this.window = gameWindow;
        window.getLabel().setText("Clicks: " + totalClicks);
        initButtons();
    }

    private void initButtons() {

        window.getClickerButton().setActionCommand("Click");
        window.getClickerButton().addActionListener(e -> clickHandler(e));
        window.getPurchase().setActionCommand("UpgradeClick");
        window.getPurchase().addActionListener(e -> clickHandler(e));
        window.getAutoClick().setActionCommand("UpgradeAuto");
        window.getAutoClick().addActionListener(e -> clickHandler(e));
        window.getClickFactory().setActionCommand("ClickFactory");
        window.getClickFactory().addActionListener(e -> clickHandler(e));
        window.getSuperClicker().setActionCommand("SuperClicker");
        window.getSuperClicker().addActionListener(e -> clickHandler(e));

    }

    // Handles all clicking actions.
    private void clickHandler(ActionEvent event) {

        String action = event.getActionCommand();

        switch (action) {

            case "Click":
                totalClicks += clickAmount;
                window.getLabel().setText("Clicks: " + totalClicks);
                break;
            case "UpgradeClick":
                if (totalClicks >= clickUpgradePrice) {
                    totalClicks -= clickUpgradePrice;
                    clickUpgradePrice *= 2;
                    clickAmount *= 2;
                    window.getPurchase().setText("Multiply Clicks by 2: Cost " + clickUpgradePrice + " clicks");
                    window.getLabel().setText("Clicks: " + totalClicks);

                }
                break;
            case "UpgradeAuto":
                if(totalClicks >= autoClickUpgradePrice) {

                    totalClicks -= autoClickUpgradePrice;
                    window.getLabel().setText("Clicks: " + totalClicks);

                    if(autoClickUpgradePrice != 100){
                        autoClickAmount *= 2;
                    }

                    if(autoClickUpgradePrice == 100){
                        autoClicker();
                        autoTimer.start();
                    }else{
                        autoClicker();
                    }

                    autoClickUpgradePrice *= 3;
                    window.getAutoClick().setText("Multiply Auto Clicker by 2: Cost " + autoClickUpgradePrice + " Clicks!");
                }
                break;
            case "ClickFactory":
                if(totalClicks >= clickFactoryPrice){

                    totalClicks -= clickFactoryPrice;
                    window.getLabel().setText("Clicks: " + totalClicks);

                    if(clickFactoryPrice != 10000){
                        clickFactoryAmount *= 2;
                    }


                    if(clickFactoryPrice == 10000){
                        clickFactory();
                        factoryTimer.start();
                    }else{
                        clickFactory();
                    }

                    clickFactoryPrice *= 3;
                    window.getClickFactory().setText("Multiply Click Factory by 2: Cost " + clickFactoryPrice + " Clicks");
                }
                break;
            case "SuperClicker":
                if(totalClicks >= superClickerPrice){

                    totalClicks -= superClickerPrice;
                    window.getLabel().setText("Clicks: " + totalClicks);

                    if(superClickerPrice != 100000){
                        superClickerAmount *= 1000;
                    }

                    if(superClickerPrice == 100000){
                        superClicker();
                        superTimer.start();

                    }else{
                        superClicker();
                    }

                    superClickerPrice *= 10;
                    window.getSuperClicker().setText("Multiply Super Clicker by 2: Cost " + superClickerPrice + " Clicks");
                }
                break;
        }

    }

    // All methods for automated clicking.

    private void autoClicker() {

        autoTimer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                totalClicks += autoClickAmount;
                window.getLabel().setText("Clicks: " + totalClicks);

            }
        });
    }

    private void clickFactory() {

        factoryTimer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                totalClicks += clickFactoryAmount;
                window.getLabel().setText("Clicks: " + totalClicks);

            }
        });

    }

    private void superClicker() {

        superTimer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                totalClicks += superClickerAmount;
                window.getLabel().setText("Clicks: " + totalClicks);

            }
        });

    }
}





