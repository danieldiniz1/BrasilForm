package valid;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.convert.ExchangeRateType;
import org.javamoney.moneta.function.MonetaryOperators;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;
import java.math.BigDecimal;
import java.util.List;

public class Dinheiro {

    public static void main(String[] args) {
        CurrencyUnit real = Monetary.getCurrency("BRL");
        CurrencyUnit dolar = Monetary.getCurrency("USD");
        MonetaryAmount valorDaParcela = Money.of(75,real);
        System.out.println(valorDaParcela);

        MonetaryAmount valorTotal = valorDaParcela.multiply(12);
        MonetaryAmount discount = valorTotal.with(MonetaryOperators.percent(10));
        System.out.println(valorTotal.getNumber());
        System.out.println(discount);

        MonetaryAmount valorProdutoDolar = FastMoney.of(90, dolar);
        MonetaryAmount valorImpostoReal = FastMoney.of(30, real);

        MonetaryAmount impostoConvertido = conversorDeValor(BigDecimal.valueOf(valorImpostoReal.getNumber().doubleValue()), real.getCurrencyCode(), dolar.getCurrencyCode());
        System.out.println(valorProdutoDolar.add(impostoConvertido));
    }

    private static MonetaryAmount conversorDeValor(BigDecimal valor, String moeda1, String moeda2){
        // pegar o valor e as moedas para conversao;
        CurrencyUnit moedaLocal = Monetary.getCurrency(moeda1);
        CurrencyUnit moedaConversao = Monetary.getCurrency(moeda2);
        MonetaryAmount valorDaConversao = FastMoney.of(valor,moedaLocal);

        //Instancia do provedor de informações de rate;
        ExchangeRateProvider exchangeRateProvider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.ECB);

        //Pegar a conversão do dia;
        CurrencyConversion currencyConversion = exchangeRateProvider.getCurrencyConversion(moedaConversao);

        //Transformando o valor do imposto com o rate atual e devolvendo para o método o resultado;
        MonetaryAmount valorAtualizado = currencyConversion.apply(valorDaConversao);
        return valorAtualizado;
    }

}
