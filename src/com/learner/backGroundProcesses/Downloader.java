package com.learner.backGroundProcesses;

import com.learner.backGroundProcesses.jsonData.ApiKeyStore;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;


public class Downloader {

    private final static String downloadBTC = "https://api.coinbase.com/v2/prices/spot?currency=USD";
    private final static String downloadHufUsdEur = "https://free.currconv.com/api/v7/convert?q=USD_HUF,EUR_HUF&compact=ultra&apiKey=" + ApiKeyStore.getCurrconvKey();
    private final static String downloadHufGbpChf = "https://free.currconv.com/api/v7/convert?q=GBP_HUF,CHF_HUF&compact=ultra&apiKey=" + ApiKeyStore.getCurrconvKey();
    private final static String downloadDOW = "https://financialmodelingprep.com/api/v3/majors-indexes/.DJI";


    public void download(TypeOfMoney typeOfMoney, String fileNameToStoreDownload) {
        switch (typeOfMoney) {
            case BTC:
                innerDownload(downloadBTC, fileNameToStoreDownload);
                break;
            case DOW:
                innerDownload(downloadDOW, fileNameToStoreDownload);
                break;
            case HUF_USD_EUR:
                innerDownload(downloadHufUsdEur, fileNameToStoreDownload);
                break;
            case HUF_GBP_CHF:
                innerDownload(downloadHufGbpChf, fileNameToStoreDownload);
        }

    }

    private void innerDownload(String downloadLink, String fileName) {
        try (
                BufferedInputStream in = new BufferedInputStream(new URL(downloadLink).openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {

        }

    }
}
