
package applicationserver.currencyconverter.integration;

import applicationserver.currencyconverter.model.Currency;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class CurrencyDAO {

    @PersistenceContext(unitName = "CurrencyConverterPU")
    private EntityManager em;
    
     public List<Currency> listCurrencies() {
        Query query = em.createQuery("SELECT c FROM Currency c", Currency.class);
        List<Currency> currenciesFromDB = query.getResultList();
       
        if (currenciesFromDB == null || currenciesFromDB.isEmpty()) {
            em.persist(new Currency("SEK", 1.0));
            em.persist(new Currency("USD", 8.3));
            em.persist(new Currency("EUR", 10.0));
            em.persist(new Currency("GBP", 11.3));
            em.persist(new Currency("ETB", 0.3));
            currenciesFromDB = query.getResultList();
        }

        return currenciesFromDB;
    }
    
}
