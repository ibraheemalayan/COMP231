package Lab7;

public class Tester {

    public static void main(String[] args) {

        Account empty_account = new Account();

        System.out.println("empty account : " + empty_account.toString() );

        empty_account.deposite(500);

        System.out.println("empty account : " + empty_account.toString() );

        empty_account.withdraw(2000);

        System.out.println("empty account : " + empty_account.toString() );

        Saving saving_ac = new Saving(23,200.43);

        System.out.println("\n\nsaving_ac : " + saving_ac.toString() );

        saving_ac.withdraw(100.83);

        System.out.println("saving_ac : " + saving_ac.toString() );

        saving_ac.withdraw(1000);

        Checking ch_ac = new Checking();

        System.out.println("\n\nch_ac : " + ch_ac.toString() );

        ch_ac.withdraw(900);

        System.out.println("ch_ac : " + ch_ac.toString() );

        ch_ac.withdraw(200);







    }
}
