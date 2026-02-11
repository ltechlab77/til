# コレクションフレームワーク

データ（オブジェクト）をまとめて管理するための仕組み 
```java
//配列を使ったコード
String[] names = new String[3];//配列準備
//追加
names[0] = "A";
names[1] = "B";
names[2] = "C";

System.out.println(names[1]);
```

```java
//ArrayListを使ったコード
import java.util.ArrayList;
//Arraylist準備
ArrayList<String> names = new ArrayList<String>();
//追加
names.add("A");
names.add("B");
names.add("C");

System.out.println(names.get(1));
```

- import文の記述
- <>記号を使って格納するインスタンスの型の指定
- 宣言時のサイズ指定は要素は随時追加可能

### ① List（リスト）

特徴 

- 順番を持つ  
- 同じ値OK  
- インデックスで取得できる

代表クラス

- ArrayList
- LinkedList

```java
import java.util.ArrayList;

ArrayList<String> names = new ArrayList<>();
names.add("太郎");
names.add("花子");
```

### ② Set（セット）
特徴

- 順番なし
- 重複NG

```java
import java.util.HashSet;

HashSet<String> fruits = new HashSet<>();
fruits.add("りんご");
fruits.add("りんご"); // 追加されない
```

### ③ Map（マップ）
特徴

- キーと値のセット
- 辞書のような仕組み

```java
import java.util.HashMap;

HashMap<String, Integer> scores = new HashMap<>();
scores.put("太郎", 80);
```

## イテレータ(Iterator)
コレクションの中身を順番に1つず取り出す  
要素を順に取り出すほかの方法
- for文

```java
fro (int i = 0; i <リスト変数.size(); i++) {
    リスト変数.get(i)
    }    
//ex
    fro (int i = 0; i < name.size(); i++) {
    System.out.println(names.get(i));
    }    
```

拡張for文
```java
for (リスト要素の型 e : リスト変数){

}

//ex
for(String s : names){
    System.out.println(s);
}
```

使い方
```java
import java.util.ArrayList;
import java.util.Iterator;

ArrayList<String> names = new ArrayList<>();
names.add("太郎");
names.add("花子");

Iterator<String> it = names.iterator();

while (it.hasNext()) {
    String name = it.next();
    System.out.println(name);
}
```
メソッド

- hasNext() 次がある？
- next() 次を取り出す
- remove() 今の要素を削除

ループ中の削除  
//基本のリスト内の削除方法はこれ？
```java
Iterator<String> it = names.iterator();

while (it.hasNext()) {
    if (it.next().equals("太郎")) {
        it.remove();  // 安全
    }
}
```

## LinkedList
連結リスト  
要素の挿入や削除に対する違い  
ArrayList : 削除→後ろを全部ずらす  
LinkedList : 削除→つなぎなおすだけ  

## java.util.HashSet

重複した値を格納しようとすると無視される  
set() やget() がない
- set には順番という概念がない
要素は順不同で取り出される  
よく使うメソッド  
add() 追加
remove() 削除
contains() 含まれているか確認
size() 要素数

```java
//使い方例
import java.util.HashSet;

HashSet<String> set = new HashSet<>();

set.add("りんご");
set.add("みかん");
set.add("りんご"); // 追加されない

System.out.println(set.size()); // 2
```
使う場面  
重複を防ぎたい  
高速検索したい  
順番を気にしない

例：ログインユーザー管理  
    タグ一覧  
    一意なID管理  

## HashMap
キー（Key）と値（Value）をセットで管理するコレクション

```java
//例
import java.util.HashMap;

HashMap<String, Integer> map = new HashMap<>();

map.put("太郎", 80);
map.put("花子", 90);

System.out.println(map.get("太郎")); // 80
```
