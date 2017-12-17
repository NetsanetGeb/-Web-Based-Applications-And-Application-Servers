/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationserver.currencyconverter.view;


import applicationserver.currencyconverter.controller.CurrencyConverterFacade;
import applicationserver.currencyconverter.model.Currency;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@Named(value = "converterManager")
@ManagedBean
public class ConverterManager implements Serializable {

    @EJB
    private CurrencyConverterFacade currencyConverterFacade;

    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double convertedAmount = -1;

    public ConverterManager() {
    }

    public void convert() {
        convertedAmount = currencyConverterFacade.convert(amount, fromCurrency, toCurrency);
    }

    public List<Currency> getCurrencies() {
        return currencyConverterFacade.listCurrencies();
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

}
