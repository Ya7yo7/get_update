package com.gp.currencyexchange;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CurrencyService {
    // Map to store currency information based on currency code
    private final Map<String, CurrencyInfo> currencyInfoMap = Map.ofEntries(
            Map.entry("USD", new CurrencyInfo("US Dollar", "https://cdn.britannica.com/79/4479-050-6EF87027/flag-Stars-and-Stripes-May-1-1795.jpg")),
            Map.entry("EUR", new CurrencyInfo("Euro", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b7/Flag_of_Europe.svg/2560px-Flag_of_Europe.svg.png")),
            Map.entry("GBP", new CurrencyInfo("Sterling Pound", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Flag_of_the_United_Kingdom_%283-5%29.svg/1280px-Flag_of_the_United_Kingdom_%283-5%29.svg.png")),
            Map.entry("AED", new CurrencyInfo("UAE Dirham", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_United_Arab_Emirates.svg/1280px-Flag_of_the_United_Arab_Emirates.svg.png")),
            Map.entry("BHD", new CurrencyInfo("Bahrain Dinar", "https://cdn.britannica.com/67/5767-004-E0FF7201/Flag-Bahrain.jpg")),
            Map.entry("JPY", new CurrencyInfo("Japan Yen", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Flag_of_Japan.svg/1280px-Flag_of_Japan.svg.png")),
            Map.entry("KWD", new CurrencyInfo("Kuwait Dinar", "https://cdn.britannica.com/70/5770-004-A99DD01D/Flag-Kuwait.jpg")),
            Map.entry("OMR", new CurrencyInfo("Oman Riyal", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Flag_of_Oman.svg/800px-Flag_of_Oman.svg.png?20230424003038")),
            Map.entry("QAR", new CurrencyInfo("Qatari Riyal", "https://t3.ftcdn.net/jpg/01/07/55/26/360_F_107552619_a171Nedp416hbFa7p2ETRxhDa1ZGGAGh.jpg")),
            Map.entry("SAR", new CurrencyInfo("Saudi Riyal", "https://cdn.britannica.com/79/5779-050-46C999AF/Flag-Saudi-Arabia.jpg")),
            Map.entry("EGP", new CurrencyInfo("Egyptian Pound", "https://cdn.britannica.com/85/185-004-1EA59040/Flag-Egypt.jpg"))
            // Add more entries for other currencies as needed
    );

    private String getCurrencyName(String currencyCode) {
        CurrencyInfo currencyInfo = currencyInfoMap.get(currencyCode);
        return currencyInfo != null ? currencyInfo.getName() : "Unknown Currency";
    }

    private String getFlagUrl(String currencyCode) {
        CurrencyInfo currencyInfo = currencyInfoMap.get(currencyCode);
        return currencyInfo != null ? currencyInfo.getFlagUrl() : "Unknown Flag URL";
    }

    public List<Currency> getCurrencies() {
        return currencyInfoMap.keySet().stream()
                .map(currencyCode -> {
                    Currency currency = new Currency();
                    currency.setCode(currencyCode);
                    currency.setName(getCurrencyName(currencyCode));
                    currency.setFlagUrl(getFlagUrl(currencyCode));
                    return currency;
                })
                .collect(Collectors.toList());
    }
}

class CurrencyInfo {
    private String name;
    private String flagUrl;

    public CurrencyInfo(String name, String flagUrl) {
        this.name = name;
        this.flagUrl = flagUrl;
    }

    public String getName() {
        return name;
    }

    public String getFlagUrl() {
        return flagUrl;
    }
}
