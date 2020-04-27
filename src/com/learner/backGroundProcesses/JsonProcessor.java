package com.learner.backGroundProcesses;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learner.backGroundProcesses.jsonData.CurrencyEurUsd;
import com.learner.backGroundProcesses.jsonData.CurrencyGbpChf;
import com.learner.backGroundProcesses.jsonData.DowJones;
import com.learner.backGroundProcesses.jsonData.TradePair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class JsonProcessor {
    private TradePair btcPair;
    private CurrencyEurUsd currencyEurUsd;
    private CurrencyGbpChf currencyGbpChf;
    private DowJones dowJones;


    private double beforeBTC = 0;
    private double beforeUSD = 0;
    private double beforeEUR = 0;
    private double beforeCHF = 0;
    private double beforeGBP = 0;
    private double beforeDOW = 0;

    public void process(TypeOfMoney typeOfMoney, String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            switch (typeOfMoney) {
                case BTC:
                    btcPair = mapper.readValue(getJsonData(fileName), TradePair.class);
                    break;
                case HUF_USD_EUR:
                    currencyEurUsd = mapper.readValue(getJsonData(fileName), CurrencyEurUsd.class);
                    break;
                case DOW:
                    dowJones = mapper.readValue(getJsonData(fileName), DowJones.class);
                    break;
                case HUF_GBP_CHF:
                    currencyGbpChf = mapper.readValue(getJsonData(fileName), CurrencyGbpChf.class);
                    break;
            }





        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void showData() {
        String base = btcPair.getData().getBase();
        String btcToCurrency = btcPair.getData().getCurrency();
        double amount = btcPair.getData().getAmount();

        double usdHuf = currencyEurUsd.getUsd_huf();
        double eurHuf = currencyEurUsd.getEur_huf();
        double gbpHuf = currencyGbpChf.getGbp_huf();
        double chfHuf = currencyGbpChf.getChf_huf();

        System.out.println(new Date());
        System.out.println();
        System.out.print(base + ": " + amount + " " + btcToCurrency);
        differenceFromBefore(beforeBTC, amount);
        beforeBTC = amount;
        System.out.print(dowJones.getIndexName() + ": " + dowJones.getPrice() + " USD");
        differenceFromBefore(beforeDOW, dowJones.getPrice());
        beforeDOW = dowJones.getPrice();
        System.out.print("USD: " + usdHuf);
        differenceFromBefore(beforeUSD, usdHuf);
        beforeUSD = usdHuf;
        System.out.print("EUR: " + eurHuf);
        differenceFromBefore(beforeEUR, eurHuf);
        beforeEUR = eurHuf;
        System.out.print("GBP: " + gbpHuf);
        differenceFromBefore(beforeGBP, gbpHuf);
        beforeGBP = gbpHuf;
        System.out.print("CHF: " + chfHuf);
        differenceFromBefore(beforeCHF, chfHuf);
        beforeCHF = chfHuf;

    }

    private void differenceFromBefore(double beforeAmount, double currentAmount) {
        if (beforeAmount != 0) {
            if (beforeAmount > currentAmount) {
                System.out.print(" - " + (int)(beforeAmount - currentAmount));
            } else if (beforeAmount < currentAmount) {
                System.out.print(" + " + (int)(currentAmount - beforeAmount));
            }
        }
        System.out.println();
    }

    public byte[] getJsonData(String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(fileName));
    }




    public double getBTCPrice() {
        return btcPair.getData().getAmount();
    }

    public double getDOWPrice() {
        return dowJones.getPrice();
    }

    public double getHUFUSDPrice() {
        return currencyEurUsd.getUsd_huf();
    }

    public double getHUFEURPrice() {
        return currencyEurUsd.getUsd_huf();
    }



}
