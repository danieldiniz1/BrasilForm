package valid;

import br.com.caelum.stella.format.TituloEleitoralFormatter;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;
import br.com.caelum.stella.validation.*;

public class ValidacaoDocumento {

    public static void main(String[] args) {
        // Validação de CPF
        CPF cpf = new CPF("86288366757");

        try{
            validarDocumentos(new CPFValidator(), cpf.getNumero());
            System.out.println("CPF válido");

        }catch (InvalidStateException ex){
            System.out.println("CPF inválido: " + cpf.getNumeroFormatado() + ". ERRO: " + ex);
        }

        //validação de CNPJ
        CNPJ cnpj = new CNPJ("78.284.376/0001-62");
        try{
            validarDocumentos(new CNPJValidator(),cnpj.getNumero());
            System.out.println("CNPJ válido");

        }catch (InvalidStateException ex){
            System.out.println("CNPJ inválido: " + cnpj.getNumeroFormatado() + ". ERRO: " + ex);
        }

        //validação de Título de eleitor
        String tituloDeEleitor = "146512320140";

        try{
            validarDocumentos(new TituloEleitoralValidator(),tituloDeEleitor);
            System.out.println("Titulo de eleitor válido");

        }catch (InvalidStateException ex){
            System.out.println("Titulo de eleitor inválido: " + tituloDeEleitor + ". ERRO: " + ex);
        }

    }

    private static void validarDocumentos(Validator<String> validator, String documento){
        validator.assertValid(documento);
    }
}
