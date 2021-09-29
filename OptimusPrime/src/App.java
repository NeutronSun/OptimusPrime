import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.math.*;

public class App {

	public static void main(String[] args) {
		BigInteger n = new  BigInteger("10");
		n = n.pow(1);
		BigInteger end = new  BigInteger("10");
		end = end.pow(5);
		BigInteger cont = new BigInteger("0");
        long timeS = 0;
		GuiData g = new GuiData(n, end);
		g.inizializeFrame();
		
		if(n.equals(BigInteger.ONE))
			n = n.add(BigInteger.ONE);

		try{
			FileWriter a, b, c;

			a = new FileWriter("alg1.txt", false);
			b = new FileWriter("alg2.txt", false);
			c = new FileWriter("alg3.txt", false);

			if(n.equals(BigInteger.TWO)){
			   b.write("Prime: 2| Time: undefined nanosec\n" );
			   c.write("Prime: 2| Time: undefined nanosec\n" );
			}
			else if(n.mod(BigInteger.TWO).equals(BigInteger.ZERO))
				n=n.add(BigInteger.ONE);
			
			for(BigInteger i = n; i.min(end) == i; i = i.add(BigInteger.valueOf(1))){

				timeS = System.nanoTime();
				/*
				if(slowOne(i))
					a.write("Prime: " + i + "| Time: " + (System.nanoTime() - timeS) + " nanosec" + "\n" );
				
				timeS = System.nanoTime();
				if(!(i.mod(BigInteger.TWO).equals(BigInteger.ZERO)) && slowThree(i))
					b.write("Prime: " + i + "| Time: " + (System.nanoTime() - timeS) + " nanosec" + "\n" );
				*/
				timeS = System.nanoTime();
				if(!(i.mod(BigInteger.TWO).equals(BigInteger.ZERO)) && littleFermat(new BigInteger("2"), i)){
					c.write(cont + "|Prime: " + i + "| Time: " + (System.nanoTime() - timeS) + " nanosec" + "\n" );
					cont = cont.add(BigInteger.ONE);
				}
				g.updateLoadingBar(i);
				System.out.println(i);
			}
			a.flush();
			b.flush();
			c.flush();
			System.out.println("End");
			}catch(IOException e){}
}

	
	public static boolean slowOne(BigInteger x){
		for(BigInteger j = BigInteger.valueOf(2); j.min(x.divide(BigInteger.valueOf(2)).add(BigInteger.ONE)) == j ; j = j.add(BigInteger.ONE)){
			if(x.mod(j).equals(BigInteger.ZERO))
				return false;
		}
		return true;
	}

	public static boolean slowTwo(BigInteger x){
		for(BigInteger j = BigInteger.valueOf(3); j.min(x.divide(BigInteger.valueOf(2)).add(BigInteger.ONE)) == j ; j = j.add(BigInteger.TWO)){
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