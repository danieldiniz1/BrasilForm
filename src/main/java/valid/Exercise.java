package valid;

import br.com.caelum.stella.tinytype.CPF;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryOperators;

import javax.money.Monetary;
import javax.money.MonetaryAmount;

public class Exercise {

    public static void main(String[] args) {
        CPF cpf = new CPF("51720155242");
        MonetaryAmount faturaCartao = Money.of(900, Monetary.getCurrency("BRL"));
        MonetaryAmount pagamentoMinimo = faturaCartao.with(MonetaryOperators.percent(15));

        try {
            validaDocumentos(new CPFValidator(),cpf.getNumero());
            System.out.println("sua fatura do cartão venceu no valor de R$ " + faturaCartao.getNumber().toString() + " " +
                    "e o pagamento mínimo é de R$ " + pagamentoMinimo + "." );

        } catch (InvalidStateException ex){
            System.out.println("O CPF de número: " + cpf.toString() + "é inválido, favor atualizar cadastro!");
        }
    }

    private static void validaDocumentos(Validator<String> validator, String documento){
        validator.assertValid(documento);
    }
}
