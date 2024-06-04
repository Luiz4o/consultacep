/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consultacep;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author henri
 */
public class Validador {

    public boolean validaCep(String cep) {
            Pattern pattern = Pattern.compile("[0-9]{8}");
            Matcher matcher = pattern.matcher(cep);
            boolean matchFound = matcher.find();
            if (matchFound) {
                return true;
            } else {
                return false;
            }
        }
    
    public boolean validaErro(String body){
        Pattern pattern = Pattern.compile("erro",Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(body);
            boolean matchFound = matcher.find();
            if (matchFound) {
                return false;
            } else {
                return true;
            }
    }
    }
    
