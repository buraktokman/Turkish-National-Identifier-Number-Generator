/**
 * Created by Admin on 23.11.2016.
 */
public class Source {
    public static void main(String[] args) {

        TNI test = new TNI();
        Boolean status = false;
        while (!status){
        String no = TNI.getSaltString();
        status = test.checkNumber(no);
        System.out.println(status + " : " + no);
        }

    }
}
