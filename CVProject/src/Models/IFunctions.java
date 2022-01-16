
package Models;

import java.util.ArrayList;

/**
 *
 * @author dicle
 */
public interface IFunctions {
    ArrayList<IsIlani> isIlaniGetir();
    void isIlaniGuncelle(IsIlani isIlani);
    void isIlaniSil(int id);
    void isIlaniEkle(String departman,String pozisyon,String konum);
}
