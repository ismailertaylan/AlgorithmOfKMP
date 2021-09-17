import java.util.Random;
import java.util.Scanner;

public class KMPmetintarama {
	void KMParama(String B, String A) {
		int sayac = 0;
		int m = B.length();
		int n = A.length();
		int[] indisler = new int[n];
		int holder[] = new int[m];
		int j = 0;
		holderhesapla(B, m, holder);
		int i = 0;
		while (i < n) {
			if (B.charAt(j) == A.charAt(i)) {
				j++;
				i++;
			}
			if (j == m) {
				indisler[sayac++] = i - j;
				j = holder[j - 1];
			} else if (i < n && B.charAt(j) != A.charAt(i)) {
				if (j != 0)
					j = holder[j - 1];
				else
					i = i + 1;
			}
		}
		System.out.println("Eslestirme Sonucu: " + sayac + " farkli eslestirme gerceklesti.");
		System.out.println(A);
		System.out.println("B Metninin bulundugu konumlar: ");
		for (i = 0; i < sayac; i++) {
			System.out.print(indisler[i] + " ");
		}
	}

	void holderhesapla(String B, int m, int holder[]) {
		int len = 0;
		int i = 1;
		holder[0] = 0;
		while (i < m) {
			if (B.charAt(i) == B.charAt(len)) {
				len++;
				holder[i] = len;
				i++;
			} else {

				if (len != 0) {
					len = holder[len - 1];

				} else {
					holder[i] = len;
					i++;
				}
			}
		}
	}

	public static void main(String args[]) {
		System.out.println("Lutfen n ve m degerleri giriniz: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int i, sans;
		String A = "", B = "";
		Random r = new Random();
		for (i = 0; i < n; i++) {
			sans = r.nextInt(2);
			if (sans == 1) {
				A += "1";
			} else {
				A += "0";
			}
		}
		for (i = 0; i < m; i++) {
			sans = r.nextInt(2);
			if (sans == 1) {
				B += "1";
			} else {
				B += "0";
			}
		}
		new KMPmetintarama().KMParama(B, A);
	}
}
