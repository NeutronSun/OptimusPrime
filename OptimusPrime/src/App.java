import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.math.*;

public class App {

	public static void main(String[] args) {
		BigInteger n = new  BigInteger("10");
		int cont = 0;
		Scanner in = new Scanner(System.in);
		

		try{
			
			System.out.println("Choose the algorithm");
			System.out.println("|1: Really slow\n|2: not so much slow\n|3:Fermats");
			int choice, digits = 0;
			do{
				choice = in.nextInt();
			}while(choice > 3 || choice < 1);
			System.out.print("Choose the number of digits: ");
			digits = in.nextInt();
			n = n.pow(digits);
			FileWriter c = new FileWriter(digits + "digitsPrimeNumber.txt", false);
			System.out.println("how many number would you like to find?");
			int nToFind = in.nextInt();
			if(n.mod(BigInteger.TWO).equals(BigInteger.ZERO))
			 n=n.add(BigInteger.ONE);
			GuiData g = new GuiData(nToFind);
			g.inizializeFrame();
			for(BigInteger i = n; cont < nToFind; i = i.add(BigInteger.valueOf(2))){
				
				if(choice == 1 && slowOne(i)){
					c.write(i.toString() + "\n");
					cont++;
					System.out.println((nToFind-cont) + " numbers left");
					g.updateLoadingBar(cont);
				}
				
				if(choice == 2 && slowThree(i)){
					c.write(i.toString() + "\n");
					cont++;
					System.out.println((nToFind-cont) + " numbers left");
					g.updateLoadingBar(cont);
				}
				
				if(littleFermat(new BigInteger("2"), i) && choice == 3){
					c.write(i.toString() + "\n");
					cont++;
					System.out.println((nToFind-cont) + " numbers left");
					g.updateLoadingBar(cont);
				}

			}
			c.flush();
			System.out.println("End");
			}catch(IOException e){System.out.println("REG");}
}

	
	public static boolean slowOne(BigInteger x){
		for(BigInteger j = BigInteger.valueOf(2); j.min(x.divide(BigInteger.valueOf(2)).add(BigInteger.ONE)) == j ; j = j.add(BigInteger.ONE)){
			if(x.mod(j).equals(BigInteger.ZERO))
				return false;
		}
		return true;
	}

	public static boolean slowThree(BigInteger x){
		for(BigInteger j = BigInteger.valueOf(3); j.min(x.sqrt().add(BigInteger.ONE)) == j ; j = j.add(BigInteger.TWO)){
			if(x.mod(j).equals(BigInteger.ZERO))
				return false;
		}
		return true;
	}
	
    public static boolean littleFermat(BigInteger a, BigInteger p){
        if(a.modPow(p.subtract(BigInteger.ONE), p).equals(BigInteger.ONE))
        	return true;          
        return false;
    }


}