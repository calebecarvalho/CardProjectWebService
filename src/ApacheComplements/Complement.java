package ApacheComplements;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
/**
 * Created by CalebeLustosa on 08/12/2016.
 */
public class Complement {

    public String normaliza (String CPF) {
        String nrml = CPF;
        while (nrml.indexOf("-") != -1) {
            if (nrml.indexOf("-") != 0) {
                nrml = nrml.substring(0, nrml.indexOf("-")) +
                        nrml.substring(nrml.indexOf("-") + 1);
            } else {
                nrml = nrml.substring(nrml.indexOf("-") + 1);
            }
        }
        while (nrml.indexOf(".") != -1) {
            if (nrml.indexOf(".") != 0) {
                nrml = nrml.substring(0, nrml.indexOf(".")) +
                        nrml.substring(nrml.indexOf(".") + 1);
            } else {
                nrml = nrml.substring(nrml.indexOf(".") + 1);
            }
        }
        return nrml;
    }
}