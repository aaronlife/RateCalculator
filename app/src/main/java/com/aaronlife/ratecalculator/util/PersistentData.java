package com.aaronlife.ratecalculator.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PersistentData
{
    public static final String BASE_CURRENCY = "BASECURRENCY";
    public static final String UPDATE_TIME = "UPDATETIME";

    SharedPreferences sp;

    public PersistentData(Activity activity)
    {
        this.sp = activity.getPreferences(Context.MODE_PRIVATE);
    }

    public boolean isNeedUpdate()
    {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy/MM/dd");
        String nowTime = sdf.format(Calendar.getInstance().getTime());

        if(!loadUpdateTime().substring(0, 10).equals(nowTime)) return true;

        if(sp.getFloat(RateData.MYR, 0.0F) == 0) return true;

        return false;
    }

    public void saveBaseCurrency(String baseCurrency)
    {
        sp.edit().putString(BASE_CURRENCY, baseCurrency).apply();
    }

    public String loadBaseCurrency()
    {
        return sp.getString(BASE_CURRENCY, RateData.TWD);
    }

    public void saveUpdateTime(String strUpdateTime)
    {
        sp.edit().putString(UPDATE_TIME, strUpdateTime).apply();
    }

    public String loadUpdateTime()
    {
        return sp.getString(UPDATE_TIME, "無");
    }

    public void saveExchangeRateDataTWD(RateData rateDataTWD)
    {
        sp.edit().putFloat(RateData.USD, rateDataTWD.usd)
                 .putFloat(RateData.EUR, rateDataTWD.eur)
                 .putFloat(RateData.JPY, rateDataTWD.jpy)
                 .putFloat(RateData.KRW, rateDataTWD.krw)
                 .putFloat(RateData.HKD, rateDataTWD.hkd)
                 .putFloat(RateData.TWD, rateDataTWD.twd)
                 .putFloat(RateData.IDR, rateDataTWD.idr)
                 .putFloat(RateData.CNY, rateDataTWD.cny)

                 .putFloat(RateData.GBP, rateDataTWD.gbp)
                 .putFloat(RateData.AUD, rateDataTWD.aud)
                 .putFloat(RateData.CAD, rateDataTWD.cad)
                 .putFloat(RateData.SGD, rateDataTWD.sgd)
                 .putFloat(RateData.CHF, rateDataTWD.chf)
                 .putFloat(RateData.ZAR, rateDataTWD.zar)
                 .putFloat(RateData.SEK, rateDataTWD.sek)
                 .putFloat(RateData.NZD, rateDataTWD.nzd)
                 .putFloat(RateData.THB, rateDataTWD.thb)
                 .putFloat(RateData.PHP, rateDataTWD.php)
                 .putFloat(RateData.VND, rateDataTWD.vnd)
                 .putFloat(RateData.MYR, rateDataTWD.myr)
                 .apply();
    }

    public RateData loadExchangeRateDataTWD()
    {
        RateData rateDataTWD = new RateData();

        rateDataTWD.usd = sp.getFloat(RateData.USD, 31.54F);
        rateDataTWD.eur = sp.getFloat(RateData.EUR, 35.63F);
        rateDataTWD.jpy = sp.getFloat(RateData.JPY, 0.311F);
        rateDataTWD.krw = sp.getFloat(RateData.KRW, 0.03068F);
        rateDataTWD.hkd = sp.getFloat(RateData.HKD, 4.088F);
        rateDataTWD.twd = sp.getFloat(RateData.TWD, 1.0F);
        rateDataTWD.idr = sp.getFloat(RateData.IDR, 0.00278F);
        rateDataTWD.cny = sp.getFloat(RateData.CNY, 4.758F);

        rateDataTWD.gbp = sp.getFloat(RateData.GBP, 41.67F);
        rateDataTWD.aud = sp.getFloat(RateData.AUD, 24.4F);
        rateDataTWD.cad = sp.getFloat(RateData.CAD, 24.32F);
        rateDataTWD.sgd = sp.getFloat(RateData.SGD, 23.27F);
        rateDataTWD.chf = sp.getFloat(RateData.CHF, 32.66F);
        rateDataTWD.zar = sp.getFloat(RateData.ZAR, 2.33F);
        rateDataTWD.sek = sp.getFloat(RateData.SEK, 3.78F);
        rateDataTWD.nzd = sp.getFloat(RateData.NZD, 23.09F);
        rateDataTWD.thb = sp.getFloat(RateData.THB, 0.944F);
        rateDataTWD.php = sp.getFloat(RateData.PHP, 0.732F);
        rateDataTWD.vnd = sp.getFloat(RateData.VND, 0.00153F);
        rateDataTWD.myr = sp.getFloat(RateData.MYR, 8.138F);

        return rateDataTWD;
    }
}