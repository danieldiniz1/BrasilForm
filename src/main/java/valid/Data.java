package valid;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Locale;

public class Data {

    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        Calendar instance = Calendar.getInstance();
        System.out.println(hoje + " ----- " + instance.getTime());

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        System.out.println(hoje.format(formatador));

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatadorComHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

        System.out.println(agora.format(formatadorComHora));
        System.out.println(agora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("pt","br"))));


        System.out.println(agora.minusHours(5));


    }
}
