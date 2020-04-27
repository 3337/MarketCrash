package com.learner;

import com.learner.backGroundProcesses.Downloader;
import com.learner.backGroundProcesses.JsonProcessor;
import com.learner.backGroundProcesses.TypeOfMoney;

public class Main {

    private final static String FILENAME_BTC = "btc.json";
    private final static String FILENAME_HUF_USD_EUR = "hufusdeur.json";
    private final static String FILENAME_HUF_GBP_CHF = "hufgpbchf.json";
    private final static String FILENAME_DOW = "dow.json";

    public static void main(String[] args) {
        Downloader downloader = new Downloader();
        JsonProcessor jsonProcessor = new JsonProcessor();

        while (true) {

            downloader.download(TypeOfMoney.BTC, FILENAME_BTC);
            downloader.download(TypeOfMoney.HUF_USD_EUR, FILENAME_HUF_USD_EUR);
            downloader.download(TypeOfMoney.DOW, FILENAME_DOW);
            downloader.download(TypeOfMoney.HUF_GBP_CHF, FILENAME_HUF_GBP_CHF);

            jsonProcessor.process(TypeOfMoney.BTC, FILENAME_BTC);
            jsonProcessor.process(TypeOfMoney.HUF_USD_EUR, FILENAME_HUF_USD_EUR);
            jsonProcessor.process(TypeOfMoney.DOW, FILENAME_DOW);
            jsonProcessor.process(TypeOfMoney.HUF_GBP_CHF, FILENAME_HUF_GBP_CHF);

            jsonProcessor.showData();
            System.out.println("*******************");
            try {
                Thread.sleep(72000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

}
