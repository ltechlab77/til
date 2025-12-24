import java.util.Random;
import java.util.Scanner;

public class Janken {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("じゃんけんをしてください");
            System.out.println("0: グー  1: チョキ  2: パー");

            int player = scanner.nextInt();
            int computer = random.nextInt(3);

            System.out.println("あなた: " + hand(player));
            System.out.println("相手: " + hand(computer));

            if (player == computer) {
                System.out.println("あいこ");
            } else if (
                (player == 0 && computer == 1) ||
                (player == 1 && computer == 2) ||
                (player == 2 && computer == 0)
            ) {
                System.out.println("勝ち");
                break;
            } else {
                System.out.println("負け");
                break;
            }
        }

        scanner.close();
    }

    static String hand(int num) {
        switch (num) {
            case 0:
                return "グー";
            case 1:
                return "チョキ";
            case 2:
                return "パー";
            default:
                return "不正入力";
        }
    }
}
