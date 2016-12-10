package ApacheComplements;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
/**
 * Created by CalebeLustosa on 10/12/2016.
 */
public class Complement {
    public String normalizaCPF (String CPF){
        String nrml = CPF;
        while(nrml.indexOf("-") != -1){
            if (nrml.indexOf("-") != 0){
                nrml = nrml.substring(0, nrml.indexOf("-"))+
                        nrml.substring(nrml.indexOf("-")+1);
            }else{
                nrml = nrml.substring(nrml.indexOf("-")+1);
            }
        }
        while (nrml.indexOf(".") != -1) {
            if (nrml.indexOf(".") != 0) {
                nrml = nrml.substring(0, nrml.indexOf(".")) +
                        nrml.substring(nrml.indexOf(".") + 1);
            }
            else {
                nrml = nrml.substring(nrml.indexOf(".") + 1);
            }
        }
        return nrml;
    }
    public static Date normalizaData(String data) throws Exception {
        if (data == null || data.equals(""))
            return null;
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.sql.Date)formatter.parse(data);
        } catch (ParseException E) {
            throw E;
        }
        return date;
    }
}