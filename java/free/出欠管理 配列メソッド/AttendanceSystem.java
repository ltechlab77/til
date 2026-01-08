import java.util.Scanner;

public class AttendanceSystem {
    static String[] students = new String[30];
    static boolean[] attendance =new boolean[30];
    static int count = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (true){
            showMenu();
            int choice = sc.nextInt();

            if (choice == 1){
                addStudent(sc);
            }else if (choice == 2){
                markAttendance(sc);
            }else if (choice == 3){
                showAll();
            }else if (choice == 0){
                System.out.println("終了します");
                break;
            }else {
                System.out.println("無効な選択です");
            }
        }
    }

    //メニューの表示
    static void showMenu() {
        System.out.println("--- 出欠管理システム ---");
        System.out.println("1: 生徒追加");
        System.out.println("2: 出欠登録");
        System.out.println("3: 一覧表示");
        System.out.println("0: 終了");
        System.out.println("選択: ");
    }

    //生徒追加
    static void addStudent(Scanner sc){
        if (count >= students.length){
            System.out.println("これ以上追加できません");
            return;
        }

        System.out.println("生徒名を入力: ");
        students[count] = sc.next();
        attendance[count] = false; //初期は欠席
        count++;

        System.out.println("生徒を追加しました");
    }

    //出欠登録
    static void markAttendance(Scanner sc){
        showAll();
        System.out.println("番号を選択: ");
        int index = sc.nextInt();

        if (index < 0 || index >= count){
            System.out.println("番号が不正です");
            return;
        }

        System.out.println("出席なら1、欠席なら0: ");
        int input = sc.nextInt();
        attendance[index] = (input == 1);

        System.out.println("出席を登録しました");
    }

    //一覧表示
    static void showAll(){
        System.out.println("--- 一覧 ---");
        for (int i = 0; i < count; i++){
            String status = attendance[i] ? "出席" : "欠席";
            System.out.println(i + ": " + students[i] + " - " + status);
        }
    }
}