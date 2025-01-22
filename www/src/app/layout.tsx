import { PropsWithChildren } from "react";

import { Metadata } from "next";

import { BaseLayout } from "@/components/base-layout";

import "./globals.css";

export const metadata: Metadata = {
  title: "りさプロ",
  description:
    "情報理工学域I類メディア情報学プログラムの2年次の授業「メディア情報学実験」で作成しました。 JavaおよびSwingを用いて作成した、コマンドにてキャラクターを操作してゴールを目指すゲームです。",
};

export default function RootLayout({ children }: PropsWithChildren) {
  return (
    <html lang="ja">
      <body>
        <BaseLayout>{children}</BaseLayout>
      </body>
    </html>
  );
}
