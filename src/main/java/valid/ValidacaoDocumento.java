package valid;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class ValidacaoDocumento {

    public static void main(String[] args) {
        String cpf = "86288366767";
        CPFValidator cpfValidator = new CPFValidator();

        try{
            cpfValidator.assertValid(cpf);
            System.out.println("CPF válido");

        }catch (InvalidStateException ex){
            System.out.println("CPF inválido: " + cpf + " é invalido! mensagem " + ex);
        }

    }
}
