/**
 * 
 */
package com.firstdevelop.boot.entity;

/**
 * 
 */
public class Day1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* 
		 * 1.演算処理
		 */
        System.out.print(5 + " + " + 2 + " = ");
        System.out.println(5+2);    //  足し算
        System.out.print(5 + " - " + 2 + " = ");
        System.out.println(5-2);    //  引き算
        System.out.print(5 + " * " + 2 + " = ");
        System.out.println(5*2);    //  掛算
        System.out.print(5 + " / " + 2 + " = ");
        System.out.print(5/2);      //  割り算
        System.out.print(" 余り ");
        System.out.println(5%2);    //  剰余
        System.out.println("ABC" + "DEF"); // 「ABCDEF」と表示
        System.out.println("答え："+3); // 「答え:3」と表示
        
        /* 
		 * 2.変数
		 */
        int a;           // 変数の宣言
        int b = 3;      //  初期化と代入を同時に行う。
        int add,sub;    //  複数の変数を同時に宣言
        double avg;     //  int以外の変数を宣言
        a = 6;  //  代入（最初に値を入れるので、”初期化”と言う。
        add = a + b;            //  a,bの和を求める。
        sub = a - b;            //  a,bの差を求める。
        avg = (a + b) / 2.0;    //  a,bの平均値を求める。
        System.out.println(a + " + " + b + " = " + add);
        System.out.println(a + " - " + b + " = " + sub);
        System.out.println(a + "と" + b + "の平均値：" + avg);
        
		/* 
		 * 3.代入演算子
		 */
        // 使用する変数の定義
        int a1=2,b1=2,c1=2,d1=2;    // 変数の宣言(1)
        int a2=2,b2=2,c2=2,d2=2;    // 変数の宣言(2)
        //  普通の演算による計算と代入
        a1 = a1 + 1;
        b1 = b1 - 1;
        c1 = c1 * 2;
        d1 = d1 / 2;
        //  代入演算による計算
        a2 += 1;
        b2 -= 1;
        c2 *= 2;
        d2 /= 2;
        System.out.println("a1=" +a1+ " b1=" +b1+ " c1=" +c1+ " d1=" +d1);
        System.out.println("a2=" +a2+ " b2=" +b2+ " c2=" +c2+ " d2=" +d2);
        
		/* 
		 * 4.キャストとデータの型変換 
		 */
        int e;
        double f,g,h;
        e = (int)1.23;  //  キャストで代入
        f = 1.23;
        g = 10;         //  キャストなしで代入
        h = (double)g;  //  キャストありで代入
        System.out.println("e=" + e + " f=" + f + " g=" + g + " h=" + h);

        /* 
		 * 5.文字列の変数 
		 */
        String s1,s2,s3;
        s1 = "ABC";     //  s1に文字列「ABC」を代入
        s2 = "DEF";     //  s1に文字列「ABC」を代入
        s3 = s1 + s2;   //  s3に、s1とs2を結合したものを代入
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 + s2);
        System.out.println(s3);
        
        /* 
		 * 6.定数
		 * finalがついた変数は値を変えられない
		 */
        final int NUMBER = 100;
        final String STRING = "Hoge";
        System.out.println(NUMBER); // NUMBER = 100;
        System.out.println(STRING); // STRING = "fuga";

	}

}
