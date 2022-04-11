package valid;

import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class ValidacaoDocumento {

    public static void main(String[] args) {
        // Validação de CPF
        CPF cpf = new CPF("86288366767");
        CPFValidator cpfValidator = new CPFValidator();

        try{
            cpfValidator.assertValid(cpf.getNumero());
            System.out.println("CPF válido");

        }catch (InvalidStateException ex){
            System.out.println("CPF inválido: " + cpf.getNumeroFormatado() + ". ERRO: " + ex);
        }

        //validação de CNPJ
        CNPJ cnpj = new CNPJ("78.284.376/0001-62");
        CNPJValidator cnpjValidator = new CNPJValidator();
        try{
            cnpjValidator.assertValid(cnpj.getNumero());
            System.out.println("CNPJ válido");

        }catch (InvalidStateException ex){
            System.out.println("CNPJ inválido: " + cnpj.getNumeroFormatado() + ". ERRO: " + ex);
        }

    }
}
