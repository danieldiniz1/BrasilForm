package valid;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.InteiroSemFormato;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

import java.math.BigDecimal;
import java.util.Locale;

public class NumeroPorExtenso {

    public static void main(String[] args) {
        NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());
        BigDecimal valor = BigDecimal.valueOf(75.23);
        String valorPorExtenso = conversor.toWords(valor.doubleValue());
        System.out.println(valorPorExtenso.toUpperCase(new Locale("pt")));
    }
}
