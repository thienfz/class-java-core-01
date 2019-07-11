import java.util.Scanner;

public class Lesson1 {

	public static void main(String[] args) {
//		float a1, b1, c1, a2, b2, c2;
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            a1 = sc.nextFloat();
//            a2 = sc.nextFloat();
//            b1 = sc.nextFloat();
//            b2 = sc.nextFloat();
//            c1 = sc.nextFloat();
//            c2 = sc.nextFloat();
		// giai he phuong trinh bang dinh thuc 
//            float D = (a1 * b2) - (a2 * b1);
//            float Dx = (c1 * b2) - (c2 * b1);
//            float Dy = (a1 * c2) - (a2 * c1);
//            System.out.println("DDXDY:" + D + ":" + Dx + ":" + Dy);
//            if (D == 0) {
//                if (Dx == 0) {
//                    System.out.println("VSN");
//                } else {
//                    System.out.println("VN");
//                }
//            } else {
//                float x = Dx / D;
//                float y = Dy / D;
//                System.out.println("Nghiem cua phuong trinh la: ");
//                System.out.println("x=" + x);
//                System.out.println("y=" + y);
//            }
//            System.out.println("===" + i + "===");
//        }
//        sc.close();
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so an cua hpt: ");
		n = sc.nextInt();
		float[][] A = new float[n][n + 1];

		// Nhap ma tran he so
		System.out.println("Nhap ma tran he so:");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n + 1; j++) {
				System.out.print("A[" + i + "][" + j + "]:");
				A[i][j] = sc.nextFloat();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n + 1; j++) { // csam5000 
				System.out.print("\t ");
				System.out.print(A[i][j]);
			}
			System.out.println();
		}
		// int char double float 
		// ConNguoi tuoi int ten string ...
	// String = "thien" = 5 char [t,h,i,e,n]
		//BigInteger highValue, lowValue // 8888-9999  
		// String BigInteger 
		// Tinh dinh thuc cua ma tran A
		float D = 0;
		for (int i = 0; i < n; i++) {
			float temp = 1;
			for (int j = 0; j < n; j++) {
				temp = temp * A[(i + j) % n][j % n];
				System.out.print(A[(i + j) % n][j % n] + "\t");
			}
			System.out.println("add " + temp);
			D = D + temp;
			temp = 1;
			for (int j = 0; j < n; j++) {
				temp = temp * A[(i - j + n) % n][j % n];
				System.out.print(A[(i - j + n) % n][j % n] + "\t");
			}
			System.out.println("sub " + temp);
			D = D - temp;
		}
		// end of D(A)
		System.out.println("==endofD===" + D);

		// Tinh cac dinh thuc con Dx
		float[] Dx = new float[n];
		for (int k = 0; k < n; k++) {
			Dx[k] = 0;
			for (int i = 0; i < n; i++) {
				float temp = 1;
				for (int j = 0; j < n; j++) {
					if (j != k) {
						System.out.print(A[(i + j + n) % n][j % n] + "\t");
						temp = temp * A[(i + j + n) % n][j % n];
					} else {
						temp = temp * A[(i + j + n) % n][n];
						System.out.print(A[(i + j + n) % n][n] + "\t");
					}
				}

				System.out.println("add " + temp);
				Dx[k] = Dx[k] + temp;
				temp = 1;
				for (int j = 0; j < n; j++) {
					if (j != k) {
						System.out.print(A[(i - j + n) % n][j % n] + "\t");
						temp = temp * A[(i - j + n) % n][j % n];
					} else {
						temp = temp * A[(i - j + n) % n][n];
						System.out.print(A[(i - j + n) % n][n] + "\t");
					}
				}

				System.out.println("sub " + temp);
				Dx[k] = Dx[k] - temp;
			}
			System.out.println("==endofDj===" + Dx[k]);
		}
		System.out.println("D:" + D);
		for (int i = 0; i < Dx.length; i++) {
			System.out.println("Dx" + i + ":" + Dx[i]);
		}

		// Ket luan
		if (D == 0) {
			System.out.println("PHUONG TRINH VO NGHIEM / VO SO NGHIEM ");
		} else {
			System.out.println("Phuong trinh co " + n + " nghiem la");
			for (int i = 0; i < Dx.length; i++) {
				System.out.println("x" + (i + 1) + "= " + (Dx[i] / D));
			}
		}
		sc.close();

	}

}
