package valid;

import com.github.gilbertotorrezan.viacep.gwt.ViaCEPGWTClient;
import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.io.IOException;
import java.lang.annotation.Inherited;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CEP {

    public static void main(String[] args) {
        ViaCEPClient cliente = new ViaCEPClient();
        try {
            ViaCEPEndereco endereco = cliente.getEndereco("04547004");
            System.out.println(endereco.getLogradouro());
            System.out.println(endereco.getLocalidade());
            System.out.println(endereco.getBairro());
            System.out.println(endereco.getUf());
            System.out.println(endereco.getComplemento());
            System.out.println(endereco.getIbge());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<ViaCEPEndereco> enderecos = cliente.getEnderecos("SP", "Campinas", "Rua das violetas");
            enderecos.forEach(e -> {
                System.out.println(e.getIbge() + " " + e.getLocalidade() + " " + e.getComplemento());
                System.out.println("---");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
