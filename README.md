# medipro

## ディレクトリ構成

```
medipro/
├── src/
│ ├── model/ # ゲームのロジックやデータを管理するクラス
│ ├── view/ # UI を表示するクラス（Swing の GUI コンポーネントを含む）
│ ├── controller/ # ユーザーの入力を処理し、Model と View をつなぐクラス
│ ├── utils/ # 共通のユーティリティクラスや定数
│ └── Main.java # エントリポイント
└── resources/ # 画像、サウンドなどのアセット
```

### 各ディレクトリの役割

- **model/**: ゲームのルールやデータ管理、ビジネスロジックを担当。例えば、ゲームのスコアやプレイヤーの状態、ゲームステートのクラス。

- **view/**: ユーザーに表示される部分を担当。Swing コンポーネント（`JFrame`、`JPanel`など）を使って UI を構築し、プレイヤーに見える画面や画面要素を扱う。

- **controller/**: ユーザー入力（キーボードやマウスの操作）を処理し、Model と View のやりとりを行う。ユーザーの操作をゲームロジックに反映させたり、UI の更新を指示する役割。

- **utils/**: ゲーム全体で使われる共通のユーティリティクラスや定数を格納。たとえば、画面サイズや定数の定義、便利メソッドなどをここに置く。

- **resources/**: 画像、サウンド、フォントなどの外部リソースを配置。ファイルのロードや管理が容易になる。

## その他

- [Project Manager for Java](https://github.com/microsoft/vscode-java-dependency?tab=readme-ov-file#project-manager-for-java)を使用してプロジェクトを管理します。
