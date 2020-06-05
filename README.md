A little forever looped console program to check "realtime" (as far as free providers do realtime data updates) exchange rates for what am I interested, without checking 3 different website. Use at your own responsibility, sometimes there are delays in prices, so if you are trading actively don't use this, it is for only information purpose to check the prices approximately.

The program updates the prices in 72 seconds (to do not interfere any api request limitations). For the currencies (USD-EUR-GBP-CHF-HUF) you will need an API key what could be requested for free from the API provider (free.currconv.com), I'm not providing that (I stored it into the ApiKeyStore class).
For the Dow Jones and BTC price it using API-s what available publicly without a key. (api.coinbase.com and financialmodelingprep.com).

The program checks:
BTC price in USD,
Dow Jones index price in USD,
USD price in HUF,
EUR price in HUF,
GBP price in HUF,
CHF price in HUF
