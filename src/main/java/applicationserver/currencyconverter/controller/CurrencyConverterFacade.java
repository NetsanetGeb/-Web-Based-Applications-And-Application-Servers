
package applicationserver.currencyconverter.controller;

import applicationserver.currencyconverter.integration.CurrencyDAO;
import applicationserver.currencyconverter.model.Currency;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class CurrencyConverterFacade implements Serializable {

     @EJB private CurrencyDAO currencyDAO;

    public CurrencyConverterFacade() {
    }

    public double convert(double fromAmount, String fromCurrency, String toCurrency) {
        double fromRate = 0;
        double toRate = 0;

        for (Currency currency : listCurrencies()) {
            if (currency.getName().equals(fromCurrency)) {
                fromRate = currency.getRate();
            }
            if (currency.getName().equals(toCurrency)) {
                toRate = currency.getRate();
            }
        }

        return fromAmount * (fromRate / toRate);
    }

    
     public List<Currency> listCurrencies() {
          return currencyDAO.listCurrencies();
     }
}
