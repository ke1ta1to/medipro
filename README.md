# medipro

## メンバー

- ぬかにわ
- えぐち
- まくら

## ディレクトリ構成

```
medipro
├── docker/ # Docker (サーバー)
├── www/ # Webサイト
├── infra/ # AWSのインフラ構成
├── lib/ # Javaのライブラリ
├── saves/ # セーブデータ (gitignore)
└── src
    └── net
        └── keitaito
            ├── medipro
            │   ├── app/ # アプリケーションのメイン
            │   ├── commands/ # ゲーム内コマンド
            │   ├── components/ # 共通コンポーネント
            │   ├── fonts/ # ゲームで使用するフォント
            │   ├── helpdialog/ # ヘルプダイアログ (MVC)
            │   ├── howtoplay/ # 遊び方 (MVC)
            │   ├── images/ # ゲームで使用する画像
            │   ├── input/ # ゲーム内入力 (MVC)
            │   ├── level/ # レベル選択画面 (MVC)
            │   ├── menubar/ # メニューバー (MVC)
            │   ├── save/ # セーブデータ管理
            │   ├── setting/ # 設定画面 (MVC)
            │   ├── stage/ # ステージ画面 (MVC)
            │   ├── stagemenu/ # ステージメニュー (MVC)
            │   ├── stagemenubar/ # ステージメニューバー (MVC)
            │   ├── tiles/ # ゲーム内タイル
            │   ├── top/ # タイトル画面 (MVC)
            │   ├── utils/ # ユーティリティ
            │   ├── workspace/ # プレイ画面 (MVC)
            │   ├── world_templates # ワールドのテンプレート
            │   │   ├── 0_void # 虚空ワールドテスト用
            │   │   │   ├── example_input.txt # 入力例
            │   │   │   ├── metadata.json # タイトルなどのメタデータ
            │   │   │   ├── thumbnail.png # サムネイル画像
            │   │   │   └── world.txt # ワールドの定義
            │   │   ├── 1_tutorial
            │   │   ├── 2_walking
            │   │   ├── 3_spike
            │   │   ├── 4_hook
            │   │   ├── 5_portal
            │   │   ├── 6_null
            │   │   ├── 7_null
            │   │   └── 8_null
            │   └── worlds/ # ワールド管理
            └── mediproserver/ # サーバー

```

## 初期構成

1. [Project Manager for Java](https://github.com/microsoft/vscode-java-dependency?tab=readme-ov-file#project-manager-for-java)を使用してプロジェクトを管理します。README を読んでおいてください。
2. 必要な拡張機能があります。VSCode の拡張機能タブの検索に`@recommended`を入れて、全て入っているか確認してください。
3. 起動するには`F5`を押してください。自動でコンパイルして立ち上がってきます。

## サーバーについて

ローカルでサーバーを立ち上げるには、`net.keitaito.medipro.mediproserver.App`を実行してください。

テスト用データを使用する場合は、`net.keitaito.medipro.mediproserver.Seed`を実行してください。

データは sqlite を経由して`./medipro.db`に保存されます。内容を確認したい場合は、VSCode の拡張機能や、[DB Browser for SQLite](https://sqlitebrowser.org/)を使用してください。

## 想定コマンド

| コマンド      | 内容                             | オプション                                 |
| ------------- | -------------------------------- | ------------------------------------------ |
| [option] | x 軸方向に移動する。             | left:左方向,right:右方向                   |
| wait [option] | [option]までの処理を止めておく。 | n:(n \in Z),on grounded:地面につくまで待つ |
| stop          | 移動や加速を停止する。           | -                                          |
| jump          | ジャンプする                     | -                                          |
| hook [option] | [option]方向にフックを伸ばす。   | (up,down)+(left,right)                     |
|unhook|フックを離す。|-|
